package org.simplilearn.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/showMessage.html") // HTTP GET : http://localhost:8080/simple-spring-webapp/showMessage.html
public class SimpleController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("showMessage"); // logical view name
		
		// store some data in model  object
		model.addObject("message","spring mvc web app with annotations");
		
		return model; // model data + logical view name
		
	}
}
