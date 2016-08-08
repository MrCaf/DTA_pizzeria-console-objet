package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public List<Pizza> listePizza = new ArrayList<Pizza>();

	public StockageTableau() {
		listePizza.add(new Pizza("PEP", "Pépéroni", 12.50));
		listePizza.add(new Pizza("MAR", "Margherita", 14.00));
		listePizza.add(new Pizza("REI", "La Reine", 11.50));
		listePizza.add(new Pizza("FRO", "La 4 fromages", 12.00));
		listePizza.add(new Pizza("CAN", "La cannibale", 12.50));
		listePizza.add(new Pizza("SAV", "La savoyarde", 13.00));
		listePizza.add(new Pizza("ORI", "L'orientale", 13.50));
		listePizza.add(new Pizza("IND", "L'indienne", 14.00));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaException {
		// si le code est inférieur à 3 caractères, on lance une exception
		if (newPizza.getCode().length() != 3) {
			SavePizzaException saveEx = new SavePizzaException("Code invalide");
			throw saveEx;
		}
		listePizza.add(newPizza);
	}

	@Override
	public void updatePizza(int id, String code, String nom, double prix) throws UpdatePizzaException {
		// si le code est inférieur à 3 caractères, on lance une exception
		if (code.length() != 3) {
			UpdatePizzaException saveEx = new UpdatePizzaException("Code invalide");
			throw saveEx;
		}
		Pizza p = listePizza.get(id);
		p.setCode(code);
		p.setNom(nom);
		p.setPrix(prix);
	}

	@Override
	public void supprPizza(Pizza oldPizza) {
		listePizza.remove(oldPizza);
	}

}
