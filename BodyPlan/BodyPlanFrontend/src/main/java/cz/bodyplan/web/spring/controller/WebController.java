package cz.bodyplan.web.spring.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.interfaces.service.LoggingService;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.dto.LogEntry;
import cz.bodyplan.web.vo.dto.User;

@Controller
public class WebController {


    @Autowired
    UserService userService;
    
    @Autowired
    LoggingService loggingService;


    @Autowired
    PasswordComponent passwordComponent;

    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String index(final HttpServletRequest req, final HttpServletResponse res, final Model model) {
        final User user = new User();
        user.setUsername("david-" + new Date().getTime());
        user.setFirstName("David");
        user.setLastName("Muller");

        userService.create(user);
        return "index";
    }

    @RequestMapping(value = "init.html", method = RequestMethod.GET)
    public String init(final HttpServletRequest req, final HttpServletResponse res, final Model model) {
        final User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordComponent.getMd5Password(admin, "admin"));
        userService.create(admin);
        return "init";
    }

    @RequestMapping(value = "error.html", method = RequestMethod.GET)
    public String error(final HttpServletRequest req, final HttpServletResponse res, final Model model) {
        return "error";
    }

    @RequestMapping(value = "david2.html", method = RequestMethod.GET) //zasilani emailu
    public String david(final HttpServletRequest req, final HttpServletResponse res, final Model model) {
        String adr = "homer.bond@seznam.cz";
        final User user = new User();
        user.setUsername("david-" + new Date().getTime());
        user.setFirstName("David");
        user.setLastName("Muller");

        LogEntry log = new LogEntry(); //zapisuje do databaze
        log.setResult("zaznam do databaze");
        log.setEmail("homer.bond@seznam.cz");
        loggingService.create(log);

        final Properties props = new Properties(); //otevira spojeni
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        final Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        // vyuzijeme prihlasovni pomoci jmena a hesla
                        return new PasswordAuthentication("JavaSenderJT@gmail.com", "blablabla123");
                    }
                });

        try {

            // vytvorime zpravu kterou budeme odesilat
            final Message message = new MimeMessage(session);
            
            // vyplnime adresu odesilatele, tedy stejny mail jako je prihlasovaci jmeno
            message.setFrom(new InternetAddress("JavaSenderJT@gmail.com"));
            
            // vyplnime komu budeme posilat email, tech muze byt vice
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adr));
            
            // zadáme predmet emailu
            message.setSubject("aktualni obrazek");
            
            // vyplnime telo emailu, to muze byt samozrejme slozeno z texu i hodnot (pri skladani doporucuji pouzit StringBuilder)
            message.setText("vsichni jsou uz mrtvi Dejve ve 12>00");

            // odesleme zpravu
            Transport.send(message);

        } catch (final MessagingException e) {
            throw new RuntimeException(e);
        }
        
        try (Writer w = res.getWriter()) {
            w.append("Emails sents");
        } catch (IOException e) {
            res.setStatus(500);
        }
        
        return "index";
    }

    @RequestMapping(value = "form_send", method = RequestMethod.GET) //form_send je input a provazany s FormDemo
    public String formular(final HttpServletRequest req, final HttpServletResponse res, final Model model) {
        
        try (Writer w = res.getWriter()) {
            w.append("Formular odeslan");
            w.append(req.getParameter("jmeno"));
            w.append(req.getParameter("prijmeni")); //"prijmeni" neni totez, jako " prijmeni'!!!!
        } catch (IOException e) {
            res.setStatus(500);
        }
        
        return "index";
    }
    
}
