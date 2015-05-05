package cz.expertkom.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import cz.expertkom.web.interfaces.repository.DatabaseRepository;
import cz.expertkom.web.vo.dto.Database;

@Repository
public class DatabaseRepositoryImpl extends GeneralRepository<Database> implements DatabaseRepository {
	
	/**
	 *  loadById pro pozdìjší použití
	 *  */
	
	@Override
	public Database loadById(Long id) {		 
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();

		final CriteriaQuery<Database> crit = criteriaBuilder
				.createQuery(Database.class);
		final Root<Database> products = crit.from(Database.class);
		crit.select(products).where(criteriaBuilder.equal(products.get("id"), id));

		final List<Database> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}
	/** loadByProductName
	 * pro pozdìjší použití
	 * 
	 * */

	@Override
	public Database loadByProductName(String productname) {
			if (productname == null || "".equals(productname)) {
				return null;
			}
			final CriteriaBuilder criteriaBuilder = entityManager
					.getCriteriaBuilder();
			final CriteriaQuery<Database> crit = criteriaBuilder
					.createQuery(Database.class);
			final Root<Database> products = crit.from(Database.class);
			crit.select(products).where(
					criteriaBuilder.equal(products.get("productname"), productname));

			final List<Database> results = findByCriteria(crit);
			if (results.size() != 0) {
				return results.get(0);
			}
			return null;
		}
	
	/** 
	 * Pro výpis produktù
	 */
	@Override
	public List<Database> getListOfProducts() {
			final CriteriaBuilder criteriaBuilder = entityManager
					.getCriteriaBuilder();
			final CriteriaQuery<Database> createQuery = criteriaBuilder
					.createQuery(Database.class);
			final CriteriaQuery<Database> select = createQuery.select(createQuery
					.from(Database.class));
			return findByCriteria(select);
	}
	/* TODO trochu upraveno + pøidány hotové základní loadById, loadByProductName a getListOfProducts
	 * */
	 
}
