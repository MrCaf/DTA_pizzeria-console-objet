package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIE = 99;
	private Action[] actions;
	private Scanner sc;

	public Menu(Stockage stockage, Scanner sc) {
		actions = new Action[] { new ListerPizzaAction(stockage), new AjouterPizzaAction(stockage, sc),
				new ModifierPizzaAction(stockage, sc), new SupprimerPizzaAction(stockage, sc) };
		this.sc = sc;
	}

	public void start() {

		boolean result = false; // signal de sortie du menu (ferme l'appli)
		// on boucle jusqu'au signal de sortie = true
		do {
			System.out.println("***** Application Pizzeria *****");
			// on affiche les options
			for (int i = 0; i < actions.length; i++) {
				System.out.println(i + ". " + actions[i].getLibelle());
			}
			System.out.println("99. Quitter");
			// on lance la saisie du choix
			result = choisir(sc);
		} while (!result);

	}

	public boolean choisir(Scanner sc) {
		System.out.println("Choisissez une option :");
		int choix = sc.nextInt();
		// on vérifie la validité de la saisie
		if (choix < 0 || choix > actions.length) {
			if (choix != CHOIX_SORTIE) {
				System.out.println("Choisissez une option :");
			}
		} else {
			actions[choix].execute();
		}
		// signal de sortie ?
		return choix == CHOIX_SORTIE;
	}

}
