package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.interfaces.repository.GeneralRepository;
import cz.expertkom.web.vo.dto.Authority;

/**
 * Pøedpismpovinnıch metod pro objekt administrátora
 */

public interface AuthorityService extends GeneralRepository<Authority> {

	/**
	 * Naèti administrátora dle jeho jména
	 */
	Authority getAuthority(String name);

	/**
	 * Vra seznam všech administrátorù systému
	 */
	List<Authority> getList();
}
