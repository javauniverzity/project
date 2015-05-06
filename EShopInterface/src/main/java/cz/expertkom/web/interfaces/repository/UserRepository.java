package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Basket;
import cz.expertkom.web.vo.dto.User;

/**
 * DAO object for accession the database.
 * 
 * @author Pavel Lukes
 * 
 */
public interface UserRepository extends GeneralRepository<User> {
	
	
	User loadUserByUsername(String username);

	List<Basket> getListOfBasket(final User user);
	List<User> getListOfUsers();
}
