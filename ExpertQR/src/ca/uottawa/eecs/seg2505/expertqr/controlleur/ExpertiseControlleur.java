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
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;

/**
 * @author Hanna
 *
 */
public class ExpertiseControlleur {

	protected DBFacade dbFacade = null;
	
	public ExpertiseControlleur(DBFacade dbFacade) {
		this.dbFacade = dbFacade;
	}
	
	/**
	 * Méthode pour sauvegarder une Expertise
	 * @param expertise
	 */
	public void sauvegardeExpertise(Expertise expertise) {
		if (expertise != null
				&& expertise.getTexte() != null
				&& !expertise.getTexte().isEmpty()) {
			dbFacade.sauvegardeExpertise(expertise);
		}
	}
}
