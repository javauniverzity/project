package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Authority;

public interface AuthorityRepository extends GeneralRepository<Authority> {

	Authority loadByName(String name);

	List<Authority> getList();

}
