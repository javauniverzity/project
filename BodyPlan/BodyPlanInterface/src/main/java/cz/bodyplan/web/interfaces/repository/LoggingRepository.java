package cz.bodyplan.web.interfaces.repository;

import java.util.List;

import cz.bodyplan.web.vo.dto.LogEntry;

public interface LoggingRepository extends GeneralRepository<LogEntry> {
    public List<LogEntry> getListOfLogEntries();

}
