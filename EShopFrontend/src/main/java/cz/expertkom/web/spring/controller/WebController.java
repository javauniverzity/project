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
		
	@RequestMapping(value = "searchProduct", method = RequestMethod.GET)
	public String searchProduct(final Model model, @RequestParam("searchProduct") String searchProduct) {
		List<Product> products = productService.searchProduct(searchProduct);
		model.addAttribute("products", products);
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "sorter", method = RequestMethod.GET)
	public String sorter(final Model model,
			@RequestParam("sortBy") String sortBy,
			@RequestParam("sortHow") String sortHow) {
		
		List<Product> products = productService.sorter(sortBy, sortHow);
		
		model.addAttribute("products", products);
		return "index";
	}
	
	
	
	
	

	
	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error() {
		return "index";
	}

}
