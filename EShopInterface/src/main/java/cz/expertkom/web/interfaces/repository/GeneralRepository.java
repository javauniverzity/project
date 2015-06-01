package cz.expertkom.web.interfaces.repository;

/**
 * Rozhraní repository pro objekt jakéhokoliv typu
 */

public interface GeneralRepository<T extends Object> {

	/**
	 * Vytvoø objekt 
	 */
	void create(T object);

	/**
	 * Odstraò objekt
	 */
	void remove(T object);

	/**
	 * Aktualizuj objekt
	 */
	void update(T object);

	/**
	 * Naèti objekz dle jeho unikátního ID
	 */
	T loadById(Long id);

}
