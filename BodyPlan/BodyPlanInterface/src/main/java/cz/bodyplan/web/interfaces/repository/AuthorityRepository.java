package cz.bodyplan.web.interfaces.repository;

import java.util.List;

import cz.bodyplan.web.vo.dto.Authority;

public interface AuthorityRepository extends GeneralRepository<Authority> {

	Authority loadByName(String name);

	List<Authority> getList();

}
