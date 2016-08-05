package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ModifierPizzaAction extends Action {

	private Stockage stockage;
	private Scanner sc;

	public ModifierPizzaAction(Stockage stockage, Scanner sc) {
		super("Modifier une pizza");
		this.stockage = stockage;
		this.sc = sc;
	}

	public void execute() {
		int id;

		System.out.println("Modifier une pizza");
		// on affiche la liste des pizzas
		Pizza[] pizza = this.stockage.findAllPizzas();
		Action lister = new ListerPizzaAction(stockage);
		lister.execute();
		// choix de la pizza
		do {
			System.out.println("Choisissez une pizza (ID) :");
			id = sc.nextInt();
		} while (id < 0 || id >= pizza.length);
		// saisie des nouvelles informations
		System.out.println("Entrez le nouveau code :");
		String code = sc.next();
		System.out.println("Entrez le nouveau nom :");
		String nom = sc.next();
		System.out.println("Entrez le nouveau prix :");
		double prix = sc.nextDouble();
		// mise à jour des informations de la pizza
		pizza[id].setCode(code);
		pizza[id].setNom(nom);
		pizza[id].setPrix(prix);
	}

}
