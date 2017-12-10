package com.org.contoller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.org.entities.Approvement;
import com.org.entities.ApprovementGroup;
import com.org.entities.Client;
import com.org.entities.Configuration;
import com.org.entities.Deviation;
import com.org.entities.DeviationFilterForm;
import com.org.entities.Domain;
import com.org.entities.Notification;
import com.org.helper.DeviationFormValidation;
import com.org.metierInter.GeneratePDF;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierDeviationReport;

@Controller
@RequestMapping(value = "/admin/")
public class DeviationContoller {

	@Autowired
	private IMetierDeviationReport metier;
	
	@Autowired
	private IMetierClient metierClient;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	
	}
	
	
	//generate a pdf
	@ResponseBody
	@RequestMapping(value = "generatePDF", method = RequestMethod.GET)
	public ResponseEntity<byte[]>  newDeviation(Model model,Long idDeviation, Principal principal) throws IOException {
		//get the Deviation 
		Deviation deviation = metier.getDeviationById(idDeviation);
		GeneratePDF pdf = new GeneratePDF( 10f, 10f, 100f, 0f);
		ByteArrayOutputStream docOut = pdf.getPDFOutput(deviation);
		
		//create http header for pdf doc
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = deviation.getDeviationRef() + "-" + "deviation.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    
		return new ResponseEntity<byte[]>(docOut.toByteArray(), headers, HttpStatus.OK);
	}
	
	//new domain
	@RequestMapping(value = "deviation", method = RequestMethod.GET)
	public String newDeviation(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = client.getDomain();
		Configuration config = domain.getConfiguration();
		DeviationFormValidation formValid = this.getDeviationFormValidation(config);
		Deviation deviation = new Deviation();
		
		deviation.setDeviationRef(generateDeviationRef(domain.getConfiguration(), domain));
		deviation.setRequestedBy(client.getName() + " " + client.getPrenom());
		deviation.setPosition(client.getPosition());
		
		model.addAttribute("deviation", deviation);
		model.addAttribute("configuration", config);
		model.addAttribute("formValid", formValid);
		model.addAttribute("approvements", null);
		model.addAttribute("domainName", domain.getDomainName());
		model.addAttribute("listDeviationTypes", metier.listDeviationTypeByDomain(domain));
		
		return "deviation/deviation";
	}
	
	//list deviation
	@RequestMapping(value = "deviations", method = RequestMethod.GET)
	public String listDeviations(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = client.getDomain();
		
		model.addAttribute("listDeviations", metier.listDeviation(domain, client, 0, 100));
		model.addAttribute("listDeviationTypes", metier.listDeviationTypeByDomain(domain));
		model.addAttribute("deviationFilterForm", new DeviationFilterForm());
		
		return "deviation/deviations";
	}
	
	//list deviation
	@RequestMapping(value = "deviationFilter", method = RequestMethod.POST)
	public String deviationFilter(Model model, DeviationFilterForm deviationFilterForm, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = client.getDomain();
		
		model.addAttribute("listDeviations", metier.filterDeviation(deviationFilterForm, domain));
		model.addAttribute("listDeviationTypes", metier.listDeviationTypeByDomain(domain));
		model.addAttribute("deviationFilterForm", deviationFilterForm);
		
		return "deviation/deviations";
	}
	
	//save deviation
	@RequestMapping(value = "saveDeviation", method = RequestMethod.POST)
	public ModelAndView saveDeviation(Locale locale, Model model, Deviation deviation, HttpServletRequest request, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = client.getDomain();
		Configuration config = domain.getConfiguration();
		
		
		List<ApprovementGroup> listDomainApprovementGroups = metier.listApprovementGroupByDomain(domain);
		
		if(deviation.getIdDeviation()==null) {
			//add a new Deivation
			
			deviation.setDateCreation(new Date());
			deviation.setDomain(domain);
			deviation.setClient(client);
			deviation.setDeviationRef(this.generateDeviationRef(config, domain));
			deviation.setRequestedBy(client.getName() + " " + client.getPrenom());
			deviation.setPosition(client.getPosition());
			
			//save deviation
			metier.addDeviation(deviation, client);
			
			//save approvementGroup
			for(ApprovementGroup approvementGroup : listDomainApprovementGroups) {

				Approvement approvement = new Approvement();
				approvement.setClient(client);
				approvement.setDeviation(deviation);
				approvement.setApprovementGroup(approvementGroup);
				
				//save the approvement to the deviation
				metier.addApprovement(approvement, client);
				
			}
			
			
			//get the list of users in the domain
			List<Client> domainUsers = metierClient.listUsersByDomain(domain);
			for(Client user: domainUsers) {
				//add a notification
				Notification notification = new Notification();
				notification.setTitleNotification(messageSource.getMessage("label.newDeviationAdded", null, locale));
				notification.setBodyNotification(messageSource.getMessage("label.clickToViewDeviation", null, locale));
				notification.setRead(false);
				notification.setIdDeviation(deviation.getIdDeviation().toString());
				notification.setClient(user);
				
				metier.addNotication(notification);
			}
		}else {
			//modify deviation
		}
		
		return new ModelAndView("redirect:deviations");
	}
	
	//editDeviation
	@RequestMapping(value = "editDeviation", method = RequestMethod.GET)
	public String editDeviation(Model model, Long idDeviation, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Domain domain = client.getDomain();
		Configuration config = domain.getConfiguration();
		DeviationFormValidation formValid = this.getDeviationFormValidation(config);
		Deviation deviation = metier.getDeviationById(idDeviation);

		
		model.addAttribute("deviation", deviation);
		model.addAttribute("configuration", config);
		model.addAttribute("formValid", formValid);
		model.addAttribute("approvements", metier.listApprovement(deviation, client));
		model.addAttribute("domainName", domain.getDomainName());
		model.addAttribute("listDeviationTypes", metier.listDeviationTypeByDomain(domain));
		
		return "deviation/deviation";
	}

	
	//generate Deviation reference
	private String generateDeviationRef(Configuration config, Domain domain) {
		String devRef = config.getDeviationRefPrefix();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		Long deviationNumber = metier.getNumberOfDeviationByDomain(domain);
		devRef += "-" + year + "-" + deviationNumber;
		return devRef;
	}
	
	//return a Deviation form validator
	private DeviationFormValidation getDeviationFormValidation(Configuration config) {
		
		DeviationFormValidation formValid = new DeviationFormValidation();
		
		String required  = "input_required";
		String required_startDate  = "input_required_start_date";
		String required_endDate  = "input_required_end_date";
		
		if(config.isDeviationRef())
			formValid.setDeviationRef(required);
		
		if(config.isDeviationRiskCategory())
			formValid.setDeviationRiskCategory(required);
		
		if(config.isRequestedBy())
			formValid.setRequestedBy(required);
		
		if(config.isSignature())
			formValid.setSignature(required);
		
		if(config.isPosition())
			formValid.setPosition(required);
		
		if(config.isDeviationType())
			formValid.setDeviationType(required);
		
		if(config.isSollZustand())
			formValid.setSollZustand(required);
		
		if(config.isIstZustand())
			formValid.setIstZustand(required);
		
		if(config.isStartDatePeriod())
			formValid.setStartDatePeriod(required_startDate);
		
		if(config.isEndDatePeriod())
			formValid.setEndDatePeriod(required_endDate);
		
		if(config.isProduct())
			formValid.setProduct(required);
		
		if(config.isAnlage())
			formValid.setAnlage(required);
		
		
		return formValid;
	}
}
