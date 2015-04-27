package cz.bodyplan.web.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.interfaces.service.LoggingService;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.dto.User;

public class DavidController {
 

    @Autowired
    UserService userService;
    
    @Autowired
    LoggingService loggingService;


    @Autowired
    PasswordComponent passwordComponent;

    @RequestMapping(value = "david.html", method = RequestMethod.GET)
    public String index(final HttpServletRequest req, final HttpServletResponse res, final Model model) {
        final User user = new User();
        user.setUsername("david-" + new Date().getTime());
        user.setFirstName("David");
        user.setLastName("Muller");

        userService.create(user);
        return "index";
    }

}
