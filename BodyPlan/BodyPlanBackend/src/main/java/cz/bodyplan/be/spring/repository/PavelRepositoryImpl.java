package cz.bodyplan.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import cz.bodyplan.web.interfaces.repository.PavelRepository;
import cz.bodyplan.web.vo.dto.Pavel;

@Repository
public class PavelRepositoryImpl extends Template<Pavel> implements
		PavelRepository {

	@Override
	public void create(Pavel object) {
		super.persist(object);

	}

	@Override
	public void remove(Pavel object) {
		super.delete(object);

	}

	@Override
	public void update(Pavel object) {
		super.update(object);
	}

	@Override
	public Pavel loadById(Long id) {
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();

		final CriteriaQuery<Pavel> crit = criteriaBuilder
				.createQuery(Pavel.class);
		final Root<Pavel> users = crit.from(Pavel.class);
		crit.select(users).where(criteriaBuilder.equal(users.get("id"), id));

		final List<Pavel> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

}
