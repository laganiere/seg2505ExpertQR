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
package ca.uottawa.seg2505.expertqrandroid.util;

import ca.uottawa.eecs.seg2505.expertqr.Constantes;
import ca.uottawa.eecs.seg2505.expertqr.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.model.Expert;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;
import ca.uottawa.seg2505.expertqrandroid.parse.ParseObjectAdapteur;

import com.parse.ParseUser;

/**
 * Classe pour manipuler les objets Utilisateur dans Parse et leurs expertises.
 * 
 * @author Hanna
 *
 */
public class UtilisateurUtil {
	
	/**
	 * @return L'utilisateur actuel de l'application
	 */
	public static Utilisateur getUtilisateur() {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			return ParseObjectAdapteur.toUtilisateur(user);
		}
		return null;
	}
	
	/**
	 * @return true si l'utilisateur actuel est un expert, sinon false 
	 */
	public static boolean isExpert() {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			return user.getRoleExpert() != null;
		}
		return false;
	}
	
	/**
	 * @return L'expertise de l'utilisateur actuel
	 */
	public static Expertise getExpertise() {
		Expertise expertise = null;
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			Expert expert = ParseObjectAdapteur.toUtilisateur(user).getRoleExpert();
			if (expert != null) {
				expertise = expert.getExpertise();
			}
		}
		return expertise;
	}
	
	/**
	 * @param expertise L'expertise de l'utilisateur actuel
	 */
	public static void setExpertise(Expertise expertise) {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			Expert expert = new Expert();
			expert.setExpertise(expertise);
			user.setRoleExpert(expert);
			Delegateur.sauvegardeUtilisateur(user);
		}
	}
	
	/**
	 * @return Le nom de l'utilisateur actuel 
	 */ 
	public static String getUsername() {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			return user.getNom();
		}
		return Constantes.STRING_VIDE;
	}
}
