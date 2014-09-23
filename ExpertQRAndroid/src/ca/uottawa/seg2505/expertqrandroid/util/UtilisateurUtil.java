package ca.uottawa.seg2505.expertqrandroid.util;

import ca.uottawa.eecs.seg2505.expertqr.Constantes;
import ca.uottawa.eecs.seg2505.expertqr.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.model.Expert;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;
import ca.uottawa.seg2505.expertqrandroid.parse.ParseObjectAdapteur;

import com.parse.ParseUser;

public class UtilisateurUtil {
	
	public static Utilisateur getUtilisateur() {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			return ParseObjectAdapteur.toUtilisateur(user);
		}
		return null;
	}
	
	public static boolean isExpert() {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			return user.getRoleExpert() != null;
		}
		return false;
	}
	
	public static void setExpert(boolean valeur) {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			if (valeur) {
				user.setRoleExpert(new Expert());
			} else {
				user.setRoleExpert(null);
			}
			Delegateur.sauvegardeUtilisateur(user);
		}
	}
	
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
	
	public static void setExpertise(Expertise expertise) {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			Expert expert = new Expert();
			expert.setExpertise(expertise);
			user.setRoleExpert(expert);
			Delegateur.sauvegardeUtilisateur(user);
		}
	}
	
	public static String getUsername() {
		Utilisateur user = getUtilisateur();
		if (user != null) {
			return user.getNom();
		}
		return Constantes.STRING_VIDE;
	}
}
