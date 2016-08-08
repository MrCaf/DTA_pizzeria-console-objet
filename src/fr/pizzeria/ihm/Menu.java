package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIE = 99;
	private java.util.Map<Integer, Action> actions = new HashMap<Integer, Action>();
	private Scanner sc;

	public Menu(Stockage stockage, Scanner sc) {
		actions.put(1, new ListerPizzaAction(stockage));
		actions.put(2, new AjouterPizzaAction(stockage, sc));
		actions.put(3, new ModifierPizzaAction(stockage, sc));
		actions.put(4, new SupprimerPizzaAction(stockage, sc));
		this.sc = sc;
	}

	public void start() {

		boolean result = false; // signal de sortie du menu (ferme l'appli)
		// on boucle jusqu'au signal de sortie = true
		do {
			System.out.println("***** Application Pizzeria *****");
			// on affiche les options
			for (Integer i : actions.keySet()) {
				System.out.println(i + ". " + actions.get(i).getLibelle());
			}
			System.out.println(CHOIX_SORTIE + ". Quitter");
			// on lance la saisie du choix
			result = choisir(sc);
		} while (!result);

	}

	public boolean choisir(Scanner sc) {
		System.out.println("Choisissez une option :");
		int choix = sc.nextInt();
		// on vérifie la validité de la saisie
		if (choix < 0 || choix > actions.size()) {
			if (choix != CHOIX_SORTIE) {
				System.out.println("Choisissez une option :");
			}
		} else {
			actions.get(choix).execute();
		}
		// signal de sortie ?
		return choix == CHOIX_SORTIE;
	}

}
