package programme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Groupe {
	/**
	 * la liste des etudiants du goupe
	 */
	List<Etudiant> listeEtu;
	
	/**
	 * la formation a laquelle participe le groupe
	 */
    Formation f;
    
    public Groupe(List<Etudiant> lE, Formation f) {
        this.listeEtu = lE;
        this.f = f;
    }
    
    /**
     * methode d ajout d un Etudiant
     * @param e Etudiant
     */
    public void AjouterEtudiant(Etudiant e) {
        if ((e.getForm() == this.f) && this.listeEtu.contains(e)) {
            this.listeEtu.add(e);
        }
    }
    
    /**
     * methode de suppression d un Etudiant
     * @param e Etudiant
     */
    public void supprimerEtudiant(Etudiant e) {
        if(listeEtu.contains(e)) {
        	listeEtu.remove(e);
        }
    }
    
    /**
     * methode de calcul de la moyenne du groupe pour une matiere donnee
     * @param mat Matiere donnee
     * @return la moyenne du groupe
     */
    public double calculerMoyenneMatiere(String mat) {
        Iterator<Etudiant> it = listeEtu.iterator();
        double somme = 0;
        Etudiant etu;
        while (it.hasNext()) {
        	etu = it.next();
        	somme += etu.calculerMoyenneMatiere(mat);
        }
        double res = somme / listeEtu.size();
        return res;
    }
    
    /**
     * methode de calcul de la moyenne generale du groupe pour toutes les matieres
     * @return
     */
    public double calculerMoyenneGenerale() {
        Iterator<Etudiant> it = listeEtu.iterator();
        double somme = 0;
        Etudiant etu;
        while (it.hasNext()) {
        	etu = it.next();
        	somme += etu.calculerMoyenneGenerale();
        }
        double res = somme / listeEtu.size();
        return res;
    }
    
    /**
     * methode de tri des etudiants par leur moyenne generale decroissante
     */
	public void triParMerite() {
		Collections.sort(listeEtu);
	}
	
	/**
	 * methode de tri des etudiants suivant leur ordre alphabetique de nom croissant
	 */
	public void triAlpha() {
		List<Identite> listeId = new ArrayList<Identite>();
		List<Etudiant> listeTriee = new ArrayList<Etudiant>();
		
		for (Etudiant etudiant : listeEtu) {
			listeId.add(etudiant.getId());
		}
		
		Collections.sort(listeId);
		
		boolean trouve = false;
		int i = 0;
		
		for (Etudiant etudiant : listeEtu) {
			while(!trouve) {
				if (etudiant.getId().equals(listeId.get(i))) {
					listeTriee.add(listeEtu.get(i));
					trouve = true;
				}
				i++;
			}
			trouve = false;
			i = 0;
		}
		
		listeEtu = listeTriee;
	}
	
	/**
	 * getter listeEtu
	 * @return la liste des etudiants du groupe
	 */
	public List<Etudiant> getListeEtu() {
		return listeEtu;
	}
}