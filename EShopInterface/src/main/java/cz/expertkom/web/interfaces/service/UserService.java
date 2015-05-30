package cz.expertkom.web.interfaces.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cz.expertkom.web.vo.dto.User;

/**
 * Pøedpis povinnıch metod pro objekt user
 */

public interface UserService extends UserDetailsService {

	/**
	 * Naèti uivatele dle jeho jedineèného uivatelskéo jména
	 */
	@Override
	User loadUserByUsername(String username) throws UsernameNotFoundException;

	/**
	 * Naèti uivatele dle jeho jedineèného ID
	 */
	User loadById(Long id);

	/**
	 * Vytvoø uivatele
	 */
	void create(User user);

	/**
	 * Sma uivatele dle jeho uivatelského jména
	 */
	void remove(User user);

	/**
	 * Aktualizuj uivatele dle jeho uivatelského jména
	 */
	void update(User user);

	/**
	 * Vra seznam všech uivatelù
	 */
	List<User> getList();
}