package cz.bodyplan.web.interfaces.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cz.bodyplan.web.interfaces.exception.BusinessException;
import cz.bodyplan.web.vo.dto.User;

public interface DavidService extends UserDetailsService {

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    User loadById(Long id);

    void create(User david);

    void remove(User david);

    List<User> getList();

    void update(User david);

    User registerUser(User david, String email) throws BusinessException;

    User confirmRegistration(String token) throws BusinessException;

    void authenticationUserByUsername(String username);

    void authenticationAnonymous();
}