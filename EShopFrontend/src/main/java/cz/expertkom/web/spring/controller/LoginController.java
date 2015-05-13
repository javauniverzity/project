package cz.expertkom.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.expertkom.web.interfaces.component.PasswordComponent;
import cz.expertkom.web.interfaces.service.AuthorityService;
import cz.expertkom.web.interfaces.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	AuthorityService authorityService;

	@Autowired
	PasswordComponent passwordComponent;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String index(final Model model) {
//		User user = new User();
//		user.setUsername("admin");
//		user.setPassword(passwordComponent.getMd5Password(user, "admin"));
//		Set<Authority> authorities = new HashSet<Authority>();
//		authorities.add(authorityService.getAuthority("ROLE_ADMIN"));
//		user.setAuthorities(authorities);
//		userService.create(user);
		return "login";
	}
	

}