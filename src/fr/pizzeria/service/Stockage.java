package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public interface Stockage {

	Pizza[] findAllPizzas(); // récupération de la liste de pizzas

	void savePizza(Pizza newPizza); // ajout d'une pizza dans la liste

	void supprPizza(Pizza oldPizza); // retrait d'une pizza de la liste

}
