package cz.bodyplan.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.bodyplan.web.interfaces.repository.AuthorityRepository;
import cz.bodyplan.web.interfaces.service.AuthorityService;
import cz.bodyplan.web.vo.dto.Authority;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

	// private static final Logger logger = Logger.getLogger(AuthorityServiceImpl.class);

	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public void create(final Authority authority) {
		authorityRepository.create(authority);
	}

	@Override
	public void remove(final Authority authority) {
		authorityRepository.remove(authority);
	}

	@Override
	public void update(final Authority authority) {
		authorityRepository.update(authority);
	}

	@Override
	public Authority loadById(final Long authority) {
		return authorityRepository.loadById(authority);
	}

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

	@Override
	public List<Authority> getList() {
		return authorityRepository.getList();
	}
}
