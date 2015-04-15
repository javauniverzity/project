package cz.bodyplan.web.interfaces.service;

import java.util.List;

import cz.bodyplan.web.interfaces.repository.GeneralRepository;
import cz.bodyplan.web.vo.dto.Authority;

public interface AuthorityService extends GeneralRepository<Authority> {

	Authority getAuthority(String name);

	List<Authority> getList();

}
