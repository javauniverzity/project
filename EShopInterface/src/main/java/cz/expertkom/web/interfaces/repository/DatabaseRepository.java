package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Database;


public interface DatabaseRepository extends GeneralRepository<Database> {

	Database loadByProductName(String productname);

	List<Database> getListOfProducts();
	// TODO pøepsáno, aby sedìlo 
}
