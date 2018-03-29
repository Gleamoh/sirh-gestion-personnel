/**
 * 
 */
package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

/**
 * @author Kevin M.
 *
 */
public class DepartementService {

	/** listeCollaborateurs : List<Collaborateur> */
	List<Departement> listeDepartements = new ArrayList<>();
	
	/** Constructor
	 * 
	 */
	public DepartementService() {
		listeDepartements.add(new Departement(1, "Comptabilite"));
		listeDepartements.add(new Departement(2, "Ressources Humaines"));
		listeDepartements.add(new Departement(3, "Informatique"));
		listeDepartements.add(new Departement(4, "Administratif"));
	}

	/**
	 * @return : List<Departement>
	 */
	public List<Departement> listerDepartement() {
		return listeDepartements;
	}

	/**
	 * @param collab
	 *            : void
	 */
	public void sauvegarderCollaborateur(Departement dep) {
		listeDepartements.add(dep);
	}

}
