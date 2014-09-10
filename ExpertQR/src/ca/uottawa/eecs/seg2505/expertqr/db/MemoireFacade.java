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
	public List<Question> getQuestionsPourUtilisateur(String userID) {
		List<Question> resultat = new ArrayList<Question>();
		for (Question quest : questions) {
			if (quest.getUtilisateurID() != null
					&& quest.getUtilisateurID().equals(userID)) {
				resultat.add(quest);
			}
		}
		return resultat;
	}

	@Override
	public Reponse getReponsePourQuestion(Question question) {
		for (Question quest : questions) {
			if (quest.equals(question)) {
				return question.getReponse();
			}
		}
		for (Reponse rep : reponses) {
			if (rep.getQuestion().equals(question)) {
				return rep;
			}
		}
		return null;
	}
	

	@Override
	public List<Utilisateur> getExpertPourExpertise(Expertise expertise) {
		List<Utilisateur> resultat = new ArrayList<Utilisateur>();
		for (Utilisateur uti : utilisateurs) {
			if (uti.getRoleExpert() != null
					&& uti.getRoleExpert().getExpertise() != null
					&& uti.getRoleExpert().getExpertise().equals(expertise)) {
				resultat.add(uti);
			}
		}
		return resultat;
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
