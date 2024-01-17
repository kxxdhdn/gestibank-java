package application;

import java.time.LocalDate;
import java.util.Scanner;

import entities.Banque;
import entities.CompteBancaire;

public class SaisieClavier {

	public static Banque creerBanqueClavier(Scanner sc) {
		System.out.println("****** Saisie des informations de la banque ******\n");
		Banque banque = new Banque();

		System.out.println("Entrer l'ID de la banque : ");
		banque.setIdBanque(sc.nextInt());
		sc.nextLine(); // absorber une espace
		System.out.println("Entrer le nom de la banque : ");
		banque.setNomBanque(sc.nextLine());
		System.out.println("Entrer l'adresse de la banque : ");
		banque.setAdresseBanque(sc.nextLine());
		System.out.println("Entrer le capital de la banque : ");
		banque.setCapitalBanque(sc.nextDouble());

		return banque;
	}

	public static CompteBancaire creerCompteClavier(Scanner sc, int idBanque) {
		System.out.println("****** Saisie des informations des comptes ******\n");
		CompteBancaire cb = new CompteBancaire();

		System.out.println("Entrez le numero du compte : ");
		cb.setNumCompte(sc.nextInt());
		sc.nextLine(); // absorber une espace
		System.out.println("Entrez le nom et prenom de proprietaire du compte : ");
		cb.setProprietaire(sc.nextLine());
		System.out.println("Entrer le solde initial du compte : ");
		cb.setSolde(sc.nextDouble());
		cb.setDateCreation(LocalDate.now());
//		System.out.println("Entrer la date de la création du compte : ");
//		String creationDate = sc.nextString();
//		cb.setDateCreation(LocalDate.of(creationDate.split(" ")[0], creationDate.split(" ")[1], creationDate.split(" ")[2]));
		int idB;
		do {
			System.out.println("Entrer l'ID de la banque du compte : ");
			idB = sc.nextInt();
		} while (idB != idBanque);
		cb.setIdBanque(idB);

		return cb;
	}

}
