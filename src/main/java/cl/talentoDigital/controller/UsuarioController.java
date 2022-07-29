package cl.talentoDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import cl.talentoDigital.model.Usuario;
import cl.talentoDigital.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/newUsuario")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "newUsuario";
	}
	
	@PostMapping("/saveUsuario")
	public RedirectView saveUsuario(Model model, @ModelAttribute Usuario usuarioView) {
		usuarioService.save(usuarioView);
		return new RedirectView("/usuario/usuarios");
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuariosList", usuarioService.findAll());
		return "usuarios";
	}
	
	@GetMapping("/editUsuario")
	public String editUsuarioView(Model model, @RequestParam Long idUsuario) {
		model.addAttribute("usuario", new Usuario());
		usuarioService.findById(idUsuario);
		return "editUsuario";
	}
	
	@PostMapping("/editUsuario")
	public RedirectView editUsuario(Model mode, @ModelAttribute Usuario editUsuarioView) {
		usuarioService.update(editUsuarioView);
		return new RedirectView("/usuario/usuarios");
	}
	
	@GetMapping("/deleteUsuario")
	public RedirectView deleteUsuario(Model model, @RequestParam Long idUsuario, @ModelAttribute Usuario deleteUsuarioView) {
		model.addAttribute("usuario", new Usuario());
		usuarioService.findById(idUsuario);
		usuarioService.delete(deleteUsuarioView);
		return new RedirectView("/usuario/usuarios");
	}
	
	@PostMapping("/buscar")
	public String findByEmail(Model model, @RequestParam String email) {
		usuarioService.findByEmailLike(email);
		return "home";
	}
}
