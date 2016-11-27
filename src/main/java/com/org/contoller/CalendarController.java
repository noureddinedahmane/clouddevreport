package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class CalendarController {

	// show calendar
	@RequestMapping(value = "calendar", method = RequestMethod.GET)
	public String calendar(Model model) {
		
				
		return "calendar/calendar";
	}
		
}
