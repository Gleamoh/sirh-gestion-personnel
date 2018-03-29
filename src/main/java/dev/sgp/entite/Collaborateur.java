/**
 * 
 */
package dev.sgp.entite;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Kevin M.
 *
 */
public class Collaborateur {
	
	/** matricule : String */
	private String matricule;
	/** nom : String */
	private String nom;
	/** prenom : String */
	private String prenom;
	/** adresse : String */
	private String adresse;
	/** numeroSecuriteSociale : String */
	private String numeroSecuriteSociale;
	/** emailProfessionnel : String */
	private String emailProfessionnel;
	/** photo : String */
	private String photo;
	/** dateNaissance : LocalDate */
	private LocalDate dateNaissance;
	/** dateHeureCreation : LocalDateTime */
	private LocalDateTime dateHeureCreation;
	/** estActif : Boolean */
	private Boolean estActif;
	/** intitulePoste : String */
	private String intitulePoste;
	/** departement : Departement */
	private Departement departement;
	
	/** Constructor
	 * 
	 */
	public Collaborateur() {
	}


	/** Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}


	/** Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/** Getter
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/** Getter
	 * @return the numeroSecuriteSociale
	 */
	public String getNumeroSecuriteSociale() {
		return numeroSecuriteSociale;
	}


	/** Setter
	 * @param numeroSecuriteSociale the numeroSecuriteSociale to set
	 */
	public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
		this.numeroSecuriteSociale = numeroSecuriteSociale;
	}


	/** Getter
	 * @return the emailProfessionnel
	 */
	public String getEmailProfessionnel() {
		return emailProfessionnel;
	}


	/** Setter
	 * @param emailProfessionnel the emailProfessionnel to set
	 */
	public void setEmailProfessionnel(String emailProfessionnel) {
		this.emailProfessionnel = emailProfessionnel;
	}


	/** Getter
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}


	/** Setter
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	/** Getter
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}


	/** Setter
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}


	/** Getter
	 * @return the estActif
	 */
	public Boolean getEstActif() {
		return estActif;
	}


	/** Setter
	 * @param estActif the estActif to set
	 */
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}


	/** Getter
	 * @return the intitulePoste
	 */
	public String getIntitulePoste() {
		return intitulePoste;
	}


	/** Setter
	 * @param intitulePoste the intitulePoste to set
	 */
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}


	/** Getter
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}


	/** Setter
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
