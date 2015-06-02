package cz.expertkom.be.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.expertkom.web.interfaces.repository.UserRepository;
import cz.expertkom.web.interfaces.service.UserService;
import cz.expertkom.web.vo.dto.User;

/**
 * Implementace povinnych metod pro objekt uzivatel
 * @author David
 *
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	/**
	 * vrati uzivatele podle uzivatelskeho jmena, to je jedinecnne
	 */
	@Override
	public User loadUserByUsername(final String username) {
		if (username == null || "".equals(username)) {
			return null;
		}
		logger.debug("loadUserByUsername :: " + username);
		final User user = userRepository.loadUserByUsername(username);

		return user;
	}

	/**
	 * vrati uzivatele podle id, jedinecneho identifikatoru
	 */
	@Override
	public User loadById(final Long id) {
		return userRepository.loadById(id);
	}

	/**
	 * vytvoreni uzivatele
	 * 
	 * @throws BusinessException
	 */
	@Override
	@Transactional(readOnly = false)
	public void create(final User user) {
		userRepository.create(user);
	}

	/**
	 * odstraneni uzivatele podle uzivatelskeho jmena
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(final User user) {
		userRepository.remove(user);
	}

	/**
	 * vrati vsechny uzivatele systemu
	 */
	@Override
	public List<User> getList() {
		return userRepository.getListOfUsers();
	}

	/**
	 * ulozeni zmen uzivatele
	 */
	@Override
	@Transactional(readOnly = false)
	public void update(final User user) {

		userRepository.update(user);
	}

}
