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

package ca.uottawa.eecs.seg2505.expertqr.test;

import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.db.MemoireFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Expert;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

/**
 * @author Hanna
 *
 */
public class Test {

	public static void main(String[] args) {
		DBFacade localDB = new MemoireFacade();
		Delegateur.setDBFacade(localDB);
		
		Expertise expertise = new Expertise();
		expertise.setTexte("Oracle");
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Hanna");
		
		Question question = new Question();
		question.setTexte("C'est quoi ton nom?");
		question.setUtilisateurID(utilisateur.getNom());
		question.setExpertiseRequise(expertise);
		
		Utilisateur expert = new Utilisateur();
		expert.setNom("Expert1");
		expert.setRoleExpert(new Expert());
		expert.getRoleExpert().setExpertise(expertise);
		
		// sauvegarder les donnees
		Delegateur.getInstance().sauvegardeExpertise(expertise);
		Delegateur.getInstance().sauvegardeUtilisateur(utilisateur);
		Delegateur.getInstance().sauvegardeUtilisateur(expert);
		Delegateur.getInstance().sauvegardeQuestion(question);
		
		// teste pour obtenir une question pour une expertise
		List<Question> qPourExp = Delegateur.getInstance().getQuestionsPourExpertise(expertise);
		if (!qPourExp.contains(question)) {
			System.out.println("Erreur: question pour expertise non existante");
		}
		
		// teste pour obtenir une question pour un utilisateur
		List<Question> qPourUti = Delegateur.getInstance().getQuestionsPourUtilisateur(utilisateur);
		if (!qPourUti.contains(question)) {
			System.out.println("Erreur: question pour utilisateur non existante");
		}
		
		// L'expert repond a la question
		Reponse reponse = new Reponse();
		reponse.setTexte("C'est Hanna");
		reponse.setQuestion(question);
		question.setReponse(reponse);
		Delegateur.getInstance().sauvegardeReponse(reponse);
		
		// teste pour obtenir une reponse a une question
		Reponse rep = Delegateur.getInstance().getReponsePourQuestion(question);
		if (rep == null) {
			System.out.println("Erreur: reponse pour question non existante");
		}
		
		System.out.println("Fin du test");
	}

}
