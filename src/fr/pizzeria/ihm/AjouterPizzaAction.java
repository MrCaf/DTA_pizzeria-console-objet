package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class AjouterPizzaAction extends Action {

	private Stockage stockage;
	private Scanner sc;

	public AjouterPizzaAction(Stockage stockage, Scanner sc) {
		super("Ajouter une pizza");
		this.stockage = stockage;
		this.sc = sc;
	}

	public void execute() {
		// saisie des informations
		System.out.println("Ajouter une pizza");
		System.out.println("Entrez le code :");
		String code = sc.next();
		System.out.println("Entrez le nom :");
		String nom = sc.next();
		System.out.println("Entrez le prix :");
		double prix = sc.nextDouble();
		// création et sauvegarde de la nouvelle pizza
		try {
			stockage.savePizza(new Pizza(0, code, nom, prix));
		} catch (SavePizzaException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
