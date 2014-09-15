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

import java.util.List;

import android.util.Log;
import ca.uottawa.eecs.seg2505.expertqr.model.Expert;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Questionneur;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
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
		Question question = toQuestionSansReponse(pObject);
		
		Reponse reponse = getReponseSansQuestion(pObject.getString(questionReponseID));
		reponse.setQuestion(question);
		question.setReponse(reponse);
		
		return question;
	}
	
	/**
	 * La methode suivante est pour usage interne. Elle fait le loading d'une
	 * Question sans faire le loading de sa Reponse pour eviter une loupe infinie.
	 */
	private static Question getQuestionSansReponse(String questionID) {
		Question question = new Question();
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ParseObjectAdapteur.questionClassName);
		query.whereEqualTo(ParseObjectAdapteur.questionID, questionID);
		try {
			List<ParseObject> resultat = query.find();
			// adapt to Question
			if (resultat.size() > 0) {
				question = ParseObjectAdapteur.toQuestionSansReponse(resultat.get(0));
			}
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		}
		
		return question;
	}
	
	private static Question toQuestionSansReponse(ParseObject pObject) {
		Question question = new Question();
		
		Expertise expertise = new Expertise();
		expertise.setTexte(pObject.getString(questionExpertiseReq));
		question.setExpertiseRequise(expertise);
		
		question.setTexte(pObject.getString(questionTexte));
		question.setUtilisateurID(pObject.getString(questionUtilisateurID));
		question.setID(pObject.getString(questionID));

		return question;
	}
	
	public static Reponse toReponse(ParseObject pObject) {
		Reponse reponse = toReponseSansQuestion(pObject);
		
		Question question = getQuestionSansReponse(pObject.getString(reponseQuestionID));
		question.setReponse(reponse);
		reponse.setQuestion(question);
		
		return reponse;
	}
	
	/**
	 * La methode suivante est pour usage interne. Elle fait le loading d'une
	 * Reponse sans faire le loading de sa Question pour eviter une loupe infinie.
	 */
	private static Reponse getReponseSansQuestion(String reponseID) {
		Reponse reponse = new Reponse();
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ParseObjectAdapteur.reponseClassName);
		query.whereEqualTo(ParseObjectAdapteur.reponseID, reponseID);
		try {
			List<ParseObject> resultat = query.find();
			// adapt to Question
			if (resultat.size() > 0) {
				reponse = ParseObjectAdapteur.toReponseSansQuestion(resultat.get(0));
			}
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		}
		
		return reponse;
	}
	
	private static Reponse toReponseSansQuestion(ParseObject pObject) {
		Reponse reponse = new Reponse();
		
		reponse.setEvaluation(pObject.getInt(reponseEvaluation));
		reponse.setExpertID(pObject.getString(reponseExpertID));
		reponse.setID(pObject.getString(reponseID));
		reponse.setTexte(pObject.getString(reponseTexte));
		
		return reponse;
	}
	
	public static Expertise toExpertise(ParseObject pObject) {
		Expertise expertise = new Expertise();
		expertise.setTexte(pObject.getString(expertiseTexte));
		return expertise;
	}
	
	public static Utilisateur toUtilisateur(ParseUser user) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(user.getUsername());

		if (user.getBoolean(utilisateurRoleQuestionneur)) {
			utilisateur.setRoleQuestionneur(new Questionneur());
		}
		if (user.getBoolean(utilisateurRoleExpert)) {
			Expert expert = new Expert();
			
			Expertise expertise = new Expertise();
			expertise.setTexte(user.getString(utilisateurRoleExpertExpertise));
			expert.setExpertise(expertise);
			
			expert.setCote(user.getDouble(utilisateurRoleExpertCote));
			
			utilisateur.setRoleExpert(expert);
		}
		
		return utilisateur;
	}
}
