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

import cl.talentoDigital.model.Rating;
import cl.talentoDigital.model.Show;
import cl.talentoDigital.service.IRatingService;
import cl.talentoDigital.service.IShowService;

@Controller
@RequestMapping("/show")
public class ShowController {

	@Autowired
	IShowService showService;
	
	@Autowired
	IRatingService ratingService;
	
	@GetMapping("/newShow")
	public String addShow(Model model) {
		model.addAttribute("show", new Show());
		return "newShow"; //vista de la creación de los shows
	}
	
	@PostMapping("/saveShow")
	public RedirectView saveShow(Model model, @ModelAttribute Show showView) {
		showService.save(showView);
		return new RedirectView("/show/shows"); //sólo guarda el show y lo manda a la vista shows 
	}
	
	@GetMapping("/shows")
	public String shows(Model model) {
		model.addAttribute("showsList", showService.findAll());
		return "shows"; /*vista del listado de TODOS los shows (c/ nombre de c/ show debe ser un botón que te lleve a la vista ratingShow)
		con un botón al lado de la columna network donde diga editar y permita editar nombre y network*/
	}
	
	@GetMapping("/editShow")
	public String editShowView(Model model, @RequestParam Long idShow) {
		model.addAttribute("show", new Show());
		showService.findById(idShow);
		return "editShow";
	}
	
	@PostMapping("/editShow")
	public RedirectView editShow(Model mode, @ModelAttribute Show editShowView) {
		showService.update(editShowView);
		return new RedirectView("/show/shows");
	}
	
	@GetMapping("/newRating")
	public String ratingShow(Model model) {
		model.addAttribute("rating", new Rating());
		return "ratingShow"; /*muestra el show seleccionado con el botón (nombre) y es como un edit (además del otro edit propio del show, este 
		es un tipo edit para agregar el rating por usuario solamente) donde agregas el rating (1 al 5)*/
	}
	
	@PostMapping("/saveRating")
	public RedirectView saveRating(Model model, @ModelAttribute Rating ratingView) {
		ratingService.save(ratingView);
		return new RedirectView("/show/selectShow"); //sólo guarda el rating y lo manda a la vista selectedShow
	}
	
	@GetMapping("/selectedShow")
	public String ratingsList(Model model) {
		model.addAttribute("ratingsList", ratingService.findAll());
		return "selectedShow"; //muestra el show seleccionado muy anteriormente (en newRating) con todos los ranking asignados por usuarios diferentes
	}
	
	
}
