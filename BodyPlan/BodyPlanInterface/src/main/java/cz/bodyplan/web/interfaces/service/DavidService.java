package cz.bodyplan.web.interfaces.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import cz.bodyplan.web.vo.dto.David;

public interface DavidService extends UserDetailsService {

    David loadById(Long id);

    void create(David david);

    void remove(David david);

    void update(David david);
    
    List<David> getList();
}