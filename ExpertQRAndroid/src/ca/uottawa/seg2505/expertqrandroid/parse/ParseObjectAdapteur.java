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

package ca.uottawa.seg2505.expertqrandroid.parse;

import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * @author Hanna
 *
 */
public class ParseObjectAdapteur {

	// Pour la classe Question
	public static String questionClassName = "Question";
	public static String questionID = "ID";
	public static String questionExpertiseReq = "ExpertiseReq";
	public static String questionTexte= "Texte";
	public static String questionReponseID = "ReponseID";
	public static String questionUtilisateurID = "UtilisateurID";
	
	// Pour la classe Reponse
	public static String reponseClassName = "Reponse";
	public static String reponseID = "ID";
	public static String reponseExpertID = "ExpertID";
	public static String reponseQuestionID = "QuestionID";
	public static String reponseEvaluation = "Evaluation";
	public static String reponseTexte = "Texte";
	
	// Pour la classe Expertise
	public static String expertiseClassName = "Expertise";
	public static String expertiseTexte = "Texte";
	
	// Pour la classe Utilisateur
	public static String utilisateurRoleExpert = "RoleExpert";
	public static String utilisateurRoleExpertCote = "RoleExpertCote";
	public static String utilisateurRoleExpertExpertise = "RoleExpertExpertise";
	public static String utilisateurRoleQuestionneur = "RoleQuestionneur";
	
	public static String erreurTag = "ParseFacade";
		
	public static ParseObject from(Question question) {
		ParseObject o = new ParseObject(questionClassName);
		o.put(questionExpertiseReq, question.getExpertiseRequise());
		o.put(questionID, question.getID());
		o.put(questionReponseID, question.getReponseID());
		o.put(questionTexte, question.getTexte());
		o.put(questionUtilisateurID, question.getUtilisateurID());
		return o;
	}
	
	public static ParseObject from(Reponse reponse) {
		ParseObject o = new ParseObject(reponseClassName);
		o.put(reponseEvaluation, reponse.getEvaluation());
		o.put(reponseExpertID, reponse.getExpertID());
		o.put(reponseID, reponse.getID());
		o.put(reponseQuestionID, reponse.getQuestionID());
		o.put(reponseTexte, reponse.getTexte());
		return o;
	}
	
	public static ParseObject from(Expertise expertise) {
		ParseObject o = new ParseObject(expertiseClassName);
		o.put(expertiseTexte, expertise.getTexte());
		return o;
	}
	
	public static ParseUser from(Utilisateur utilisateur) {
		ParseUser user = new ParseUser();
		user.setUsername(utilisateur.getNom());
		if (utilisateur.getRoleQuestionneur() != null) {
			user.put(utilisateurRoleQuestionneur, true);
		}
		if (utilisateur.getRoleExpert() != null) {
			user.put(utilisateurRoleExpert, true);
			user.put(utilisateurRoleExpertExpertise, utilisateur.getRoleExpert().getExpertise());
			user.put(utilisateurRoleExpertCote, utilisateur.getRoleExpert().getCote());
		}
		return user;
	}
	
	public static Question toQuestion(ParseObject pObject) {
		Question question = new Question();
		return question;
	}
	
	public static Reponse toReponse(ParseObject pObject) {
		Reponse reponse = new Reponse();
		return reponse;
	}
	
	public static Expertise toExpertise(ParseObject pObject) {
		Expertise expertise = new Expertise();
		return expertise;
	}
	
	public static Utilisateur toUtilisateur(ParseObject pObject) {
		Utilisateur utilisateur = new Utilisateur();
		return utilisateur;
	}
}
