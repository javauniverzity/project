package cz.expertkom.be.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Rozhrani repository pro objekt jakehokoliv typu
 * @author David
 *
 */
@Repository
@Transactional(readOnly = true)
public abstract class GeneralRepository<T> {

	Logger logger = Logger.getLogger(GeneralRepository.class);

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Tvorba objektu
	 */
	@Transactional(readOnly = false)
	public void create(final T o) {
		logger.info("persist " + o);
		entityManager.persist(o);
	}

	/**
	 * Odstraneni objektu
	 */
	@Transactional(readOnly = false)
	public void remove(final T o) {
		logger.info("remove " + o);
		entityManager.remove(o);
	}

	/**
	 * Aktulizace objektu
	 */
	@Transactional(readOnly = false)
	public void update(final T o) {
		logger.info("update " + o);
		// openSession().update(o);
		entityManager.merge(o);
	}

	/**
	 * Hledani objektu dle kriterii
	 */
	public List<T> findByCriteria(final CriteriaQuery<T> crit) {
		logger.info("findByCriteria " + crit);
		return entityManager.createQuery(crit).getResultList();
	}

	/**
	 * Hledani objektu podle minimalnich a maximalnich parametru
	 */
	public List<T> findByCriteria(final CriteriaQuery<T> crit, final int min,
			final int max) {
		logger.info("findByCriteria " + crit + " min:" + min + " max:" + max);
		return entityManager.createQuery(crit).setFirstResult(min)
				.setMaxResults(max).getResultList();
	}
}