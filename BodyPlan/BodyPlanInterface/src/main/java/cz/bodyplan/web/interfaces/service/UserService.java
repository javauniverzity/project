package cz.bodyplan.web.interfaces.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cz.bodyplan.web.interfaces.exception.BusinessException;
import cz.bodyplan.web.vo.dto.User;

public interface UserService extends UserDetailsService {

	@Override
	User loadUserByUsername(String username) throws UsernameNotFoundException;

	User loadById(Long id);

	void create(User user);

	void remove(User user);

	List<User> getList();

	void update(User user);

	void authenticationUserByUsername(String username);

	User registerUser(User user, String email) throws BusinessException;

	void authenticationAnonymous();

	User confirmRegistration(String token) throws BusinessException;

}