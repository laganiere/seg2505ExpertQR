/**
 * This file contains material supporting the course SEG2505: Introduction to Software 
 * Engineering at the University of Ottawa.
 *
 * This program is free software; permission is hereby granted to use, copy, modify,
 * and distribute this source code, or portions thereof, for any purpose, without fee,
 * subject to the restriction that the copyright notice may not be removed
 * or altered from any source or altered source distribution.
 * The software is released on an as-is basis and without any warranties of any kind.
 * In particular, the software is not guaranteed to be fault-tolerant or free from failure.
 * The author disclaims all warranties with regard to this software, any use,
 * and any consequent failure, is purely the responsibility of the user.
 */
package ca.uottawa.eecs.seg2505.expertqr.model;

import java.io.Serializable;
import java.util.UUID;

import ca.uottawa.eecs.seg2505.expertqr.Constantes;

/**
 * La classe Question
 * @author Hanna
 *
 */
public class Question implements Serializable {
	
	private static final long serialVersionUID = -2502857776137042033L;
	/**
	 * le ID unique de la question
	 */
	protected String ID = Constantes.STRING_VIDE;
	/**
	 * Le texte de la question
	 */
	protected String texte = Constantes.STRING_VIDE;
	/**
	 * L'expertise requise pour repondre a la question
	 */
	protected Expertise expertiseRequise = null;
	/**
	 * Le ID de l'utilisateur qui a demande la question
	 */
	protected String utilisateurID = Constantes.STRING_VIDE;
	/**
	 * La reponse a la question
	 */
	protected Reponse reponse = null;
	
	public Question() {	
		this.ID = UUID.randomUUID().toString();
	}
	
	/**
	 * @return le ID de la question
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * @param ID le ID de la question
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * @return le texte de la question
	 */
	public String getTexte() {
		return texte;
	}
	
	/**
	 * @param texte le texte de la question
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	/**
	 * @return L'expertise requise pour repondre a la question
	 */
	public Expertise getExpertiseRequise() {
		return expertiseRequise;
	}
	
	/**
	 * @param expertise L'expertise requise pour repondre a la question
	 */
	public void setExpertiseRequise(Expertise expertise) {
		this.expertiseRequise = expertise;
	}
	
	/**
	 * @return Le ID de l'utilisateur qui a demande la question
	 */
	public String getUtilisateurID() {
		return utilisateurID;
	}
	
	/**
	 * @param utilisateurID Le ID de l'utilisateur qui a demande la question
	 */
	public void setUtilisateurID(String utilisateurID) {
		this.utilisateurID = utilisateurID;
	}

	/**
	 * @return La reponse a la question
	 */
	public Reponse getReponse() {
		return reponse;
	}
	
	/**
	 * @return Le ID de la reponse a la question
	 */
	public String getReponseID() {
		if (reponse != null) {
			return reponse.getID();
		}
		return Constantes.STRING_VIDE;
	}

	/**
	 * @param reponse La reponse a la question
	 */
	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}
	
	@Override
	public String toString() {
		// Une question est representee par son texte
		return getTexte();
	}
}
