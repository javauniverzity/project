package cz.bodyplan.web.interfaces.service;

import cz.bodyplan.web.vo.dto.Pavel;

public interface PavelService {

	Pavel loadById(Long id);

	void create(Pavel pavel);

	void remove(Pavel pavel);

	void update(Pavel pavel);

}