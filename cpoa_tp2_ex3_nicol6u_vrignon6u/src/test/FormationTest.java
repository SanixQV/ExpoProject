package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import programme.Formation;

public class FormationTest {

	private Formation f;

	/**
	 * methode before pour initialiser les attributs
	 */
	@Before
	public void avant() {
		f = new Formation("2020");
		f.ajouterMatiere("Maths", 2);
	}

	/**
	 * test de l ajout de matiere
	 */
	@Test
	public void testAjouterMatiere() {
		assertTrue("Cela devrait afficher true", f.getMatieres().containsKey("Maths"));
	}

	/**
	 * test de la suppression de matiere existante
	 */
	@Test
	public void testSupprimerMatiereExistante() {
		f.supprimerMatiere("Maths");
		assertFalse("Cela devrait afficher false", f.getMatieres().containsKey("Maths"));
	}

	/**
	 * test de la suppression de matiere inexistante
	 */
	@Test
	public void testSupprimerMatiereInexistante() {
		f.supprimerMatiere("Français");
		assertTrue("Cela devrait afficher true", f.getMatieres().containsKey("Maths"));
	}

	/**
	 * test de la table vide
	 */
	@Test
	public void testTableVide() {
		f.supprimerMatiere("Maths");
		assertTrue("Cela devrait afficher true", f.getMatieres().keySet().isEmpty());
	}

	/**
	 * test pour voir si le coef est bien enregistre
	 */
	@Test
	public void testGetCoefExiste() {
		assertEquals("Ca devrait retourner 2", 2, (int)f.getCoef("Maths")); 
	}

	/**
	 * test pour voir si le coef n a pas change
	 */
	@Test
	public void testGetCoefExistePas() {
		assertEquals("Ca devrait retourner -1", -1, (int) f.getCoef("Francais"));

	}

}