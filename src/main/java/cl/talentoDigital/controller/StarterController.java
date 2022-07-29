package cl.talentoDigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.talentoDigital.model.Show;
import cl.talentoDigital.model.Usuario;

@Controller
@RequestMapping("")
public class StarterController {

	@GetMapping({"","/"})
	public String starter() {
		
	return "login";	
	}
	
	
	
	@GetMapping("/register")
	public String registration(Model model) {
		model.addAttribute("Usuario", new Usuario());
	return "registration";	
	}
	
	
	@GetMapping("/user")
	public String homes(Model model) {
		model.addAttribute("usuario", "Message in a bottle");
	return "user/home";	
	}
	
	
	
}
