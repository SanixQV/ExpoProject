package programme;

import java.util.HashMap;

public class Formation {

	/**
	 * identifiant de la formation
	 */
	private String identifiant;

	/**
	 * Table des matieres avec leurs coefficients
	 */
	private HashMap<String, Integer> matieres;

	/**
	 * constructeur de la classe Formation
	 * @param id identifiant de la nouvelle formation
	 */
	public Formation(String id) {
		this.identifiant = id;
		this.matieres = new HashMap<String, Integer>();
	}

	/**
	 * methode permettant d ajouter une matiere a la formation
	 * @param nomMat nom de la nouvelle matiere
	 * @param coef valeur du coefficient de la nouvelle matiere
	 */
	public void ajouterMatiere(String nomMat, Integer coef) {
		if (!this.matieres.containsKey(nomMat) && coef > 0)
			this.matieres.put(nomMat, coef);
	}

	/**
	 * methode permettant de supprimer une matiere de la formation
	 * @param nomMat nom de la matiere a supprimer
	 */
	public void supprimerMatiere(String nomMat) {
		if (this.matieres.containsKey(nomMat))
			this.matieres.remove(nomMat);
	}

	/**
	 * methode permettant de recuperer le coefficient associe a une matiere
	 * @param nomMat nom de la matiere associee au coefficient
	 * @return le coefficient recherche ou -1 si la matiere esr inexistante
	 */
	public Integer getCoef(String nomMat) {
		Integer coef = -1;
		if (this.matieres.containsKey(nomMat))
			coef = this.matieres.get(nomMat);
		return coef;
	}

	/**
	 * getter matieres
	 * @return matieres
	 */
	public HashMap<String, Integer> getMatieres() {
		return matieres;
	}


}