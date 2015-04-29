package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.interfaces.repository.GeneralRepository;
import cz.expertkom.web.vo.dto.Authority;

public interface AuthorityService extends GeneralRepository<Authority> {

	Authority getAuthority(String name);

	List<Authority> getList();

}
