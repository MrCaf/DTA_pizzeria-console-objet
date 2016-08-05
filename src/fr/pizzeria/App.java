package fr.pizzeria;

import java.util.Scanner;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageTableau;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stockage stockage = new StockageTableau(); // choix du stockage tableau

		// Objectif 1 - Afficher le menu

		Menu menuPrincipal = new Menu(stockage, sc); // constructeur du menu
		menuPrincipal.start(); // lancement du menu

		sc.close(); // on referme le scanner

	}

}
