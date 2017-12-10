package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoDeviationReport;
import com.org.entities.Account;
import com.org.entities.Approvement;
import com.org.entities.ApprovementGroup;
import com.org.entities.Attachement;
import com.org.entities.Client;
import com.org.entities.Configuration;
import com.org.entities.Deviation;
import com.org.entities.DeviationFilterForm;
import com.org.entities.DeviationType;
import com.org.entities.Domain;
import com.org.entities.Historical;
import com.org.entities.Notification;
import com.org.entities.UserApprovementGroup;
import com.org.metierInter.IMetierDeviationReport;

@Transactional
public class ImpMetierDeviationReport implements IMetierDeviationReport{

	private IDaoDeviationReport dao;
	
	
	public IDaoDeviationReport getDao() {
		return dao;
	}

	public void setDao(IDaoDeviationReport dao) {
		this.dao = dao;
	}

	@Override
	public Deviation addDeviation(Deviation deviation, Client client) {
		return dao.addDeviation(deviation, client);
	}

	@Override
	public Deviation updateDeviation(Deviation deviation, Client client) {
		return dao.updateDeviation(deviation, client);
	}

	@Override
	public Deviation getDeviation(String deviationRef, Client client) {
		return dao.getDeviation(deviationRef, client);
	}

	@Override
	public List<Deviation> listDeviation(Domain domain, Client client, int min,
			int max) {
		return dao.listDeviation(domain, client, min, max);
	}

	@Override
	public Attachement addAttachment(Attachement attachement,
			Deviation deivation, Client client) {
		return dao.addAttachment(attachement, deivation, client);
	}

	@Override
	public Attachement getAttachement(Long idAttachement, Client client) {
		return dao.getAttachement(idAttachement, client);
	}

	@Override
	public void deleteAttachement(Long idAttachement, Client client) {
		dao.deleteAttachement(idAttachement, client);
		
	}

	@Override
	public List<Attachement> listAttachement(Long idDeviation, Client client) {
		return dao.listAttachement(idDeviation, client);
	}

	@Override
	public Historical addHistorical(Historical historical, Deviation deivation,
			Client client) {
		return dao.addHistorical(historical, deivation, client);
	}

	@Override
	public List<Historical> listHistorical(Long idDeviation, Client client) {
		return dao.listHistorical(idDeviation, client);
	}

	@Override
	public Approvement addApprovement(Approvement approvement, Client client) {
		return dao.addApprovement(approvement, client);
	}

	@Override
	public Approvement updateApprovement(Approvement approvement, Client client) {
		return dao.updateApprovement(approvement, client);
	}

	@Override
	public Approvement getApprovement(Long idApprovement, Client client) {
		return dao.getApprovement(idApprovement, client);
	}

	@Override
	public List<Approvement> listApprovement(Deviation deviation, Client client) {
		return dao.listApprovement(deviation, client);
	}

	@Override
	public Domain addDomain(Domain domain, Client client) {
		return dao.addDomain(domain, client);
	}

	@Override
	public Domain updateDomain(Domain domain, Client client) {
		return dao.updateDomain(domain, client);
	}

	@Override
	public Domain getDomain(Long idDomain, Client client) {
		return dao.getDomain(idDomain, client);
	}

	@Override
	public void deleteDomain(Long idDomain, Client client) {
		dao.deleteDomain(idDomain, client);
		
	}

	@Override
	public List<Domain> listDomain(Client client) {
		return dao.listDomain(client);
	}

	@Override
	public Configuration addConfiguration(Configuration configuration,
			Domain domain, Client client) {
		return dao.addConfiguration(configuration, domain, client);
	}

	@Override
	public Configuration updateConfiguration(Configuration configuration,
			Domain domain, Client client) {
		return dao.updateConfiguration(configuration, domain, client);
	}

	@Override
	public Configuration getConfiguration(Long idConfig, Client client) {
		return dao.getConfiguration(idConfig, client);
	}

	@Override
	public ApprovementGroup addApprovementGroup(ApprovementGroup approvementGroup, Domain domain) {
		// TODO Auto-generated method stub
		return dao.addApprovementGroup(approvementGroup, domain);
	}

	@Override
	public ApprovementGroup updateApprovementGroup(ApprovementGroup approvementGroup, Domain domaint) {
		// TODO Auto-generated method stub
		return dao.updateApprovementGroup(approvementGroup, domaint);
	}

	@Override
	public void deleteApprovementGroup(Long idApprovementGroup, Domain domain) {
		// TODO Auto-generated method stub
		dao.deleteApprovementGroup(idApprovementGroup, domain);
	}

	@Override
	public ApprovementGroup getApprovementGroup(Long idApprovementGroup, Domain domain) {
		// TODO Auto-generated method stub
		return dao.getApprovementGroup(idApprovementGroup, domain);
	}

	@Override
	public List<ApprovementGroup> listApprovementGroup(Domain domain) {
		// TODO Auto-generated method stub
		return dao.listApprovementGroup(domain);
	}

	@Override
	public List<Domain> listDomainsByAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.listDomainsByAccount(account);
	}

	@Override
	public List<ApprovementGroup> listApprovementGroupByAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.listApprovementGroupByAccount(account);
	}

	@Override
	public UserApprovementGroup addUserApprovementGroup(UserApprovementGroup userApprovementGroup) {
		// TODO Auto-generated method stub
		return dao.addUserApprovementGroup(userApprovementGroup);
	}

	@Override
	public UserApprovementGroup getUserApprovementGroup(Long id) {
		// TODO Auto-generated method stub
		return dao.getUserApprovementGroup(id);
	}

	@Override
	public List<Client> listClientInUserGroup(ApprovementGroup approvementGroup) {
		// TODO Auto-generated method stub
		return dao.listClientInUserGroup(approvementGroup);
	}

	@Override
	public boolean isUserInGroup(Client client, ApprovementGroup approvementGroup) {
		// TODO Auto-generated method stub
		return dao.isUserInGroup(client, approvementGroup);
	}

	@Override
	public List<ApprovementGroup> listApprovementGroupByDomain(Domain domain) {
		// TODO Auto-generated method stub
		return dao.listApprovementGroupByDomain(domain);
	}

	@Override
	public DeviationType addDeviationType(DeviationType deviationType) {
		// TODO Auto-generated method stub
		return dao.addDeviationType(deviationType);
	}

	@Override
	public DeviationType getDeviationType(Long id) {
		// TODO Auto-generated method stub
		return dao.getDeviationType(id);
	}

	@Override
	public List<DeviationType> listDeviationTypeByDomain(Domain domain) {
		// TODO Auto-generated method stub
		return dao.listDeviationTypeByDomain(domain);
	}

	@Override
	public DeviationType updateDeviationType(DeviationType deviationType) {
		// TODO Auto-generated method stub
		return dao.updateDeviationType(deviationType);
	}

	@Override
	public void deleteDeviationType(Long id) {
		// TODO Auto-generated method stub
		dao.deleteDeviationType(id);
	}

	@Override
	public Long getNumberOfDeviationByDomain(Domain domain) {
		// TODO Auto-generated method stub
		return dao.getNumberOfDeviationByDomain(domain);
	}

	@Override
	public Notification addNotication(Notification not) {
		// TODO Auto-generated method stub
		return dao.addNotication(not);
	}

	@Override
	public Notification updateNotication(Notification not) {
		// TODO Auto-generated method stub
		return dao.updateNotication(not);
	}

	@Override
	public Notification getNotification(Long idNotification) {
		// TODO Auto-generated method stub
		return dao.getNotification(idNotification);
	}

	@Override
	public void deleteNotication(Long idNotification) {
		// TODO Auto-generated method stub
		dao.deleteNotication(idNotification);
	}

	@Override
	public List<Notification> listNotReadNotificationByClient(Client client) {
		// TODO Auto-generated method stub
		return dao.listNotReadNotificationByClient(client);
	}

	@Override
	public List<Notification> listAllNotificationByClient(Client client) {
		// TODO Auto-generated method stub
		return dao.listAllNotificationByClient(client);
	}

	@Override
	public Deviation getDeviationById(Long id) {
		// TODO Auto-generated method stub
		return dao.getDeviationById(id);
	}

	@Override
	public List<Deviation> filterDeviation(DeviationFilterForm devFilterForm, Domain domain) {
		// TODO Auto-generated method stub
		return dao.filterDeviation(devFilterForm, domain);
	}
	

}
