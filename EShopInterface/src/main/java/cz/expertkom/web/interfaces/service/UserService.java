package cz.expertkom.web.interfaces.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cz.expertkom.web.vo.dto.User;

public interface UserService extends UserDetailsService {

	@Override
	User loadUserByUsername(String username) throws UsernameNotFoundException;

	User loadById(Long id);

	void create(User user);

	void remove(User user);

	List<User> getList();

	void update(User user);



}