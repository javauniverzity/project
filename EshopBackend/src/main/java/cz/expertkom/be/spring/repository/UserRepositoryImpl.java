package cz.expertkom.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.expertkom.web.interfaces.repository.UserRepository;
import cz.expertkom.web.vo.dto.User;

/**
 * Implementace repository uzivatelu
 * @author David
 *
 */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl extends GeneralRepository<User> implements
		UserRepository {
	
	/**
	 * Vrati uzivatele podle uzivatelskeho jmena, to je jedinecnne
	 */
	@Override
	public User loadUserByUsername(final String username) {
		if (username == null || "".equals(username)) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();
		final CriteriaQuery<User> crit = criteriaBuilder
				.createQuery(User.class);
		final Root<User> users = crit.from(User.class);
		crit.select(users).where(
				criteriaBuilder.equal(users.get("username"), username));

		final List<User> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

	/**
	 * Vrati vsechny uzivatele systemu
	 */
	@Override
	public List<User> getListOfUsers() {
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();
		final CriteriaQuery<User> createQuery = criteriaBuilder
				.createQuery(User.class);
		final CriteriaQuery<User> select = createQuery.select(createQuery
				.from(User.class));
		return findByCriteria(select);
	}

	/**
	 * Hledani uzivatelu podle jejich Id
	 */
	@Override
	public User loadById(final Long id) {
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();

		final CriteriaQuery<User> crit = criteriaBuilder
				.createQuery(User.class);
		final Root<User> users = crit.from(User.class);
		crit.select(users).where(criteriaBuilder.equal(users.get("id"), id));

		final List<User> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}
}