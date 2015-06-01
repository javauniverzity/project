package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.User;

/**
 * Metody pro repository u�ivatel�.
 */

public interface UserRepository extends GeneralRepository<User> {

	/**
	 * Na�ti u�ivatele dle u�ivatelsk�ho jm�na
	 */
	User loadUserByUsername(String username);

	/**
	 * Na�ti seznam v�ech u�ivatel�
	 */
	List<User> getListOfUsers();

}
