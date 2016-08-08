package fr.pizzeria.ihm;

import java.util.List;

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
		List<Pizza> pizza = this.stockage.findAllPizzas();
		for (int i = 0; i < pizza.size(); i++) {
			System.out.println(i + ". " + pizza.get(i).getCode() + " -> " + pizza.get(i).getNom() + " ("
					+ pizza.get(i).getPrix() + " €)");
		}
		System.out.println("-------- " + Pizza.NB_PIZZAS + " pizzas créées depuis l'initialisation");
	}

}
