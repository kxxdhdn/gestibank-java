package application;

import entities.Banque;
import entities.CompteBancaire;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Banque banque1 = new Banque(100, "GK_GestiBank", "100 Av. Albert 1er, 92500 Rueil-Malmaison, France",
				1000_000_000);
		System.out.println("banque1: " + banque1);

		CompteBancaire cb11 = new CompteBancaire(10101010, "Mohamed Amine MEZGHICH", 2000, LocalDate.of(2024, 1, 15),
				banque1.getIdBanque());
//				100);
		System.out.println("cb11: " + cb11);
		// Mise à jour des infos de la banque1
		banque1.setNbreTotalCompte(banque1.getNbreTotalCompte() + 1);
		banque1.setSoldeTotalComptes(banque1.getSoldeTotalComptes() + cb11.getSolde());

		CompteBancaire cb12 = new CompteBancaire(20202020, "Jean Paul", 3000, LocalDate.of(2024, 1, 10),
				banque1.getIdBanque());
//				100);
		System.out.println("cb12: " + cb12);
		// Mise à jour des infos de la banque1
		banque1.setNbreTotalCompte(banque1.getNbreTotalCompte() + 1);
		banque1.setSoldeTotalComptes(banque1.getSoldeTotalComptes() + cb12.getSolde());

		// VERSION 1 : sans encapsulation
//		System.out.println(Banque.nbreTotalCompte);
//		System.out.println(Banque.soldeTotalComptes);

		// VERSION 2 : avec encapsulation
//		System.out.println(Banque.getNbreTotalCompte());
//		System.out.println(Banque.getSoldeTotalComptes());
		
		System.out.println("banque1 (après l'ajout des comptes): " + banque1);

		// Question 13
		Scanner sc = new Scanner(System.in);

		Banque banque2 = SaisieClavier.creerBanqueClavier(sc);
		System.out.println("banque2: " + banque2);

		CompteBancaire cb21 = SaisieClavier.creerCompteClavier(sc, banque2);
		System.out.println("cb21: " + cb21);

		CompteBancaire cb22 = SaisieClavier.creerCompteClavier(sc, banque2);
		System.out.println("cb22: " + cb22);

		sc.close();

		// Question 15
//		Banque[] banques = { banque1, banque2 };
//		SaisieClavier.afficherBanqueGrandSolde(banques);
		
		// Partie 2 (Les Collections)
		ArrayList<Banque> banques  = new ArrayList<>(); // tableau dynamique
		System.out.println(banques.size()); // size = nombre d'elements
		System.out.println(banques.isEmpty()); // boolean
		
		banques.add(banque1);
		banques.add(banque2);
		System.out.println(banques.get(0).getComptesBancaires());
		System.out.println(banques.get(1).getComptesBancaires());
//		banques.remove(banque2);
//		System.out.println(banques);
//		banques.add(0, banque2);
//		System.out.println(banques);
//		banques.remove(1);
//		System.out.println(banques);
		System.out.println(banques.size());
		System.out.println(banques.isEmpty());

	}

}
