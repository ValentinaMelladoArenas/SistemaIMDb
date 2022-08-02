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
import org.springframework.web.servlet.view.RedirectView;

import cl.talentoDigital.model.Rating;
import cl.talentoDigital.model.Show;
import cl.talentoDigital.service.IRatingService;
import cl.talentoDigital.service.IShowService;
import cl.talentoDigital.service.IUsuarioService;

@Controller
@RequestMapping("/show")
public class ShowController {

	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IShowService showService;
	
	@Autowired
	IRatingService ratingService;
	
	@GetMapping("/addShow")
	public String addShow(Model model) {
		model.addAttribute("show", new Show());
		model.addAttribute("Username",  userMapped());
		return "/show/addShow"; 
	}
	
	@PostMapping("/saveShow")
	public RedirectView saveShow(Model model, @ModelAttribute Show showView) {
		showService.save(showView);
		return new RedirectView("/show/shows"); 
	}
	
	@GetMapping("/shows")
	public String shows(Model model) {
		model.addAttribute("showsList", showService.findAll());
		model.addAttribute("Username",  userMapped());
		model.addAttribute("email",  usuarioService.findByUsername(userMapped()).get().getEmail());
		
		return "/show/shows"; 
	}
	
	@GetMapping("/editShow")
	public String editShow(Model model, @RequestParam String idShow) {
		
		model.addAttribute("Username",  userMapped());
		model.addAttribute("show",showService.findById(Long.parseLong(idShow)).get()); 
		return "/show/editShow";
	}
	
	@PostMapping("/updateShow")
	public RedirectView updateShow(Model model, @ModelAttribute Show editShowView) {
		model.addAttribute("Username",  userMapped());
		System.out.println(editShowView.toString());
		showService.update(editShowView);
		
		return new RedirectView("/show/shows");
	}
	
	@GetMapping("/deleteShow")
	public RedirectView deleteShow(Model model, @RequestParam String idShow) {
		showService.delete(Long.parseLong(idShow));
		return new RedirectView("/show/shows");
	}
	
	@GetMapping("/ratingShow")
	public String addRating(Model model, @RequestParam String idShow) {
		model.addAttribute("rating", new Rating());
		model.addAttribute("usuario", usuarioService.findByUsername(userMapped()));
		model.addAttribute("showId",  idShow);
		model.addAttribute("Username", userMapped() );
		return "/show/ratingShow"; 
	}
	
	@PostMapping("/saveRating")
	public RedirectView saveRating(Model model, @ModelAttribute Rating ratingView) {
		model.addAttribute("Username",  userMapped());
		ratingService.save(ratingView);
		return new RedirectView("/show/ratings"); 
	}
	
	@GetMapping("/ratings")
	public String ratings(Model model) {
		model.addAttribute("Username",  userMapped());
		model.addAttribute("ratingsList", ratingService.findAll());
		model.addAttribute("showsList", showService.findAll());
		model.addAttribute("usersList", usuarioService.findAll());
		return "/show/ratings"; 
	}
	
	@GetMapping("/editRating")
	public String editRating(Model model, @RequestParam Long idRating) {
		model.addAttribute("rating", new Rating());
		model.addAttribute("Username",  userMapped());
		ratingService.findById(idRating);
		return "editRating";
	}
	
	/*@GetMapping("/editShow")
	public String editShow(Model model, @RequestParam String idShow) {
		
		model.addAttribute("Username",  userMapped());
		model.addAttribute("show",showService.findById(Long.parseLong(idShow)).get()); 
		return "/show/editShow";
	}*/
	
	@PostMapping("/updateRating")
	public RedirectView updateRating(Model model, @ModelAttribute Rating editRatingView) {
		ratingService.update(editRatingView);
		model.addAttribute("Username",  userMapped());
		return new RedirectView("/show/ratings");
	}
	
	@PostMapping("/buscar")
	public String findByName(Model model, @RequestParam String nombre) {
		showService.findByShowTitle(nombre);
		model.addAttribute("Username",  userMapped());
		return "home";
	}
	
	public String userMapped() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
}
