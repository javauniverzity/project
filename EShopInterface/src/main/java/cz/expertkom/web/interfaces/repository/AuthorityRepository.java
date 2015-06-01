package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Authority;

/**
 * Metody pro repository administr�tor�
 */

public interface AuthorityRepository extends GeneralRepository<Authority> {

	/**
	 * Na�ti administr�tora dle jeho jm�na
	 */
	Authority loadByName(String name);

	/**
	 * Na�ti seznam v�ech administr�tor�
	 */
	List<Authority> getList();

}
