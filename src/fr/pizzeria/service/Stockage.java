package fr.pizzeria.service;

import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface Stockage {

	List<Pizza> findAllPizzas(); // récupération de la liste de pizzas

	void savePizza(Pizza newPizza) throws SavePizzaException; // ajout d'une
																// pizza dans la
																// liste

	void updatePizza(int id, String code, String nom, double prix) throws UpdatePizzaException; // modification
																								// d'une
																								// pizza
																								// existante

	void supprPizza(Pizza oldPizza); // retrait d'une pizza de la liste

}
