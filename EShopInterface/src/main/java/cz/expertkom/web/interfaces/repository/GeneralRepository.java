package cz.expertkom.web.interfaces.repository;

public interface GeneralRepository<T extends Object> {

	void create(T object);

	void remove(T object);

	void update(T object);

	T loadById(Long id);

}
