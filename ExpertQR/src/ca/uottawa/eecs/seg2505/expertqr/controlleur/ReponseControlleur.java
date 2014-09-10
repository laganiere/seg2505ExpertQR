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

import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;

/**
 * @author Hanna
 *
 */
public class ReponseControlleur {

	protected DBFacade dbFacade = null;
	
	public ReponseControlleur(DBFacade dbFacade) {
		this.dbFacade = dbFacade;
	}
	
	/**
	 * Méthode pour sauvegarder une Reponse
	 * @param reponse
	 */
	public void sauvegardeReponse(Reponse reponse) {
		if (reponse != null
				&& reponse.getTexte() != null
				&& !reponse.getTexte().isEmpty()
				&& reponse.getExpertID() != null
				&& !reponse.getExpertID().isEmpty()) {
			dbFacade.sauvegardeReponse(reponse);
		}
	}
	
	public Reponse getReponsePourQuestion(Question question) {
		Reponse reponse = null;
		
		if (question != null) {
			reponse = dbFacade.getReponsePourQuestion(question);
		}
		 
		return reponse;
	}
}
