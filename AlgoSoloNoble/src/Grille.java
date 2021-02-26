
 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grille {

	private String[][] gr;
	private int nbBilles;
	public static int nbDeplacement;

	/**
	 * constructeur de Grille par defaut
	 */
	public Grille() {
		gr = new String[7][7];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				gr[i][j] = " ";
			}
			for (int j = 5; j < gr.length; j++) {
				gr[i][j] = " ";
			}
		}

		for (int i = 5; i < gr.length; i++) {
			for (int j = 0; j < 2; j++) {
				gr[i][j] = " ";
			}
			for (int j = 5; j < gr.length; j++) {
				gr[i][j] = " ";
			}
		}

		for (int i = 0; i < gr.length; i++) {
			for (int j = 0; j < gr.length; j++) {
				if (gr[i][j] == null) {
					gr[i][j] = "o";
				}
			}
		}

		this.nbBilles = 32;
		gr[3][3] = ".";
	}

	/**
	 * constructeur de Grille qui lis un fichier et en créé la grille correspondante
	 * 
	 * @param f fichier txt dans lequel est contenu le tablier
	 * @throws IOException
	 */
	public Grille(String f) throws IOException {
		int[] tab = this.taille(f);
		this.gr = new String[tab[0]][tab[1]];
		String ligne;
		String[] temp;
		int i;
		int j = 0;
		BufferedReader fichier = new BufferedReader(new FileReader(f));
		while ((ligne = fichier.readLine()) != null) {
			temp = ligne.split("");
			for (i = 0; i < temp.length; i++) {
				this.gr[j][i] = temp[i];
			}
			j++;
		}
		fichier.close();
		for (i = 0; i < this.getGrille().length; i++) {
			for (j = 0; j < this.getGrille()[0].length; j++) {
				if (this.getGrille()[i][j].equals("o")) {
					nbBilles++;
				}
			}
		}
	}

	/**
	 * methode qui modifie l'etat de la case x, y
	 * 
	 * @param x
	 * @param y
	 */
	public void changerCase(int x, int y) {
		if (gr[x][y].equals("o")) {
			gr[x][y] = ".";
		} else if (gr[x][y].equals(".")) {
			gr[x][y] = "o";
		}
	}

	/**
	 * Affiche la grille
	 * 
	 * @return res String représentant la grille
	 */
	public String afficher() {
		String res = " \n";
		for (int i = 0; i < gr.length; i++) {
			for (int j = 0; j < gr[0].length; j++) {
				res += gr[i][j];
			}
			res += "\n";
		}
		res += "\n";
		res += "****************************";
		return res;

	}

	/**
	 * getter de l'attribut grille
	 * 
	 * @return gr
	 */
	public String[][] getGrille() {
		return this.gr;
	}

	/**
	 * retourne la taille du tablier
	 * 
	 * @param f fichier texte contenant un tablier
	 * @return taille tableau contenant la hauteur et la largeur du tablier
	 * @throws IOException
	 */
	public int[] taille(String f) throws IOException {
		int[] taille = new int[2];
		String ligne;
		String[] temp = null;
		int i = 0;
		BufferedReader fichier = new BufferedReader(new FileReader(f));
		while ((ligne = fichier.readLine()) != null) {
			temp = ligne.split("");
			i++;
		}
		taille[0] = temp.length;
		taille[1] = i;
		return taille;
	}

	/**
	 * change la case passer en parametre ainsi que les 2 de gauches
	 * 
	 * @param i ordonnées
	 * @param j abscisses
	 */
	public void deplacerGauche(int i, int j) {
		this.changerCase(i, j - 1);
		this.changerCase(i, j);
		this.changerCase(i, j - 2);
		nbDeplacement++;
	}

	/**
	 * change la case passer en parametre ainsi que les 2 de droites
	 * 
	 * @param i ordonnées
	 * @param j abscisses
	 */
	public void deplacerDroit(int i, int j) {
		this.changerCase(i, j + 1);
		this.changerCase(i, j);
		this.changerCase(i, j + 2);
		nbDeplacement++;
	}

	/**
	 * change la case passer en parametre ainsi que les 2 du bas
	 * 
	 * @param i ordonnées
	 * @param j abscisses
	 */
	public void deplacerBas(int i, int j) {
		this.changerCase(i + 1, j);
		this.changerCase(i, j);
		this.changerCase(i + 2, j);
		nbDeplacement++;
	}

	/**
	 * change la case passer en parametre ainsi que les 2 du haut
	 * 
	 * @param i ordonnées
	 * @param j abscisses
	 */
	public void deplacerHaut(int i, int j) {
		this.changerCase(i - 1, j);
		this.changerCase(i, j);
		this.changerCase(i - 2, j);
		nbDeplacement++;
	}

	public static void main(String[] args) {
		Grille gr = new Grille();
		System.out.println(gr.afficher());
		gr.deplacerGauche(0, 2);
		System.out.println(gr.afficher());
	}

	public int getNbBilles() {
		return this.nbBilles;
	}

}
