package fr.pizzeria.service;

import java.util.Arrays;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public Pizza[] listePizza = { new Pizza(0, "PEP", "Pépéroni", 12.50), new Pizza(1, "MAR", "Margherita", 14.00),
			new Pizza(2, "REI", "La Reine", 11.50), new Pizza(3, "FRO", "La 4 fromages", 12.00),
			new Pizza(4, "CAN", "La cannibale", 12.50), new Pizza(5, "SAV", "La savoyarde", 13.00),
			new Pizza(6, "ORI", "L'orientale", 13.50), new Pizza(7, "IND", "L'indienne", 14.00) };

	@Override
	public Pizza[] findAllPizzas() {
		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaException {
		// si le code est inférieur à 3 caractères, on lance une exception
		if (newPizza.getCode().length() != 3) {
			SavePizzaException saveEx = new SavePizzaException("Code invalide");
			throw saveEx;
		}
		// initialisation de l'id
		newPizza.setId(listePizza[listePizza.length - 1].getId() + 1);
		// création d'une liste temporaire et copie de l'ancienne
		Pizza[] newListe = Arrays.copyOf(listePizza, listePizza.length + 1);
		// ajout de la nouvelle pizza
		newListe[newListe.length - 1] = newPizza;
		// on remplace l'ancienne liste par la nouvelle
		listePizza = newListe;
	}

	@Override
	public void updatePizza(int id, String code, String nom, double prix) throws UpdatePizzaException {
		// si le code est inférieur à 3 caractères, on lance une exception
		if (code.length() != 3) {
			UpdatePizzaException saveEx = new UpdatePizzaException("Code invalide");
			throw saveEx;
		}
		listePizza[id].setCode(code);
		listePizza[id].setNom(nom);
		listePizza[id].setPrix(prix);

	}

	@Override
	public void supprPizza(Pizza oldPizza) {
		int newIndex;
		// création d'une liste temporaire
		Pizza[] newListe = new Pizza[listePizza.length - 1];
		// copie de l'ancienne liste sans la pizza supprimée
		for (int i = 0; i < listePizza.length - 1; i++) {
			if (i >= oldPizza.getId()) {
				newIndex = i + 1;
			} // on modifie l'index pour passer la pizza à modifier
			else {
				newIndex = i;
			}
			newListe[i] = listePizza[newIndex];
			// mise à jour des id
			newListe[i].setId(i);
		}
		// on remplace l'ancienne liste par la nouvelle
		listePizza = newListe;
	}

}
