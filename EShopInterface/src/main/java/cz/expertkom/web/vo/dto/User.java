package cz.expertkom.web.vo.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Data pro p�ihla�ov�n� a ov��ov�n� u�ivatele. Jedn� se o syst�mov�ho u�ivatele
 */

public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1807419766045433889L;

	/**
	 * Jedine�n� ID u�ivatele
	 */
	private Long id;

	/**
	 * U�ivatelsk� heslo
	 */
	private String password;

	/**
	 * U�ivatelsk� jm�no
	 */
	private String username;

	/**
	 * Je ��et u�ivatele aktivn�?
	 */
	private boolean enabled = true;

	/**
	 * Role u�ivatele
	 */
	private Set<Authority> authorities;
	
	/**
	 * Ko��k p�i�azen� u�ivateli
	 */
	private List<Product> basket;

	public List<Product> getBasket() {
		return basket;
	}

	public void setBasket(List<Product> basket) {
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
