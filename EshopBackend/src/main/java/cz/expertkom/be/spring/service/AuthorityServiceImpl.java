package cz.expertkom.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.expertkom.web.interfaces.repository.AuthorityRepository;
import cz.expertkom.web.interfaces.service.AuthorityService;
import cz.expertkom.web.vo.dto.Authority;

/**
 * Implementace povinnych metod pro objekt administrator
 * @author David
 *
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {


	@Autowired
	AuthorityRepository authorityRepository;

	/**
	 * Vytvoreni administratora
	 */
	@Override
	public void create(final Authority authority) {
		authorityRepository.create(authority);
	}

	/**
	 * Odstraneni administratora
	 */
	@Override
	public void remove(final Authority authority) {
		authorityRepository.remove(authority);
	}

	/**
	 * Aktualizace administratora
	 */
	@Override
	public void update(final Authority authority) {
		authorityRepository.update(authority);
	}

	/**
	 * Hledani administratora dle Id
	 */
	@Override
	public Authority loadById(final Long authority) {
		return authorityRepository.loadById(authority);
	}

	/**
	 * Dej administratora dle jmena, kdyz neni, tak ho vytvor
	 */
	@Override
	@Transactional(readOnly = false)
	public Authority getAuthority(final String name) {
		Authority authority = authorityRepository.loadByName(name);
		if (authority == null) {
			final Authority newAuthority = new Authority();
			newAuthority.setName(name);

			authorityRepository.create(newAuthority);

			authority = newAuthority;
		}
		return authority;
	}
/**
 * Seznam administratoru
 */
	@Override
	public List<Authority> getList() {
		return authorityRepository.getList();
	}
}
