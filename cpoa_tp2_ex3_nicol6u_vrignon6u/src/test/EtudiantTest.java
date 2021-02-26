package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;

import programme.*;

import org.junit.Test;

public class EtudiantTest {

	public Etudiant etu;
	public Formation form;

	/**
	 * methode before pour initialiser les attributs
	 */
	@Before
	public void avant() {
		Identite id = new Identite("123","TOTO", "toto");
		form = new Formation("DUT");
		form.ajouterMatiere("Français", 4);
		form.ajouterMatiere("Anglais", 1);
		/*etu.ajouterMatiereResultats();*/
		HashMap<String, List<Integer>> hm = new HashMap<String, List<Integer>>();
		etu = new Etudiant(id, form, hm);
	}

	/**
	 * test de la methode ajouterNote dans le cas ou la note est valide
	 */
	@Test
	public void testAjouterMatiereNoteValide() {
		String ajout = etu.ajouterNote("Français", 12);
		assertEquals("l ajout devrait etre correct", "L'ajout est valide", ajout);
	}

	/**
	 * test de la methode ajouterNote dans le cas ou la matiere est invalide
	 */
	@Test
	public void testAjouterMatiereInvalide() {
		String ajout = etu.ajouterNote("Mathematiques", 16);
		assertEquals("l ajout devrait etre incorrect", "La matière n'est pas valide", ajout);
	}

	/**
	 * test de la methode ajouterNote dans le cas ou la note est invalide
	 */
	@Test
	public void testAjouterNoteInvalide() {
		String ajout = etu.ajouterNote("Français", 32);
		assertEquals("l ajout devrait etre incorrect", "La note n'est pas valide", ajout);
	}

	/**
	 * test de la methode calculerMoyenneMatiere dans le cas ou la matiere existe
	 */
	@Test
	public void testCalculerMoyenneMatiereExistante() {
		etu.ajouterNote("Français", 20);
		etu.ajouterNote("Français", 10);
		etu.ajouterNote("Français", 10);
		etu.ajouterNote("Français", 10);
		double moyenne = etu.calculerMoyenneMatiere("Français");
		assertEquals("la moyenne devrait etre de 12,5", 12.5, moyenne, 0);
	}

	/**
	 * test de la methode calculerMoyenneMatiere dans le cas ou la matiere n existe pas
	 */
	@Test
	public void testCalculerMoyenneMatiereInExistante() {
		etu.ajouterNote("Français", 20);
		double moyenne = etu.calculerMoyenneMatiere("Anglais");
		assertEquals("la moyenne devrait etre de -1", -1, moyenne, 0);
	}

	/**
	 * test de la methode calculerMoyenneGenerale
	 */
	@Test
	public void testCalculerMoyenneGenerale() {
		etu.ajouterNote("Français", 15);
		etu.ajouterNote("Français", 10);
		etu.ajouterNote("Anglais", 10);
		double moyenne = etu.calculerMoyenneGenerale();
		assertEquals("la moyenne generale devrait etre de 12", 12.0, moyenne, 0);
	}
}
