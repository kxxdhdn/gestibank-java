package application;

import entities.Banque;
import entities.CompteBancaire;

public class App {

	public static void main(String[] args) {
		Banque banque = new Banque(100, "GK_GestiBank", "100 Av. Albert 1er, 92500 Rueil-Malmaison, France",
				1000_000_000);

		CompteBancaire cb1 = new CompteBancaire();
		CompteBancaire cb2 = new CompteBancaire();
		
		banque.soldeTotalComptes = cb1.solde + cb2.solde;

	}

}
