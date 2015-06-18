package cz.expertkom.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.expertkom.web.interfaces.service.ProductService;
import cz.expertkom.web.vo.dto.Product;

/**
 * Controller pro administraci, øeší vytváøení a editaci produktù
 * 
 * @author Marek
 *
 */

@Controller
public class AdminProductsController {

	@Autowired
	ProductService productService;

	// Založení nového produktu:
	// vytvoøí v modelu novou instanci objektu
	@RequestMapping(value = "newProduct", method = RequestMethod.GET)
	public String newProduct(final Model model) {

		Product product = new Product();
		model.addAttribute("product", product);

		return "newProduct";
	}

	// Pøi odeslání formuláøe metodou POST nastaví parametry objektu product a
	// uloží ho do db
	@RequestMapping(value = "makeProduct", method = RequestMethod.POST)
	public String makeProduct(@ModelAttribute("product") final Product product) {

		productService.create(product);

		return "redirect:newProduct";
	}

	// Editace produktù:
	// Vytvoøí v modelu objekty pro všecny produkty v db identifikovatelné dle
	// Id a zobrazí stránku s formuláøi pro editaci

	@RequestMapping(value = "editProducts")
	public String editProducts(final Model model) {

		List<Product> products = null;
		products = productService.getList();
		model.addAttribute("products", products);

		for (Product p : products) {
			String name = String.valueOf(p.getId());
			model.addAttribute(name, p);
		}

		return "editProducts";
	}

	// Dle ID produktu aktualizuje objekt v db 
	@RequestMapping(value = "edProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String edProduct(
			@ModelAttribute(value = "id") final Product product, Model model) {

		model.addAttribute("product", product);
		productService.update(product);

		return "redirect:editProducts";
	}
}
