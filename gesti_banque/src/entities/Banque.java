package entities;

import java.time.LocalDate;
import java.util.Scanner;

public class Banque {

	private int idBanque;
	private String nomBanque;
	private String adresseBanque;
	private double capitalBanque;
	private static double soldeTotalComptes;
	private static int nbreTotalCompte;

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getAdresseBanque() {
		return adresseBanque;
	}

	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}

	public double getCapitalBanque() {
		return capitalBanque;
	}

	public void setCapitalBanque(double capitalBanque) {
		this.capitalBanque = capitalBanque;
	}

	public static double getSoldeTotalComptes() {
		return soldeTotalComptes;
	}

	public static void setSoldeTotalComptes(double soldeTotalComptes) {
		Banque.soldeTotalComptes = soldeTotalComptes;
	}

	public static int getNbreTotalCompte() {
		return nbreTotalCompte;
	}

	public static void setNbreTotalCompte(int nbreTotalCompte) {
		Banque.nbreTotalCompte = nbreTotalCompte;
	}

//	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", \nnomBanque=" + nomBanque + ", \nadresseBanque=" + adresseBanque
				+ ", capitalBanque=" + capitalBanque + "]";
	}

	public Banque() {

		nbreTotalCompte++;

	}

	public Banque(int idBanque, String nomBanque, String adresseBanque, double capitalBanque) {

		this.idBanque = idBanque;
		this.nomBanque = nomBanque;
		this.adresseBanque = adresseBanque;
		this.capitalBanque = capitalBanque;

	}

	public static CompteBancaire creerCompteViaClavier() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez le numero du compte : ");
		int numCompte = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Entrez le nom et prenom de proprietaire du compte : ");
		String proprietaire = scanner.nextLine();
		System.out.println("Entrer le solde du compte : ");
		double solde = scanner.nextDouble();
//		System.out.println("Entrer la date de la création du compte : ");
//		String dateCreation = scanner.nextLine();
		LocalDate dateCreation = LocalDate.now();
//		System.out.println("Entrez la date de creation");
//		String creationDate = scanner.nextString();
//		LocalDate localCreationDate = LocalDate.of(creationDate.split(" ")[0], creationDate.split(" ")[1], creationDate.split(" ")[2])
		System.out.println("Entrer l'ID de la banque du compte : ");
		int idBanque = scanner.nextInt();
		CompteBancaire cb = new CompteBancaire(numCompte, proprietaire, solde, 
//				LocalDate.of(dateCreation(0,4), dateCreation(4,6), dateCreation(6))
				dateCreation, idBanque);
		scanner.close();
		
		return cb;
	}

}
