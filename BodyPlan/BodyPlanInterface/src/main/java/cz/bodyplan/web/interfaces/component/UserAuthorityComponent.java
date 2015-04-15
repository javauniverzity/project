package cz.bodyplan.web.interfaces.component;

import java.util.Collection;

import cz.bodyplan.web.vo.constants.Enums.Role;
import cz.bodyplan.web.vo.dto.Authority;
import cz.bodyplan.web.vo.dto.User;

public interface UserAuthorityComponent {

	void setAuthorities(User user, Collection<Authority> authorities);

	void addAuthority(User user, Role role);

	void addAuthority(User user, String authorityName);

	void addAuthority(User user, Authority authority);

	boolean hasAuthority(User user, Role role);

	boolean hasAuthority(User user, String authorityName);

	boolean hasAuthority(User user, Authority authority);

	void removeAuthority(User user, Role role);

	void removeAuthority(User user, String authorityName);

	void removeAuthority(User user, Authority authority);

}
