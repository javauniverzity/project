package cz.expertkom.web.interfaces.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cz.expertkom.web.vo.dto.User;

/**
 * P�edpis povinn�ch metod pro objekt user
 */

public interface UserService extends UserDetailsService {

	/**
	 * Na�ti u�ivatele dle jeho jedine�n�ho u�ivatelsk�o jm�na
	 */
	@Override
	User loadUserByUsername(String username) throws UsernameNotFoundException;

	/**
	 * Na�ti u�ivatele dle jeho jedine�n�ho ID
	 */
	User loadById(Long id);

	/**
	 * Vytvo� u�ivatele
	 */
	void create(User user);

	/**
	 * Sma� u�ivatele dle jeho u�ivatelsk�ho jm�na
	 */
	void remove(User user);

	/**
	 * Aktualizuj u�ivatele dle jeho u�ivatelsk�ho jm�na
	 */
	void update(User user);

	/**
	 * Vra� seznam v�ech u�ivatel�
	 */
	List<User> getList();
}