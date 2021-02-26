package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import programme.*;

public class GroupeTest {

	private Etudiant e1, e2, e3;
	private Groupe g;
	private Identite id1, id2, id3;

	/**
	 * methode before pour initialiser les attributs
	 */
	@Before
	public void avant() {
		id1 = new Identite("1","BRIOT", "Anthony");
		id2 = new Identite("2","VRIGNON", "Quentin");
		id3 = new Identite("3","NICOL", "Benoit");

		Formation form = new Formation("DUT");
		form.ajouterMatiere("Français", 1);
		form.ajouterMatiere("Anglais", 1);

		e1 = new Etudiant(id1,form,new HashMap<String, List<Integer>>());
		e2 = new Etudiant(id2,form,new HashMap<String, List<Integer>>());
		e3 = new Etudiant(id3,form,new HashMap<String, List<Integer>>());

		e1.ajouterNote("Français", 20);
		e1.ajouterNote("Anglais", 20);

		e2.ajouterNote("Français", 0);
		e2.ajouterNote("Anglais", 0);

		e3.ajouterNote("Français", 10);
		e3.ajouterNote("Anglais", 10);

		List<Etudiant> l = new ArrayList<Etudiant>();

		l.add(e1);
		l.add(e2);
		l.add(e3);

		g = new Groupe(l, form);
	}

	/**
	 * test de l etat initial de la liste d etudiants
	 */
	@Test
	public void testEtatInitialListeEtudiant() {

		assertEquals("L etudiant devrait etre identique", e1, g.getListeEtu().get(0));
		assertEquals("L etudiant devrait etre identique", e2, g.getListeEtu().get(1));
		assertEquals("L etudiant devrait etre identique", e3, g.getListeEtu().get(2));
	}

	/**
	 * methode de test de la methode calculerMoyenneMatiere()
	 */
	@Test
	public void testCalculerMoyenneMatiere() {
		double res = g.calculerMoyenneMatiere("Français");
		assertEquals("On devrait avoir la bonne moyenne", 10, res, 0);
	}

	/**
	 * methode de test de la methode calculerMoyenneGenerale()
	 */
	@Test
	public void testCalculerMoyenneGenerale() {
		double res = g.calculerMoyenneGenerale();
		assertEquals("On devrait avoir la bonne moyenne", 10, res, 0);
	}

	/**
	 * test du bon fonctionnment de la methode triParMerite()
	 */
	@Test
	public void testTriParMerite() {

		g.triParMerite();

		assertEquals("Les etudiants devraient etre dans le bon ordre", "1", g.getListeEtu().get(0).getId().getNIP());
		assertEquals("Les etudiants devraient etre dans le bon ordre", "3", g.getListeEtu().get(1).getId().getNIP());
		assertEquals("Les etudiants devraient etre dans le bon ordre", "2", g.getListeEtu().get(2).getId().getNIP());
	}

	/**
	 * test du bon fonctionnment de la methode triAlpha()
	 */
	@Test
	public void testTriAlpha() {

		g.triAlpha();

		assertEquals("Les etudiants devraient etre dans le bon ordre", "1", g.getListeEtu().get(0).getId().getNIP());
		assertEquals("Les etudiants devraient etre dans le bon ordre", "3", g.getListeEtu().get(1).getId().getNIP());
		assertEquals("Les etudiants devraient etre dans le bon ordre", "2", g.getListeEtu().get(2).getId().getNIP());
	}
}
