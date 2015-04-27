package cz.bodyplan.web.interfaces.service;

import java.util.List;

import cz.bodyplan.web.vo.dto.LogEntry;

public interface LoggingService {

    public LogEntry loadById(long id);

    public void create(LogEntry zaznam);
    
    public List<LogEntry> getList();
}
