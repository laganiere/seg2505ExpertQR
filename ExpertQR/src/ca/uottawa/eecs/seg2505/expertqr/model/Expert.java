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

/**
 * @author Hanna
 *
 */
public class Expert implements Serializable {
	
	private static final long serialVersionUID = 5736373841598132425L;
	/**
	 * Chaque expert doit avoir une expertise
	 */
	protected Expertise expertise = null;
	/**
	 * La cote de l'expert. La valeur est toujours la moyenne de toutes les cotes.
	 */
	protected double cote = -1;

	public Expert() {
		super();
	}

	/**
	 * @return L'expertise de l'expert
	 */
	public Expertise getExpertise() {
		return expertise;
	}

	/**
	 * @param expertiseID Le ID de l'expertise de l'expert
	 */
	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}

	/**
	 * @return La cote de l'expert
	 */
	public double getCote() {
		return cote;
	}

	/**
	 * @param cote La cote de l'expert
	 */
	public void setCote(double cote) {
		this.cote = cote;
	}
}
