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
package ca.uottawa.eecs.seg2505.expertqr.controlleur;

import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

/**
 * @author Hanna
 *
 */
public class UtilisateurControlleur {
	
	protected DBFacade dbFacade = null;
	
	public UtilisateurControlleur(DBFacade dbFacade) {
		this.dbFacade = dbFacade;
	}
	
	/**
	 * Méthode pour sauvegarder un Utilisateur
	 * @param utilisateur
	 */
	public void sauvegardeUtilisateur(Utilisateur utilisateur) {
		if (utilisateur != null
				&& utilisateur.getNom() != null
				&& !utilisateur.getNom().isEmpty()) {
			dbFacade.sauvegardeUtilisateur(utilisateur);
		}
	}
	
	public List<Utilisateur> getExpertPourExpertise(Expertise expertise) {
		List<Utilisateur> listeUtilisateurs = null;
		
		if (expertise != null
				&& expertise.getTexte() != null
				&& !expertise.getTexte().isEmpty()) {
			listeUtilisateurs = dbFacade.getExpertPourExpertise(expertise);
		}
		 
		return listeUtilisateurs;
	}
}
