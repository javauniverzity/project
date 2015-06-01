package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.User;

/**
 * Metody pro repository uživatelù.
 */

public interface UserRepository extends GeneralRepository<User> {

	/**
	 * Naèti uživatele dle uživatelského jména
	 */
	User loadUserByUsername(String username);

	/**
	 * Naèti seznam všech uživatelù
	 */
	List<User> getListOfUsers();

}
