package cz.bodyplan.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.bodyplan.web.interfaces.repository.LoggingRepository;
import cz.bodyplan.web.vo.dto.LogEntry;



@Repository
@Transactional(readOnly = true)
public class LoggingRepositoryImpl extends Template<LogEntry> implements LoggingRepository{

    @Override
    @Transactional(readOnly = false)
    public void create(final LogEntry zaznam) {
        super.persist(zaznam);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(final LogEntry zaznam) {
        super.delete(zaznam);
    }

    @Override
    public LogEntry loadById(final Long id) {
        if (id == null) {
            return null;
        }

        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<LogEntry> crit = criteriaBuilder.createQuery(LogEntry.class);
        final Root<LogEntry> zaznamy = crit.from(LogEntry.class);
        crit.select(zaznamy).where(criteriaBuilder.equal(zaznamy.get("id"), id));

        final List<LogEntry> results = findByCriteria(crit);
        if (results.size() != 0) {
            return results.get(0);
        }
        return null;
    }
    @Override
    public List<LogEntry> getListOfLogEntries() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<LogEntry> createQuery = criteriaBuilder.createQuery(LogEntry.class);
        final CriteriaQuery<LogEntry> select = createQuery.select(createQuery.from(LogEntry.class));
        return findByCriteria(select);
    }

}
