package cz.bodyplan.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.interfaces.service.MarekService;
import cz.bodyplan.web.vo.dto.Marek;




@SessionAttributes("marek")
@Controller
public class MujController {

	@Autowired
	MarekService marekService;

	@Autowired
	PasswordComponent passwordComponent;

	@RequestMapping(value = "moje.html", method = RequestMethod.GET)
	public String moje(final Model model){
		Marek marek = new Marek();
		model.addAttribute("marek", marek);
		return "moje";
	}
	
	@RequestMapping(value = "makeMarek.html", method = RequestMethod.POST)
	public String makeMarek(@ModelAttribute("marek") final Marek marek) {
		
		marekService.create(marek);
		return "moje";
	}	
	
	@RequestMapping(value = "seznamMarek.html", method = RequestMethod.GET)
	public String list(final Model model) {

		List<Marek> mareks = marekService.getList();
		model.addAttribute("mareks", mareks);
		return "seznamMarek";

	}
	@RequestMapping(value = "editMarek.html", method = RequestMethod.GET)
	public String editMarek(final Model model,
			@RequestParam(required = true, value = "Id") Long Id){
		Marek marek = null;
		marek=marekService.loadById(Id);
		model.addAttribute("marek", marek);
		return "editMarek";
	}
	@RequestMapping(value = "editujMarek.html", method = RequestMethod.POST)
	public String editujMarek(@ModelAttribute("marek") final Marek marek){
		
		marekService.update(marek);
		return "editMarek";
	}
}	
