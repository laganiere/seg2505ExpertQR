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
import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * @author Hanna
 *
 */
public class ParseFacade extends DBFacade {
	
	// Pour la classe Question
	public String questionClassName = "Question";
	public String questionID = "ID";
	public String questionExpertiseReq = "ExpertiseReq";
	public String questionTexte= "Texte";
	public String questionReponseID = "ReponseID";
	public String questionUtilisateurID = "UtilisateurID";
	
	// Pour la classe Reponse
	public String reponseClassName = "Reponse";
	public String reponseID = "ID";
	public String reponseExpertID = "ExpertID";
	public String reponseQuestionID = "QuestionID";
	public String reponseEvaluation = "Evaluation";
	public String reponseTexte = "Texte";
	
	// Pour la classe Expertise
	public String expertiseClassName = "Expertise";
	public String expertiseTexte = "Texte";
	
	// Pour la classe Utilisateur
	public String utilisateurRoleExpert = "RoleExpert";
	public String utilisateurRoleExpertCote = "RoleExpertCote";
	public String utilisateurRoleExpertExpertise = "RoleExpertExpertise";
	public String utilisateurRoleQuestionneur = "RoleQuestionneur";
	
	public String erreurTag = "ParseFacade";

	/**
	 * 
	 */
	public ParseFacade() {
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getQuestionsPourExpertise(java.lang.String)
	 */
	@Override
	public List<Question> getQuestionsPourExpertise(String expertise) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getQuestionsPourUtilisateur(java.lang.String)
	 */
	@Override
	public List<Question> getQuestionsPourUtilisateur(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getReponsePourQuestion(ca.uottawa.eecs.seg2505.expertqr.model.Question)
	 */
	@Override
	public Reponse getReponsePourQuestion(String questionID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getExpertPourExpertise(ca.uottawa.eecs.seg2505.expertqr.model.Expertise)
	 */
	@Override
	public List<Utilisateur> getExpertPourExpertise(String expertise) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeQuestion(ca.uottawa.eecs.seg2505.expertqr.model.Question)
	 */
	@Override
	public void sauvegardeQuestion(Question question) {
		ParseObject o = new ParseObject(questionClassName);
		o.put(questionExpertiseReq, question.getExpertiseRequise());
		o.put(questionID, question.getID());
		o.put(questionReponseID, question.getReponseID());
		o.put(questionTexte, question.getTexte());
		o.put(questionUtilisateurID, question.getUtilisateurID());
		try {
			o.save();
		} catch (ParseException e) {
			Log.e(erreurTag, e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeReponse(ca.uottawa.eecs.seg2505.expertqr.model.Reponse)
	 */
	@Override
	public void sauvegardeReponse(Reponse reponse) {
		ParseObject o = new ParseObject(reponseClassName);
		o.put(reponseEvaluation, reponse.getEvaluation());
		o.put(reponseExpertID, reponse.getExpertID());
		o.put(reponseID, reponse.getID());
		o.put(reponseQuestionID, reponse.getQuestionID());
		o.put(reponseTexte, reponse.getTexte());
		try {
			o.save();
		} catch (ParseException e) {
			Log.e(erreurTag, e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeUtilisateur(ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur)
	 */
	@Override
	public void sauvegardeUtilisateur(Utilisateur utilisateur) {
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
		
		try {
			user.save();
		} catch (ParseException e) {
			Log.e(erreurTag, e.getMessage());
		};
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeExpertise(ca.uottawa.eecs.seg2505.expertqr.model.Expertise)
	 */
	@Override
	public void sauvegardeExpertise(Expertise expertise) {
		ParseObject o = new ParseObject(expertiseClassName);
		o.put(expertiseTexte, expertise.getTexte());
		try {
			o.save();
		} catch (ParseException e) {
			Log.e(erreurTag, e.getMessage());
		}
	}

}
