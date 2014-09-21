package ca.uottawa.eecs.seg2505.expertqr.db;

import java.util.ArrayList;
import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

public class MemoireFacade extends DBFacade {

	// garder tous les donnees en memoire
	protected List<Question> questions = new ArrayList<Question>();
	protected List<Expertise> expertises = new ArrayList<Expertise>();
	protected List<Reponse> reponses = new ArrayList<Reponse>();
	protected List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	@Override
	public List<Question> getQuestionsPourExpertise(String expertise) {
		List<Question> resultat = new ArrayList<Question>();
		for (Question quest : questions) {
			if (quest.getExpertiseRequise() != null
					&& quest.getExpertiseRequise().getTexte() != null
					&& quest.getExpertiseRequise().getTexte().equals(expertise)) {
				resultat.add(quest);
			}
		}
		return resultat;
	}

	@Override
	public List<Question> getQuestionsPourUtilisateur(String nom) {
		List<Question> resultat = new ArrayList<Question>();
		for (Question quest : questions) {
			if (quest.getUtilisateurID() != null
					&& quest.getUtilisateurID().equals(nom)) {
				resultat.add(quest);
			}
		}
		return resultat;
	}

	@Override
	public Reponse getReponsePourQuestion(String questionID) {
		for (Question quest : questions) {
			if (quest.getID().equals(questionID)) {
				return quest.getReponse();
			}
		}
		for (Reponse rep : reponses) {
			if (rep.getQuestion().getID().equals(questionID)) {
				return rep;
			}
		}
		return null;
	}
	
	@Override
	public List<Expertise> getListeExpertises() {
		return expertises;
	}

	@Override
	public void sauvegardeQuestion(Question question) {
		questions.add(question);
	}

	@Override
	public void sauvegardeReponse(Reponse reponse) {
		reponses.add(reponse);
	}

	@Override
	public void sauvegardeUtilisateur(Utilisateur utilisateur) {
		utilisateurs.add(utilisateur);
	}

	@Override
	public void sauvegardeExpertise(Expertise expertise) {
		expertises.add(expertise);
	}

}
