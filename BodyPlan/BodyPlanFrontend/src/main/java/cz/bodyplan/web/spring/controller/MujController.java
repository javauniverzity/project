package cz.bodyplan.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.dto.User;


@Controller
public class MujController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordComponent passwordComponent;

	@RequestMapping(value = "moje.html", method = RequestMethod.GET)
	public String moje(final Model model){
		User x = new User();
		
		return "moje";
	}
}
