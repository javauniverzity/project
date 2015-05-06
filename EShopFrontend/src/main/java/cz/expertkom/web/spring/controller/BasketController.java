package cz.expertkom.web.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.expertkom.web.interfaces.service.DatabaseService;
import cz.expertkom.web.interfaces.service.UserService;
import cz.expertkom.web.vo.dto.Database;
import cz.expertkom.web.vo.dto.User;

@SessionAttributes({ "user", "basket" })
@Controller
public class BasketController {


	@Autowired
	UserService userService;

	@Autowired
	DatabaseService databaseService;

	@RequestMapping(value = "addToBasket", method = RequestMethod.GET)
	public String addToBasket(final Model model,
			@RequestParam("id") String productID,
			@ModelAttribute("user") User user) {

		List<Database> basket = user.getBasket();
		if (basket == null) {
			basket = new ArrayList<Database>();
			user.setBasket(basket);
		}
		Database d = databaseService.loadById(Long.valueOf(productID));
		basket.add(d);
		model.addAttribute("basket", basket);
		model.addAttribute("user", user);

		return "basket";
	}

//	@RequestMapping(value = "showBasket", method = RequestMethod.GET)
//	public String showBasket(final Model model,
//			@ModelAttribute("User") User user) {
//
//		List<Database> basket = databaseService.getList();
//		model.addAttribute("basket", basket);
//
//		return "basket";
//	}

	@RequestMapping(value = "order", method = RequestMethod.GET)
	public String order(@ModelAttribute("user") User user) {

		List<Long> ids = new ArrayList<Long>();
		List<Database> basket = user.getBasket();

		for (Database b : basket) {
			ids.add(b.getId());
		}
		databaseService.decreaseQuantity(ids);

		return "index";
	}
}
