package fr.pizzeria.ihm;

public abstract class Action {

	private String libelle;

	public abstract void execute();

	public Action(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
