package cz.bodyplan.be.spring.component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.bodyplan.web.interfaces.component.UserAuthorityComponent;
import cz.bodyplan.web.interfaces.service.AuthorityService;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.constants.Enums.Role;
import cz.bodyplan.web.vo.dto.Authority;
import cz.bodyplan.web.vo.dto.User;

@Component
public class UserAuthorityComponentImpl implements UserAuthorityComponent {

	// private static final Logger logger = Logger.getLogger(UserAuthorityComponentImpl.class);

	@Autowired
	AuthorityService authorityService;

	@Autowired
	UserService userService;

	@Override
	public void setAuthorities(final User user, final Collection<Authority> authorities) {
		final Set<Authority> set = new HashSet<Authority>();
		for (final Authority authority : authorities) {
			final Authority a = authorityService.getAuthority(authority.getName());
			set.add(a);
		}
		user.setAuthorities(set);
		userService.update(user);
	}

	@Override
	public void addAuthority(final User user, final Role role) {
		if (user == null || role == null) {
			return;
		}
		addAuthority(user, role.getName());
	}

	@Override
	public void addAuthority(final User user, final String authorityName) {
		if (user == null || authorityName == null) {
			return;
		}
		final Authority authority = authorityService.getAuthority(authorityName);
		user.getAuthorities().add(authority);

		userService.update(user);
	}

	@Override
	public void addAuthority(final User user, final Authority authority) {
		if (user == null || authority == null) {
			return;
		}
		addAuthority(user, authority.getName());
	}

	@Override
	public boolean hasAuthority(final User user, final Role role) {
		if (user == null || role == null) {
			return false;
		}
		return hasAuthority(user, role.getName());
	}

	@Override
	public boolean hasAuthority(final User user, final String authorityName) {
		if (user == null || authorityName == null) {
			return false;
		}
		for (final Authority authority : user.getAuthorities()) {
			if (authorityName.equals(authority.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasAuthority(final User user, final Authority authority) {
		if (user == null || authority == null) {
			return false;
		}
		return hasAuthority(user, authority.getName());
	}

	@Override
	public void removeAuthority(final User user, final Role role) {
		if (user == null || role == null) {
			return;
		}
		removeAuthority(user, role.getName());
	}

	@Override
	public void removeAuthority(final User user, final String authorityName) {
		if (user == null || authorityName == null) {
			return;
		}
		Authority remove = null;
		for (final Authority authority : user.getAuthorities()) {
			if (authorityName.equals(authority.getName())) {
				remove = authority;
				break;
			}
		}
		if (remove != null) {
			user.getAuthorities().remove(remove);
			userService.update(user);
		}
	}

	@Override
	public void removeAuthority(final User user, final Authority authority) {
		if (user == null || authority == null) {
			return;
		}
		removeAuthority(user, authority.getName());
	}

}
