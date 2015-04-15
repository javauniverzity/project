package cz.bodyplan.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.bodyplan.web.interfaces.repository.AuthorityRepository;
import cz.bodyplan.web.vo.dto.Authority;

@Repository("authorityRepository")
@Transactional(readOnly = true)
public class AuthorityRepositoryImpl extends Template<Authority> implements AuthorityRepository {

	@Override
	@Transactional(readOnly = false)
	public void create(final Authority authority) {
		super.persist(authority);
	}

	@Override
	@Transactional(readOnly = false)
	public void remove(final Authority authority) {
		super.delete(authority);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(final Authority authority) {
		super.update(authority);
	}

	@Override
	public Authority loadById(final Long id) {
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Authority> crit = criteriaBuilder.createQuery(Authority.class);
		final Root<Authority> authorities = crit.from(Authority.class);
		crit.select(authorities).where(criteriaBuilder.equal(authorities.get("id"), id));

		final List<Authority> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

	@Override
	public Authority loadByName(final String name) {
		if (name == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Authority> crit = criteriaBuilder.createQuery(Authority.class);
		final Root<Authority> authorities = crit.from(Authority.class);
		crit.select(authorities).where(criteriaBuilder.equal(authorities.get("name"), name));

		final List<Authority> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

	@Override
	public List<Authority> getList() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Authority> crit = criteriaBuilder.createQuery(Authority.class);
		final Root<Authority> authorities = crit.from(Authority.class);
		crit.select(authorities);
		final List<Authority> results = findByCriteria(crit);
		return results;
	}

}
