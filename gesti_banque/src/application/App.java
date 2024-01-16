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

//		System.out.println("banque: " + banque);
//		System.out.println("cb1: " + cb1);
//		System.out.println("cb2: " + cb2);

		// Question 13
		Banque banque2 = creerBanqueViaClavier();
		System.out.println("banque2: " + banque2);
		CompteBancaire cb21 = Banque.creerCompteViaClavier();
		System.out.println("cb21: " + cb21);
		CompteBancaire cb22 = Banque.creerCompteViaClavier();
		System.out.println("cb22: " + cb22);
		
		// Question 15
		Banque[] banques = {banque, banque2};
		System.out.println("Banque ayant le plus grand solde : " + afficherBanqueGrandSolde(banques));

	}
	
	public static Banque creerBanqueViaClavier() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrer l'ID de la banque : ");
		int idBanque = scanner.nextInt();
		scanner.nextLine(); // question ?
		System.out.println("Entrer le nom de la banque : ");
		String nomBanque = scanner.nextLine();
		System.out.println("Entrer l'adresse de la banque : ");
		String adresseBanque = scanner.nextLine();
		System.out.println("Entrer le capital de la banque : ");
		double capitalBanque = scanner.nextDouble();
		scanner.close();
		
		return new Banque(idBanque, nomBanque, adresseBanque, capitalBanque);
	}
	
	// Question 14
	public static Banque afficherBanqueGrandSolde(Banque[] banques) {
		Banque banqueGrand = banques[0];
		for(int i=0;i < banques.length-1;i++){
			if (banques[i].getSoldeTotalComptes() < banques[i+1].getSoldeTotalComptes()) {
				banqueGrand = banques[i+1];
			}
			else {
				banqueGrand = banques[i];
			}
		}
		return banqueGrand;
	}

}
