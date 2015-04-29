package cz.bodyplan.be.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.bodyplan.web.interfaces.repository.LoggingRepository;
import cz.bodyplan.web.interfaces.service.LoggingService;
import cz.bodyplan.web.interfaces.service.UserService;
import cz.bodyplan.web.vo.dto.LogEntry;

@Service
@Transactional(readOnly = true)
public class LoggingServiceImpl implements LoggingService {

    protected Logger logger = Logger.getLogger(LoggingServiceImpl.class);

    @Autowired
    protected LoggingRepository loggingRepository;

    @Override
    public LogEntry loadById(long id) {
        logger.info("called.loadById");
        return loggingRepository.loadById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void create(LogEntry zaznam) {
        logger.info("called.create");
        loggingRepository.create(zaznam);
    }

    @Override
    public List<LogEntry> getList() {
        logger.info("called.list");
        return loggingRepository.getListOfLogEntries();
    }

}
