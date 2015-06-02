package cz.expertkom.web.interfaces.repository;

/**
 * Rozhran� repository pro objekt jak�hokoliv typu
 */

public interface GeneralRepository<T extends Object> {

	/**
	 * Vytvo� objekt 
	 */
	void create(T object);

	/**
	 * Odstra� objekt
	 */
	void remove(T object);

	/**
	 * Aktualizuj objekt
	 */
	void update(T object);

	/**
	 * Na�ti objekz dle jeho unik�tn�ho ID
	 */
	T loadById(Long id);

}
