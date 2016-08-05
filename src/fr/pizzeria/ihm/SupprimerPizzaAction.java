package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class SupprimerPizzaAction extends Action {

	private Stockage stockage;
	private Scanner sc;

	public SupprimerPizzaAction(Stockage stockage, Scanner sc) {
		super("Supprimer une pizza");
		this.stockage = stockage;
		this.sc = sc;
	}

	public void execute() {
		int id;

		System.out.println("Supprimer une pizza");
		// on affiche la liste des pizzas
		Pizza[] pizza = this.stockage.findAllPizzas();
		Action lister = new ListerPizzaAction(stockage);
		lister.execute();
		// choix de la pizza
		do {
			System.out.println("Choisissez une pizza (ID) :");
			id = sc.nextInt();
		} while (id < 0 || id >= pizza.length);
		// suppression de la pizza
		stockage.supprPizza(pizza[id]);
	}

}
