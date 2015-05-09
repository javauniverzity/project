package cz.expertkom.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.expertkom.web.interfaces.service.ProductService;
import cz.expertkom.web.interfaces.service.UserService;
import cz.expertkom.web.vo.dto.Product;
import cz.expertkom.web.vo.dto.User;

@SessionAttributes ({"product", "user"})
@Controller
public class WebController {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(final Model model) {
		List<Product> products = productService.getList();
		model.addAttribute("products", products);
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value = "newProduct", method = RequestMethod.GET)
	public String newProduct(final Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newProduct";
	}

	@RequestMapping(value = "makeProduct", method = RequestMethod.POST)
	public String makeProduct(@ModelAttribute("product") final Product product) {
		productService.create(product);
		return "newProduct";
	}
	

	
			
	/* TODO Prozat�m k ni�emu, p��pravn� konstrukce

	@RequestMapping(value = "adminDatabase", method = RequestMethod.GET)
	public String adminDatabase(final Model model) {
		List<Database> products = databaseService.getList();
		model.addAttribute("products", products);
		return "adminDatabase";
	}

	@RequestMapping(value = "editProduct", method = RequestMethod.GET)
	public String editProduct(final Model model, @RequestParam(required = true, value = "Id") Long Id) {
		Database database = null;
		database = databaseService.loadById(Id);
		model.addAttribute("database", database);
		return "editProduct";
	}

	@RequestMapping(value = "editingProduct", method = RequestMethod.POST)
	public String editingProduct(@ModelAttribute("product") final Database database) {

		databaseService.update(database);
		return "editProduct";
	}
	*/

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error() {
		return "index";
	}

}