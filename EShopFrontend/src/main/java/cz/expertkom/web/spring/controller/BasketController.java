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

import cz.expertkom.web.interfaces.service.ProductService;
import cz.expertkom.web.interfaces.service.UserService;
import cz.expertkom.web.vo.dto.Product;
import cz.expertkom.web.vo.dto.User;

/**
 * Controller øeší funkcionalitu nákupního košíku
 */

@SessionAttributes({ "user", "basket" })
@Controller
public class BasketController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	// Vytvoøí košík, pøiøadí ho existujícímu userovi a na zálkladì ID mu
	// pøiøadí produkt. Vše pošle do session
	@RequestMapping(value = "addToBasket", method = RequestMethod.GET)
	public String addToBasket(final Model model,
			@RequestParam("id") String productID,
			@ModelAttribute("user") User user) {

		// Pokud košík neexistuje, vytvoøíme ho
		List<Product> basket = user.getBasket();
		if (basket == null) {
			basket = new ArrayList<Product>();
			user.setBasket(basket);
		}

		// Naèteme produkt dle ID, vložíme ho do košíku a pošleme do session
		Product product = productService.loadById(Long.valueOf(productID));
		basket.add(product);
		model.addAttribute("basket", basket);
		model.addAttribute("user", user);

		return "basket";
	}

	// Nepoužívá se
	// @RequestMapping(value = "showBasket", method = RequestMethod.GET)
	// public String showBasket(final Model model,
	// @ModelAttribute("User") User user) {
	//
	// List<Database> basket = databaseService.getList();
	// model.addAttribute("basket", basket);
	//
	// return "basket";
	// }

	// Závazná objednávka. Pokud k ní dojde, snížíme skladové zásoby
	@RequestMapping(value = "order", method = RequestMethod.GET)
	public String order(@ModelAttribute("user") User user) {

		// Vytvoøíme prázdný list IDèek a list produktù v košíku
		List<Long> ids = new ArrayList<Long>();
		List<Product> basket = user.getBasket();

		// do listu IDèek pøiøadíme ID produktù v košíku
		for (Product product : basket) {
			ids.add(product.getId());
		}

		// Snížíme skladové zásoby u produktù dle listu IDèek
		productService.decreaseQuantity(ids);

		return "index";
	}
}
