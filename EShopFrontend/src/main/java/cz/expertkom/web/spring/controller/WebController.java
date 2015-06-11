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
 * Hlavn� controller, kter� �e�� na�ten� hlavn� str�nky a produkt� podle r�zn�ch
 * kriteri�
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

	// Hlavn� str�nka, p�i otev�en� na�te seznam v�ech produkt�, vytvo��
	// unik�tn�ho usera a oboj� ulo�� do session
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(final Model model) {

		final List<Product> products = productService.getList();
		model.addAttribute("products", products);

		final User user = new User();
		model.addAttribute("user", user);

		return "index";
	}

	// Fulltext vyhled�v�n�, p�ed�v� parametr searchProduct z formul��e
	// do repository CriteriaBuilderu. V�sledn� list ukl�d� do session
	@RequestMapping(value = "searchProduct", method = RequestMethod.GET)
	public String searchProduct(final Model model, @RequestParam("searchProduct") final String searchProduct) {

		final List<Product> products = productService.searchProduct(searchProduct);
		model.addAttribute("products", products);

		return "index";
	}

	// �adi�ka produkt�, p�ed�v� parametry z formul��e do repository
	// CriteriaBuilderu. V�sledn� list ukl�d� do session
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
