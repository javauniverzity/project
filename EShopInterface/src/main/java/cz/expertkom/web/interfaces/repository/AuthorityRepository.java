package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Authority;

/**
 * Metody pro repository administrátorù
 */

public interface AuthorityRepository extends GeneralRepository<Authority> {

	/**
	 * Naèti administrátora dle jeho jména
	 */
	Authority loadByName(String name);

	/**
	 * Naèti seznam všech administrátorù
	 */
	List<Authority> getList();

}
