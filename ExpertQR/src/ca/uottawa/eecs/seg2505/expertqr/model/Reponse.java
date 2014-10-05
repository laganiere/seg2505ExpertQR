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
 * @author Hanna
 *
 */
public class Reponse implements Serializable {
	
	private static final long serialVersionUID = 2028078514689553029L;
	/**
	 * Le ID de la reponse
	 */
	protected String ID = Constantes.STRING_VIDE;
	/**
	 * Le texte de la reponse
	 */
	protected String texte = Constantes.STRING_VIDE;
	/**
	 * Le ID de l'expert qui a donne la reponse
	 */
	protected String expertID = Constantes.STRING_VIDE;
	/**
	 * L'evaluation qui est donne par l'utilisateur a la reponse donnee
	 */
	protected int evaluation = -1;
	/**
	 * La question a laquelle on repond
	 */
	protected Question question = null;
	
	public Reponse() {	
		this.ID = UUID.randomUUID().toString();
	}
	
	/**
	 * @return Le ID de la reponse
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * @param ID Le ID de la reponse
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * @return Le texte de la reponse
	 */
	public String getTexte() {
		return texte;
	}
	
	/**
	 * @param texte Le texte de la reponse
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	/**
	 * @return Le ID de l'expert qui a donne la reponse
	 */
	public String getExpertID() {
		return expertID;
	}
	
	/**
	 * @param expertID Le ID de l'expert qui a donne la reponse
	 */
	public void setExpertID(String expertID) {
		this.expertID = expertID;
	}
	
	/**
	 * @return L'evaluation qui est donne par l'utilisateur a la reponse donnee
	 */
	public int getEvaluation() {
		return evaluation;
	}
	
	/**
	 * @param eval L'evaluation qui est donne par l'utilisateur a la reponse donnee
	 */
	public void setEvaluation(int eval) {
		this.evaluation = eval;
	}

	/**
	 * @return La question a laquelle on repond
	 */
	public Question getQuestion() {
		return question;
	}
	
	/**
	 * @return Le ID de la question a laquelle on repond
	 */
	public String getQuestionID() {
		if (question != null) {
			return question.getID();
		}
		return Constantes.STRING_VIDE;
	}

	/**
	 * @param question La question a laquelle on repond
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		// Une reponse est representee par son texte
		return getTexte();
	}
}
