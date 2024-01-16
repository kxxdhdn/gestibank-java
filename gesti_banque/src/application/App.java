package application;

import entities.Banque;
import entities.CompteBancaire;
import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		Banque banque = new Banque(100, "GK_GestiBank", "100 Av. Albert 1er, 92500 Rueil-Malmaison, France",
				1000_000_000);
		CompteBancaire cb1 = new CompteBancaire(
				10101010, "Mohamed Amine MEZGHICH", 2000, LocalDate.of(2024, 1, 15), 100);
		CompteBancaire cb2 = new CompteBancaire(
				20202020, "Jean Paul", 3000, LocalDate.of(2024, 1, 10), 100);

		System.out.println("cb1: " + cb1);
		System.out.println("cb2: " + cb2);
		System.out.println("banque: " + banque);



	}

}
