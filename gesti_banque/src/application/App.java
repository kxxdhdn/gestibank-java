package application;

import entities.Banque;
import entities.CompteBancaire;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Banque banque = new Banque(100, "GK_GestiBank", "100 Av. Albert 1er, 92500 Rueil-Malmaison, France",
				1000_000_000);
		CompteBancaire cb1 = new CompteBancaire(10101010, "Mohamed Amine MEZGHICH", 2000, LocalDate.of(2024, 1, 15),
				100);
		CompteBancaire cb2 = new CompteBancaire(20202020, "Jean Paul", 3000, LocalDate.of(2024, 1, 10), 100);

		// VERSION 1 : sans encapsulation
//		System.out.println(Banque.nbreTotalCompte);
//		System.out.println(Banque.soldeTotalComptes);

		// VERSION 2 : avec encapsulation
		System.out.println(Banque.getNbreTotalCompte());
		System.out.println(Banque.getSoldeTotalComptes());
//		System.out.println("banque: " + banque);
//		System.out.println("cb1: " + cb1);
//		System.out.println("cb2: " + cb2);

		// Question 13
		Scanner sc = new Scanner(System.in);

		Banque banque2 = SaisieClavier.creerBanqueClavier(sc);
		System.out.println("banque2: " + banque2);

		CompteBancaire cb21 = SaisieClavier.creerCompteClavier(sc, banque2.getIdBanque());
		System.out.println("cb21: " + cb21);
		CompteBancaire cb22 = SaisieClavier.creerCompteClavier(sc, banque2.getIdBanque());
		System.out.println("cb22: " + cb22);

		sc.close();

		// Question 15
		Banque[] banques = { banque, banque2 };
		System.out.println("Banque ayant le plus grand solde : " + afficherBanqueGrandSolde(banques));

	}

	// Question 14
	public static Banque afficherBanqueGrandSolde(Banque[] banques) {
		Banque banqueGrand = banques[0];
		for (int i = 0; i < banques.length - 1; i++) {
			if (banques[i].getSoldeTotalComptes() < banques[i + 1].getSoldeTotalComptes()) {
				banqueGrand = banques[i + 1];
			} else {
				banqueGrand = banques[i];
			}
		}
		return banqueGrand;
	}

}
