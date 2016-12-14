package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.Task;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierTask;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class TaskController {

	@Autowired
	private IMetierClient metierClient;
	
	@Autowired
	private IMetierTask metierTask;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	//show list note
	@RequestMapping(value = "listTasks", method = RequestMethod.GET)
	public String listNote(Model model, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listTasks", metierTask.listTasks(0, 200,client));
		
		return "tasks/tasks";
	}
	
	//redirect to form to add Task
	@RequestMapping(value = "task", method = RequestMethod.GET)
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "tasks/task";
	}
	
	//save or update task
	@RequestMapping(value = "saveTask", method = RequestMethod.POST)
	public ModelAndView saveTask(Model model,Task task,String action, Principal principal,RedirectAttributes redirecAtrributes) {
		Message message=null;
		
		Client client = metierClient.getClientByUserName(principal.getName());
		if(task.getIdTask()==null){
			//save new Task
			metierTask.addTask(task, client);
			message = new Message("The Task has been successfuly saved","success");
		}
		else{
			//update the task
			metierTask.updateTask(task, client);
			message = new Message("The Task has been successfuly saved","success");
		}
		
		redirecAtrributes.addFlashAttribute("message", message);
		
		if(action=="save"){
			return new ModelAndView("redirect:listTasks");
		}
		else{
			return new ModelAndView("redirect:task");
		}
	}
	
	
	//redirect to form to update Task
	@RequestMapping(value = "editTask", method = RequestMethod.GET)
	public String editTask(Model model, Long task, Principal principal ) {
		Client client = metierClient.getClientByUserName(principal.getName());
		Task  taskToUpdate = metierTask.getTask(task, client);
		model.addAttribute("task", taskToUpdate);
		return "tasks/task";
	}
	
	//delete Task
	@RequestMapping(value = "deleteTask", method = RequestMethod.GET)
	public ModelAndView deleteTask(Model model, Long task, Principal principal,RedirectAttributes redirecAtrributes ) {
		Client client = metierClient.getClientByUserName(principal.getName());
        metierTask.deleteTask(task, client);
        Message message = new Message("The Task has been successfuly deleted","success");
        redirecAtrributes.addFlashAttribute("message", message);
        
        return new ModelAndView("redirect:listTasks");
	}
	

	
}
