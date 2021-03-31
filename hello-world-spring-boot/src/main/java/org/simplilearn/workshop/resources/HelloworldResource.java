package org.simplilearn.workshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloworldResource {

	//HTTP METHOD GET ( Browser URL / HyperLink ) http://localhost:8080/
	@RequestMapping(path = "/" ,method = RequestMethod.GET)
	public String helloWorld() { // no need to annotate with @ResponseBody
		return "Hello World! Spring Boot v2.4!!!"; // default logical view name (REST = @ResponseBody )
	}
}
