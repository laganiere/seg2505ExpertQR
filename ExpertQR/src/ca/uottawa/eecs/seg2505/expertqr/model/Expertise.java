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

import ca.uottawa.eecs.seg2505.expertqr.Constantes;

/**
 * @author Hanna
 *
 */
public class Expertise implements Serializable {

	private static final long serialVersionUID = -3235529468817495364L;
	/**
	 * Les textes des expertises devraient etre uniques.
	 */
	protected String texte = Constantes.STRING_VIDE;
	
	public Expertise() {
	}
	
	/**
	 * @return le texte de l'expertise
	 */
	public String getTexte() {
		return texte;
	}
	
	/**
	 * @param texte le texte de l'expertise
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	@Override
	public String toString() {
		// L'expertise est representee par sont texte
		String s = getTexte();
		if (s == null) {
			s = Constantes.STRING_VIDE;
		}
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		// Deux expertises sont egales si elles ont le meme texte
		if (obj instanceof Expertise) {
			if (getTexte() != null) {
				return getTexte().equals(((Expertise)obj).getTexte());
			}
		}
		return false;
	}
}
