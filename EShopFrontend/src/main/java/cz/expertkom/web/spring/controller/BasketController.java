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
 * Controller �e�� funkcionalitu n�kupn�ho ko��ku
 */

@SessionAttributes({ "user", "basket" })
@Controller
public class BasketController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	// Vytvo�� ko��k, p�i�ad� ho existuj�c�mu userovi a na z�lklad� ID mu
	// p�i�ad� produkt. V�e po�le do session
	@RequestMapping(value = "addToBasket", method = RequestMethod.GET)
	public String addToBasket(final Model model,
			@RequestParam("id") String productID,
			@ModelAttribute("user") User user) {

		// Pokud ko��k neexistuje, vytvo��me ho
		List<Product> basket = user.getBasket();
		if (basket == null) {
			basket = new ArrayList<Product>();
			user.setBasket(basket);
		}

		// Na�teme produkt dle ID, vlo��me ho do ko��ku a po�leme do session
		Product product = productService.loadById(Long.valueOf(productID));
		basket.add(product);
		model.addAttribute("basket", basket);
		model.addAttribute("user", user);

		return "basket";
	}

	// Nepou��v� se
	// @RequestMapping(value = "showBasket", method = RequestMethod.GET)
	// public String showBasket(final Model model,
	// @ModelAttribute("User") User user) {
	//
	// List<Database> basket = databaseService.getList();
	// model.addAttribute("basket", basket);
	//
	// return "basket";
	// }

	// Z�vazn� objedn�vka. Pokud k n� dojde, sn��me skladov� z�soby
	@RequestMapping(value = "order", method = RequestMethod.GET)
	public String order(@ModelAttribute("user") User user) {

		// Vytvo��me pr�zdn� list ID�ek a list produkt� v ko��ku
		List<Long> ids = new ArrayList<Long>();
		List<Product> basket = user.getBasket();

		// do listu ID�ek p�i�ad�me ID produkt� v ko��ku
		for (Product product : basket) {
			ids.add(product.getId());
		}

		// Sn��me skladov� z�soby u produkt� dle listu ID�ek
		productService.decreaseQuantity(ids);

		return "index";
	}
}
