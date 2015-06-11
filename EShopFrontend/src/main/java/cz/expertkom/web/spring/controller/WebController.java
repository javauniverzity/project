package cz.expertkom.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.expertkom.web.interfaces.service.ProductService;
import cz.expertkom.web.interfaces.service.UserService;
import cz.expertkom.web.vo.dto.Product;
import cz.expertkom.web.vo.dto.User;

/**
 * Hlavní controller, který øeší naètení hlavní stránky a produktù podle rùzných
 * kriterií
 * 
 * @author Honza
 */

@SessionAttributes({ "product", "user" })
@Controller
public class WebController {

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	// Hlavní stránka, pøi otevøení naète seznam všech produktù, vytvoøí
	// unikátního usera a obojí uloží do session
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(final Model model) {

		final List<Product> products = productService.getList();
		model.addAttribute("products", products);

		final User user = new User();
		model.addAttribute("user", user);

		return "index";
	}

	// Fulltext vyhledávání, pøedává parametr searchProduct z formuláøe
	// do repository CriteriaBuilderu. Výsledný list ukládá do session
	@RequestMapping(value = "searchProduct", method = RequestMethod.GET)
	public String searchProduct(final Model model, @RequestParam("searchProduct") final String searchProduct) {

		final List<Product> products = productService.searchProduct(searchProduct);
		model.addAttribute("products", products);

		return "index";
	}

	// Øadièka produktù, pøedává parametry z formuláøe do repository
	// CriteriaBuilderu. Výsledný list ukládá do session
	@RequestMapping(value = "sorter", method = RequestMethod.GET)
	public String sorter(final Model model, @RequestParam("sortBy") final String sortBy, @RequestParam("sortHow") final String sortHow) {

		final List<Product> products = productService.sorter(sortBy, sortHow);
		model.addAttribute("products", products);

		return "index";
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error() {

		return "index";
	}
}
