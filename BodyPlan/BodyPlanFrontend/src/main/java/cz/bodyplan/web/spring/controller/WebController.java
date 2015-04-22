package cz.bodyplan.web.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.dto.User;

@Controller
@SessionAttributes("user")
public class WebController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordComponent passwordComponent;

	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public String index(final HttpServletRequest req,
			final HttpServletResponse res, final Model model) {
		final User user = new User();

		user.setUsername("jan-" + new Date().getTime());
		user.setFirstName("Pinger");

		Hlavni.main(null);
		user.setLastName(TestIP.nedostupne);

		userService.create(user);
		model.addAttribute("user", user);
		return "index";
	}

	@RequestMapping(value = "editUser.html", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") final User user) {
		userService.update(user);
		return "index";
	}

	@RequestMapping(value = "init.html", method = RequestMethod.GET)
	public String init(final HttpServletRequest req,
			final HttpServletResponse res, final Model model) {
		final User admin = new User();
		admin.setUsername("admin");
		admin.setPassword(passwordComponent.getMd5Password(admin, "admin"));
		userService.create(admin);
		return "index";
	}

	@RequestMapping(value = "error.html", method = RequestMethod.GET)
	public String error(final HttpServletRequest req,
			final HttpServletResponse res, final Model model) {
		return "index";
	}

}
