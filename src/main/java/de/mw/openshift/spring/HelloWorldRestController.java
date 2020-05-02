package de.mw.openshift.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@GetMapping(path = "/")
	public String sendHelloWorld() {
		return "Hallo, hier bin ich.";
	}	
}
