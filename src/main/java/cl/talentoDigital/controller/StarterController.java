package cl.talentoDigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class StarterController {

	@GetMapping({"","/"})
	public String starter() {
		
	return "login";	
	}
	
}
