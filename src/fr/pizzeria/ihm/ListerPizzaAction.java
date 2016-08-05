package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ListerPizzaAction extends Action {

	private Stockage stockage;

	public ListerPizzaAction(Stockage stockage) {
		super("Lister les pizza");
		this.stockage = stockage;
	}

	public void execute() {
		System.out.println("***** Liste pizzas *****");
		Pizza[] pizza = this.stockage.findAllPizzas();
		for (int i = 0; i < pizza.length; i++) {
			System.out.println(pizza[i].getId() + ". " + pizza[i].getCode() + " -> " + pizza[i].getNom() + " ("
					+ pizza[i].getPrix() + " €)");
		}
		System.out.println("-------- " + Pizza.NB_PIZZAS + " pizzas créées depuis l'initialisation");
	}

}
