/**
 * 
 */
package dev.sgp.entite;

/**
 * @author Kevin M.
 *
 */
public class Departement {

	/** id : Integer */
	private Integer id;
	/** name : String */
	private String name;

	/**
	 * Constructor
	 * 
	 */
	public Departement() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 */
	public Departement(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
