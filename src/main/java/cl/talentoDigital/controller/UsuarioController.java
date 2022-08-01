package cl.talentoDigital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpSession;

import cl.talentoDigital.model.Role;
import cl.talentoDigital.model.Usuario;
import cl.talentoDigital.service.IUsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;
	
	
	
	@GetMapping("/new/newUsuario")
	public String addUsuario(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roles",Role.values());
		return "/usuario/new/newUsuario";
	}
	
	@PostMapping("/new/saveUsuario")
	public RedirectView saveUsuario(Model model, @ModelAttribute Usuario usuarioView) {
		
		System.out.println("----------------------");
		System.out.println(usuarioView.toString());
		System.out.println("----------------------");
		
		
		usuarioService.save(usuarioView);
		
		
		
		return new RedirectView("/usuario/logged/usuarios");
	}
	
	@GetMapping("/logged/usuarios")
	public ModelAndView usuarios(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/usuario/logged/usuarios");
		session.setAttribute("usuariosList", usuarioService.findAll());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		modelAndView.addObject("Username", currentPrincipalName);
		session.setAttribute("username", currentPrincipalName);
		modelAndView.addObject("info", "pelotudo");
		return modelAndView;
	}
	
//	@GetMapping("/logged/usuarios")
//	public String loggedUsuarios(Model model) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		System.out.println("----------------------");
//		System.out.println(currentPrincipalName);
//		System.out.println("----------------------");
//		model.addAttribute("Username", currentPrincipalName);
//		//model.addAttribute("usuariosList", usuarioService.findAll());
//		return "/usuario/logged/usuarios";
//	}
	
	@GetMapping("/logged/editUsuario")
	public String editUsuarioView(Model model, @RequestParam String userName) {
		model.addAttribute("usuario", new Usuario());
		usuarioService.findByUsername(userName);
		return "editUsuario";
	}
	
	@PostMapping("/logged/editUsuario")
	public RedirectView editUsuario(Model mode, @ModelAttribute Usuario editUsuarioView) {
		usuarioService.update(editUsuarioView);
		return new RedirectView("/usuario/usuarios");
	}
	
	@GetMapping("/logged/deleteUsuario")
	public RedirectView deleteUsuario(Model model, @RequestParam String userName, @ModelAttribute Usuario deleteUsuarioView) {
		model.addAttribute("usuario", new Usuario());
		usuarioService.findByUsername(userName);
		usuarioService.delete(deleteUsuarioView);
		return new RedirectView("/usuario/usuarios");
	}
	
	@PostMapping("/logged/buscar")
	public String findByEmail(Model model, @RequestParam String email) {
		usuarioService.findByEmailLike(email);
		return "home";
	}
}
