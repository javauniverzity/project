package cz.bodyplan.web.interfaces.service;

import cz.bodyplan.web.vo.dto.Marek;

public interface MarekService {
	
	Marek loadById(Long Id);
	
	void create (Marek marek);
	
	void remove (Marek marek);
	
	void update (Marek marek);
	

}
