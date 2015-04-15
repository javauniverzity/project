package cz.bodyplan.be.spring.component;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cz.bodyplan.web.interfaces.component.CurrentUserComponent;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.dto.User;

@Component
public class CurrentUserComponentImpl implements CurrentUserComponent {

	private static final Logger logger = Logger.getLogger(CurrentUserComponent.class);

	@Autowired
	UserService userService;

	@Override
	public User getCurrentUser() {
		if (getCurrentUsername() == null || "".equals(getCurrentUsername())) {
			return null;
		}
		return userService.loadUserByUsername(getCurrentUsername());
	}

	@Override
	public String getCurrentUsername() {
		String username = "";
		try {
			if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
					&& SecurityContextHolder.getContext().getAuthentication().getName() != null) {
				username = SecurityContextHolder.getContext().getAuthentication().getName();
			}
		} catch (final Exception ex) {
			logger.error("getCurrentUsername: Error while getting username from security context holder");
		}
		if (!"".equals(username)) {
			logger.debug("getCurrentUsername(): " + username);
		}
		return username;
	}

}
