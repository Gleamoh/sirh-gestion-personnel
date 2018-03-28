/**
 * 
 */
package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;

/**
 * @author Kevin M.
 *
 */
public class CollaborateurService {

	/** listeCollaborateurs : List<Collaborateur> */
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	/**
	 * @return : List<Collaborateur>
	 */
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	/**
	 * @param collab : void
	 */
	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

}
