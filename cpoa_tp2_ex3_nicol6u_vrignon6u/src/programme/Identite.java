package programme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Identite implements Comparable<Identite>{
	private String NIP, nom, prenom;

	/**
	 * Constructeur Identite
	 * @param nIP
	 * @param nom
	 * @param prenom
	 */
	public Identite(String nIP, String nom, String prenom) {

		this.NIP = nIP;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * getter NIP
	 * @return
	 */
	public String getNIP() {
		return NIP;
	}

	/**
	 *getter nom
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * getter prenom
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * methode compareTo pour triAlpha() de Groupe
	 */
	@Override
	public int compareTo(Identite o) {
		int res = 0;
		if (this.nom.equals(o.getNom())) {
			if (this.prenom.equals(prenom)) {
				res = this.NIP.compareTo(o.getNIP());
			}
			else {
				res = this.prenom.compareTo(o.getPrenom());
			}
		}
		else {
			res = this.nom.compareTo(o.getNom());
		}
		return res;
	}

}