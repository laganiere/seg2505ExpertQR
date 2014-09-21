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
package ca.uottawa.eecs.seg2505.expertqr;

import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.controlleur.ExpertiseControlleur;
import ca.uottawa.eecs.seg2505.expertqr.controlleur.QuestionControlleur;
import ca.uottawa.eecs.seg2505.expertqr.controlleur.ReponseControlleur;
import ca.uottawa.eecs.seg2505.expertqr.controlleur.UtilisateurControlleur;
import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

/**
 * @author Hanna
 *
 */
public class Delegateur {
	
	public static DBFacade dbFacade = null;
	public static QuestionControlleur questionControlleur = null;
	public static ReponseControlleur reponseControlleur = null;
	public static UtilisateurControlleur utilisateurControlleur = null;
	public static ExpertiseControlleur expertiseControlleur = null;
	
	public static void setDBFacade(DBFacade dbFacade) {
		questionControlleur = new QuestionControlleur(dbFacade);
		reponseControlleur = new ReponseControlleur(dbFacade);
		utilisateurControlleur = new UtilisateurControlleur(dbFacade);
		expertiseControlleur = new ExpertiseControlleur(dbFacade);
	}
	
	public static List<Question> getQuestionsPourExpertise(Expertise expertise) {
		return questionControlleur.getQuestionsPourExpertise(expertise);
	}
	
	public static List<Question> getQuestionsPourUtilisateur(Utilisateur utilisateur) {
		 return questionControlleur.getQuestionsPourUtilisateur(utilisateur);
	}
	
	public static Reponse getReponsePourQuestion(Question question) {
		return reponseControlleur.getReponsePourQuestion(question);
	}
	
	public static List<Expertise> getListeExpertises() {
		 return expertiseControlleur.getListeExpertises();
	}
	
	/**
	 * Méthode pour sauvegarder une Question
	 * @param question
	 */
	public static void sauvegardeQuestion(Question question) {
		questionControlleur.sauvegardeQuestion(question);
	}
	
	/**
	 * Méthode pour sauvegarder une Reponse
	 * @param reponse
	 */
	public static void sauvegardeReponse(Reponse reponse) {
		reponseControlleur.sauvegardeReponse(reponse);
	}
	
	/**
	 * Méthode pour sauvegarder un Utilisateur
	 * @param utilisateur
	 */
	public static void sauvegardeUtilisateur(Utilisateur utilisateur) {
		utilisateurControlleur.sauvegardeUtilisateur(utilisateur);
	}
	
	/**
	 * Méthode pour sauvegarder une Expertise
	 * @param expertise
	 */
	public static void sauvegardeExpertise(Expertise expertise) {
		expertiseControlleur.sauvegardeExpertise(expertise);
	}

}
