package cz.expertkom.web.vo.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Data pro prihlasovani a overovani uzivatele. Jedna se o systemoveho
 * uzivatele
 * 
 * @author Pavel Lukes
 * 
 */

public class User implements UserDetails, Serializable {



	private static final long serialVersionUID = 1807419766045433889L;


	private Long id;

	/**
	 * heslo uzivatele
	 */
	private String password;

	/**
	 * uzivatelske jmeno, muze byt facebook id nebo emailova adresa
	 */
	private String username;

	private boolean enabled = true;

	private Set<Authority> authorities;
	

	private List<Database> basket;
	
	public List<Database> getBasket() {
		return basket;
	}

	public void setBasket(List<Database> basket) {
		this.basket = basket;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public Collection<Authority> getAuthorities() {
		if (authorities == null) {
			return new HashSet<Authority>();
		}
		return authorities;
	}

	public void setAuthorities(final Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}


}
