package cz.bodyplan.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.bodyplan.web.interfaces.repository.MarekRepository;
import cz.bodyplan.web.vo.dto.Marek;



@Repository
public class MarekRepositoryImpl extends Template<Marek> implements MarekRepository{

	@Override
	public void create(Marek object) {
		super.persist(object);
		
	}

	@Override
	public void remove(Marek object) {
		super.delete(object);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Marek object) {
		super.update(object);
	}
	
	@Override
	public Marek loadById(Long id) {
		if (id == null) {
			return null;
		}
		// final DetachedCriteria crit = DetachedCriteria.forClass(User.class).add(Restrictions.eq("id", id));

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// final DetachedCriteria crit = DetachedCriteria.forClass(User.class).add(Restrictions.eq("username", username));
		final CriteriaQuery<Marek> crit = criteriaBuilder.createQuery(Marek.class);
		final Root<Marek> users = crit.from(Marek.class);
		crit.select(users).where(criteriaBuilder.equal(users.get("id"), id));

		final List<Marek> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}
	@Override
	public List<Marek> getListOfMareks() {
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();
		final CriteriaQuery<Marek> createQuery = criteriaBuilder
				.createQuery(Marek.class);
		final CriteriaQuery<Marek> select = createQuery.select(createQuery
				.from(Marek.class));
		return findByCriteria(select);
	}
}
