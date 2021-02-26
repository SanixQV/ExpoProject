package programme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Etudiant implements Comparable<Etudiant>{
	private Identite  id;
	private Formation form;
	private HashMap<String, List<Integer>> resultats;


	/**
	 * construceur Etudiant
	 * @param id
	 * @param form
	 * @param res
	 */
	public Etudiant(Identite id, Formation form, HashMap<String, List<Integer>> res) {
		this.id = id;
		this.form = form;
		this.resultats = res;
		
		Set<String> matieres = this.form.getMatieres().keySet();
		
		for (String matCourante : matieres) {
			List<Integer> l = new ArrayList<Integer>();
			this.resultats.put(matCourante, l);
		}

	}

	/**
	 * fonction qui ajoute une note
	 * @param note
	 * @param mat
	 * @return un booleen true si la note est ajoutée
	 */
	public String ajouterNote(String mat, Integer note) {
		String res = "La matière n'est pas valide";
		if(this.resultats.containsKey(mat)) {
			boolean trouve = false;
			Set<String> matieres = this.resultats.keySet();
			Iterator<String> it = matieres.iterator();
			String matCourante = "";
			while (it.hasNext() && !trouve) {
				matCourante = it.next();
				if (mat.equals(matCourante)) {
					if (note < 0 || note > 20) {
						res = "La note n'est pas valide";
					}
					else {
						List<Integer> l = this.resultats.get(mat);
						l.add(note);
						this.resultats.put(mat, l);
						res = "L'ajout est valide";
						trouve =  true;
					}
				}
			}
		}
		return res;
	}
	/**
	 * Calcule la moyenne pour une matiere et retourne -1 si l'eleve n'a pas cette matiere.
	 * @param mat
	 * @return
	 */
	public double calculerMoyenneMatiere(String mat) {
		List<Integer> notes = null;
		double somme = 0;
		double res = -1;
		if(resultats.containsKey(mat)) {
			notes = resultats.get(mat);
			int lenght = notes.size();
			if (lenght>0) {
				for (int i= 0; i < lenght; i++ ) {
					somme += notes.get(i) ;
				}
				res = somme/lenght;
			}
		}
		return res;
	}

	/**
	 * fonction qui calcule la moyenne générale d'un éleve
	 * @return res la moyenne générale
	 */
	public double calculerMoyenneGenerale() {
		Set<String> matieres = this.resultats.keySet();
		Iterator<String> it = matieres.iterator();
		String matCourante = "";
		int coef = 0;
		int sommeCoeff = 0;
		double moyenneMatiere = 0.0;
		double sommeG = 0;
		double moyenneG = -1;
		while(it.hasNext()) {
			matCourante = it.next();
			coef = this.form.getMatieres().get(matCourante);
			sommeCoeff += coef;
			moyenneMatiere = calculerMoyenneMatiere(matCourante) * coef;
			sommeG += moyenneMatiere;
		}

		moyenneG = sommeG/sommeCoeff;
		return moyenneG;
	}

	/**
	 * getter qui retourne l'identifiant de l'etudiant
	 * @return id
	 */
	public Identite getId() {
		return id;
	}

	/**
	 * getter formulaire
	 * @return le formulaire
	 */
	public Formation getForm() {
		return form;
	}

	/**
	 * getter resultats
	 * @return resultats
	 */
	public HashMap<String, List<Integer>> getResultats() {
		return resultats;
	}

	/**
	 *methode compareTo
	 */
	@Override
	public int compareTo(Etudiant o) {
		return (int) (o.calculerMoyenneGenerale() - this.calculerMoyenneGenerale());
	}

}