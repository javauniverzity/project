package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Authority;

/**
 * Metody pro repository administrátorů
 */

public interface AuthorityRepository extends GeneralRepository<Authority> {

	/**
	 * Načti administrátora dle jeho jména
	 */
	Authority loadByName(String name);

	/**
	 * Načti seznam všech administrátorů
	 */
	List<Authority> getList();

}
