package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.interfaces.repository.GeneralRepository;
import cz.expertkom.web.vo.dto.Authority;

/**
 * P�edpismpovinn�ch metod pro objekt administr�tora
 */

public interface AuthorityService extends GeneralRepository<Authority> {

	/**
	 * Na�ti administr�tora dle jeho jm�na
	 */
	Authority getAuthority(String name);

	/**
	 * Vra� seznam v�ech administr�tor� syst�mu
	 */
	List<Authority> getList();
}
