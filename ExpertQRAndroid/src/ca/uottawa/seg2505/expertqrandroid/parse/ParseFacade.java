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

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
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
public class ParseFacade extends DBFacade {
	
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
		List<Question> listeQuestions = new ArrayList<Question>();
		
		if (expertise != null
				&& !expertise.isEmpty()) {
			ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ParseObjectAdapteur.questionClassName);
			query.whereEqualTo(ParseObjectAdapteur.questionExpertiseReq, expertise);
			try {
				List<ParseObject> resultat = query.find();
				// adapt to Question
				for (ParseObject parseObject : resultat) {
					listeQuestions.add(ParseObjectAdapteur.toQuestion(parseObject));
				}
				
			} catch (ParseException e) {
				Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
			}
		}
		 
		return listeQuestions;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getQuestionsPourUtilisateur(java.lang.String)
	 */
	@Override
	public List<Question> getQuestionsPourUtilisateur(String nom) {
		List<Question> listeQuestions = new ArrayList<Question>();
		
		if (nom != null
				&& !nom.isEmpty()) {
			ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ParseObjectAdapteur.questionClassName);
			query.whereEqualTo(ParseObjectAdapteur.questionUtilisateurID, nom);
			try {
				List<ParseObject> resultat = query.find();
				// adapt to Question
				for (ParseObject parseObject : resultat) {
					listeQuestions.add(ParseObjectAdapteur.toQuestion(parseObject));
				}
				
			} catch (ParseException e) {
				Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
			}
		}
		 
		return listeQuestions;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getReponsePourQuestion(ca.uottawa.eecs.seg2505.expertqr.model.Question)
	 */
	@Override
	public Reponse getReponsePourQuestion(String questionID) {
		Reponse reponse = null;
		
		if (questionID != null
				&& !questionID.isEmpty()) {
			ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ParseObjectAdapteur.reponseClassName);
			query.whereEqualTo(ParseObjectAdapteur.reponseQuestionID, questionID);
			try {
				List<ParseObject> resultat = query.find();
				// adapt to Reponse
				if (resultat.size() > 0) {
					reponse = ParseObjectAdapteur.toReponse(resultat.get(0));
				}
			} catch (ParseException e) {
				Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
			}
		}
		 
		return reponse;
	}
	
	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#getListeExpertises()
	 */
	@Override
	public List<Expertise> getListeExpertises() {
		ArrayList<Expertise> expertises = new ArrayList<Expertise>();
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(ParseObjectAdapteur.expertiseClassName);
		try {
			List<ParseObject> resultat = query.find();
			// adapt to Expertise
			for (ParseObject parseObject : resultat) {
				expertises.add(ParseObjectAdapteur.toExpertise(parseObject));
			}
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		}
		return expertises;
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeQuestion(ca.uottawa.eecs.seg2505.expertqr.model.Question)
	 */
	@Override
	public void sauvegardeQuestion(Question question) {
		ParseObject o = ParseObjectAdapteur.from(question);
		
		try {
			o.save();
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeReponse(ca.uottawa.eecs.seg2505.expertqr.model.Reponse)
	 */
	@Override
	public void sauvegardeReponse(Reponse reponse) {
		ParseObject o = ParseObjectAdapteur.from(reponse);
		
		try {
			o.save();
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeUtilisateur(ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur)
	 */
	@Override
	public void sauvegardeUtilisateur(Utilisateur utilisateur) {
		ParseUser user = ParseObjectAdapteur.from(utilisateur);
		
		try {
			user.save();
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		};
	}

	/* (non-Javadoc)
	 * @see ca.uottawa.eecs.seg2505.expertqr.db.DBFacade#sauvegardeExpertise(ca.uottawa.eecs.seg2505.expertqr.model.Expertise)
	 */
	@Override
	public void sauvegardeExpertise(Expertise expertise) {
		ParseObject o = ParseObjectAdapteur.from(expertise);
		
		try {
			o.save();
		} catch (ParseException e) {
			Log.e(ParseObjectAdapteur.erreurTag, e.getMessage());
		}
	}
	
	public static ParseUser getParseUser(String nom) {
		ParseUser user = null;
		ParseQuery<ParseUser> query = ParseUser.getQuery();
		query.whereEqualTo("username", nom);
		
		try {
			List<ParseUser> list = query.find();
			if (list.size() > 0) {
				user = list.get(0);
			}
		} catch (ParseException e) {
		}
		
		return user;
	}

}
