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
public class Reponse implements Serializable {
	
	private static final long serialVersionUID = 2028078514689553029L;
	/**
	 */
	protected String texte = Constantes.STRING_VIDE;
	/**
	 */
	protected String expertID = Constantes.STRING_VIDE;
	/**
	 */
	protected int evaluation = -1;
	/**
	 */
	protected Question question = null;
	
	public Reponse() {	
	}
	
	/**
	 * @return
	 */
	public String getTexte() {
		return texte;
	}
	
	/**
	 * @param texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	/**
	 * @return
	 */
	public String getExpertID() {
		return expertID;
	}
	
	/**
	 * @param expertID
	 */
	public void setExpertID(String expertID) {
		this.expertID = expertID;
	}
	
	/**
	 * @return
	 */
	public int getEvaluation() {
		return evaluation;
	}
	
	/**
	 * @param eval
	 */
	public void setEvaluation(int eval) {
		this.evaluation = eval;
	}

	/**
	 * @return
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
}
