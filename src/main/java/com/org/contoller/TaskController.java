package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class TaskController {

	
	//show list note
	@RequestMapping(value = "listTasks", method = RequestMethod.GET)
	public String listNote(Model model) {
		
				
		return "tasks/tasks";
	}
	
	//redirect to form to add Task
	@RequestMapping(value = "task", method = RequestMethod.GET)
	public String addTask(Model model) {
		
				
		return "tasks/task";
	}
	
	
}
