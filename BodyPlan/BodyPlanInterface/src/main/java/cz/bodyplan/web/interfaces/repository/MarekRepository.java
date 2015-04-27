package cz.bodyplan.web.interfaces.repository;

import java.util.List;

import cz.bodyplan.web.vo.dto.Marek;

public interface MarekRepository extends GeneralRepository<Marek> {

	List<Marek> getListOfMareks();

}
