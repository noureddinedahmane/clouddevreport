package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.org.entities.Client;
import com.org.entities.Note;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierNote;

@Controller
@RequestMapping(value = "/admin/")
public class NoteController {

	@Autowired
	private IMetierNote metierNote;
	
	@Autowired
	private IMetierClient metierClient;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// redirect to form to create note	
	@RequestMapping(value = "note", method = RequestMethod.GET)
	public String newNote(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listNotes", metierNote.listClientNote(0, 200, client));
		return "notes/note";
	}
	
	// redirect to form to create note	
	@ResponseBody
	@RequestMapping(value = "saveNote", method = RequestMethod.POST, produces = "application/json")
	public String saveNote(HttpServletRequest request, Principal principal) {
		String  message="";
		Client client = metierClient.getClientByUserName(principal.getName());
		
		String idNote = request.getParameter("idNote");
		String subjectNote = request.getParameter("subjectNote");
		String contentNote = request.getParameter("contentNote");
		
		if(idNote==""){
			
			//add a new Note
			Note note = new Note();
			note.setDate(new Date());
			note.setTitle(subjectNote);
			note.setNote(contentNote);
			note.setClient(client);
			
			metierNote.addNote(note, client);
			idNote=note.getIdNote()+"";
			message="The Note has been successfuly saved";
			
			
		}else{
			
			Note note = metierNote.getNote(new Long(idNote), client);
			note.setTitle(subjectNote);
			note.setNote(contentNote);
			metierNote.updateNote(note, client);
			message="The Note has been successfuly updated";
		}
		
		String json[]={message,idNote};
		Gson gs = new Gson();
		
		return gs.toJson(json);
	}
	
	
	// redirect to form to create note	
		@ResponseBody
		@RequestMapping(value = "deleteNote", method = RequestMethod.POST, produces = "application/json")
		public String deleteNote(HttpServletRequest request, Principal principal) {
			String  message="";
			Client client = metierClient.getClientByUserName(principal.getName());
			String idNote = request.getParameter("idNote");
			
			if(metierNote.deleteNote(new Long(idNote), client)){
				message="This item has been successfuly deleted";
			}else{
				message="Error, This item was not deleted, try again";
			}
			
			String json[]={message,idNote};
			Gson gs = new Gson();
			
			return gs.toJson(json);
			
		}

	
	
	
}
