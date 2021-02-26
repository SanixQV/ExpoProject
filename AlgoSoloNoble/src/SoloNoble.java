
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoloNoble {

	private Grille gr;
	private List<String> tempo;

	public SoloNoble() {
		this.tempo = new ArrayList();
	}

	/**
	 * resout le soloNoble
	 * 
	 * @param n nombre de billes
	 * @return echec booleen vrai si on peut se deplacer
	 */
	public boolean resoudreSoloNoble(int n) {
		boolean echec;
		if (n == 1) {
			this.gr.afficher();
			System.out.println("Solution trouvee");
			echec = false;
		} else {
			echec = true;
			int j = 0;
			int i = 0;
			while (i < this.gr.getGrille().length && echec) {
				while (j < this.gr.getGrille()[0].length && echec) {
					if (j - 2 >= 0 && this.gr.getGrille()[i][j].equals("o") && this.gr.getGrille()[i][j - 1].equals("o")
							&& this.gr.getGrille()[i][j - 2].equals(".")) {
						this.gr.deplacerGauche(i, j);
						tempo.add(0, this.gr.afficher());
						echec = resoudreSoloNoble(n - 1);

						if (echec) {
							this.gr.deplacerGauche(i, j);
							tempo.remove(0);

						}
					} else {

						if (i + 2 < this.gr.getGrille()[0].length && this.gr.getGrille()[i][j].equals("o")
								&& this.gr.getGrille()[i + 1][j].equals("o")
								&& this.gr.getGrille()[i + 2][j].equals(".")) {
							this.gr.deplacerBas(i, j);

							tempo.add(0, this.gr.afficher());
							echec = resoudreSoloNoble(n - 1);

							if (echec) {
								this.gr.deplacerBas(i, j);
								tempo.remove(0);
							}

						} else {

							if (i - 2 >= 0 && this.gr.getGrille()[i][j].equals("o")
									&& this.gr.getGrille()[i - 1][j].equals("o")
									&& this.gr.getGrille()[i - 2][j].equals(".")) {

								this.gr.deplacerHaut(i, j);
								tempo.add(0, this.gr.afficher());
								echec = resoudreSoloNoble(n - 1);

								if (echec) {
									this.gr.deplacerHaut(i, j);
									tempo.remove(0);
								}

							} else {

								if (j + 2 < this.gr.getGrille()[0].length && this.gr.getGrille()[i][j].equals("o")
										&& this.gr.getGrille()[i][j + 1].equals("o")
										&& this.gr.getGrille()[i][j + 2].equals(".")) {
									this.gr.deplacerDroit(i, j);
									tempo.add(0, this.gr.afficher());
									echec = resoudreSoloNoble(n - 1);

									if (echec) {
										this.gr.deplacerDroit(i, j);
										tempo.remove(0);

									}
								}
							}
						}
					}

					j++;
				}
				i++;
				j = 0;

			}

		}

		return echec;
	}

	public static void main(String[] args) throws IOException {
		String res = "debut : \n";
		SoloNoble a = new SoloNoble();
		if (args.length == 1) {
			System.out.println("vous avez demandé le tablier se trouvant dans le fichier : " + args[0]);
			a.gr = new Grille(args[0]);
		} else {
			System.out.println("vous n'avez pas demandé de grille en particulier ou avez mis trop d'arguments");
			a.gr = new Grille();
		}
		System.out.println(a.gr.afficher());

		int n = a.gr.getNbBilles();
		System.out.println("il y a " + n + " billes sur le tablier");
		a.resoudreSoloNoble(n);
		for (int i = a.tempo.size() - 1; i >= 0; i--) {
			res += a.tempo.get(i);
		}
		System.out.println(res);
		System.out.println("Il y a eu " + a.gr.nbDeplacement + " deplacements");

	}

}
