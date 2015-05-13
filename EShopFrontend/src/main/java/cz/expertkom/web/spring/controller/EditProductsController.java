package cz.expertkom.web.spring.controller;



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

@Controller
public class EditProductsController {

	@Autowired
	ProductService productService;

	@RequestMapping(value="editProducts")
	public String editProducts(final Model model){
		List<Product> products = productService.getList();
		model.addAttribute("products", products);
		for(Product p: products){
			String name = String.valueOf(p.getId());
			model.addAttribute(name, p);
		}
		return "editProducts";
	}
	@RequestMapping(value = "edProduct", method = {RequestMethod.GET, RequestMethod.POST})
	public String edProduct(@ModelAttribute(value="id") final Product product, Model model){
		model.addAttribute("product", product);
	//	productService.update(product);
		return "edProduct";
	}
}
