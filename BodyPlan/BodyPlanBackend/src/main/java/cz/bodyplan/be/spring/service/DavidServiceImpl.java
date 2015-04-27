package cz.bodyplan.be.spring.service;

    import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

    import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

    import cz.bodyplan.be.spring.exception.SendingEmailException;
import cz.bodyplan.be.spring.exception.UserAlreadyExistsException;
import cz.bodyplan.be.spring.exception.UserNotFoundException;
import cz.bodyplan.be.spring.exception.WrongParamtersException;
import cz.bodyplan.be.spring.exception.WrongUserException;
import cz.bodyplan.web.interfaces.component.HTMLMail;
import cz.bodyplan.web.interfaces.component.PasswordComponent;
import cz.bodyplan.web.interfaces.component.SecurityComponent;
import cz.bodyplan.web.interfaces.component.UserAuthorityComponent;
import cz.bodyplan.web.interfaces.exception.BusinessException;
import cz.bodyplan.web.interfaces.repository.UserRepository;
import cz.bodyplan.web.interfaces.service.DavidService;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.constants.Enums.Role;
import cz.bodyplan.web.vo.dto.User;

    @Service
    @Transactional(readOnly = true)
    public class DavidServiceImpl implements DavidService {

        Logger logger = Logger.getLogger(UserServiceImpl.class);

        @Autowired
        UserRepository userRepository;

        @Autowired
        PasswordComponent passwordComponent;

        @Autowired
        UserAuthorityComponent userAuthorityComponent;

        @Autowired
        HTMLMail htmlMail;

        @Autowired
        SecurityComponent securityComponent;

        /**
         * vrati uzivatele podle uzivatelskeho jmena, to je jedinecnne
         */
        @Override
        public User loadUserByUsername(final String username) {
            if (username == null || "".equals(username)) {
                return null;
            }
            logger.debug("loadUserByUsername :: " + username);
            final User user = userRepository.loadUserByUsername(username);

            return user;
        }

        /**
         * vrati uzivatele podle id, jedinecneho identifikatoru
         */
        @Override
        public User loadById(final Long id) {
            return userRepository.loadById(id);
        }

        /**
         * vytvoreni uzivatele
         * 
         * @throws BusinessException
         */
        @Override
        @Transactional(readOnly = false)
        public void create(final User user) {
            userRepository.create(user);
        }

        /**
         * odstraneni uzivatele podle uzivatelskeho jmena
         */
        @Override
        @Transactional(readOnly = false)
        public void remove(final User user) {

            userRepository.remove(user);
        }

        /**
         * vrati vsechny uzivatele systemu
         */
        @Override
        public List<User> getList() {
            return userRepository.getListOfUsers();
        }

        /**
         * ulozeni zmen uzivatele
         */
        @Override
        @Transactional(readOnly = false)
        public void update(final User user) {

            userRepository.update(user);
        }

        @Override
        @Transactional(readOnly = false)
        public User registerUser(final User user, final String email)
                throws BusinessException {
            final Date date = new Date();
            if (email == null) {
                logger.info("WrongParamtersException");
                throw new WrongParamtersException();
            }
            // pokud uz existuje uzivatel, tak return
            if (loadUserByUsername(email) != null) {
                logger.info("UserAlreadyExistsException");
                throw new UserAlreadyExistsException();
            }
            user.setUsername(email);
            user.setPassword(passwordComponent.getMd5Password(user,
                    passwordComponent.getRandomPassword()));
            user.setCreateDate(date);

            create(user);

            userAuthorityComponent.addAuthority(user, Role.WAITING);

            String token = securityComponent.encode(email + "&" + email + "&"
                    + date.getTime());
            try {
                token = URLEncoder.encode(token, "UTF-8");
            } catch (final UnsupportedEncodingException ex) {
                logger.error("UnsupportedEncodingException", ex);
            }
            try {
                logger.info("token: " + token);
                htmlMail.sendMail(email, "registrace@bodyplan.cz", "Subject",
                        "text, token:" + token);
            } catch (final Exception e) {
                logger.error("Exception", e);
                throw new SendingEmailException();
            }

            return user;
        }

        @Override
        public void authenticationUserByUsername(final String username) {
            final User user = loadUserByUsername(username);
            final Authentication auth = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities());
            final SecurityContext ctx = new SecurityContextImpl();
            ctx.setAuthentication(auth);
            SecurityContextHolder.setContext(ctx);
        }

        @Override
        public void authenticationAnonymous() {
            final User user = new User();
            user.setUsername(passwordComponent.getRandomPassword());
            user.setPassword(passwordComponent.getMd5Password(user,
                    passwordComponent.getRandomPassword()));
            create(user);
            userAuthorityComponent.addAuthority(user, Role.ANONYMOUS);
            final Authentication auth = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities());
            final SecurityContext ctx = new SecurityContextImpl();
            ctx.setAuthentication(auth);
            SecurityContextHolder.setContext(ctx);
        }

        @Override
        @Transactional(readOnly = false)
        public User confirmRegistration(final String token)
                throws BusinessException {
            final String decode = securityComponent.decode(token);
            final String[] params = decode.split("&");
            final String email = params[0];
            final String username = params[1];
            final String timestamp = params[2];
            if (username == null || timestamp == null || email == null) {
                throw new WrongParamtersException();
            }
            final User user = loadUserByUsername(username);
            if (user == null) {
                throw new UserNotFoundException();
            }
            if (userAuthorityComponent.hasAuthority(user, Role.WAITING)) {
                userAuthorityComponent.addAuthority(user, Role.USER);
                userAuthorityComponent.removeAuthority(user, Role.WAITING);
                return user;
            }
            throw new WrongUserException();

        }
    }

