package entities;

import java.time.LocalDate;

public class CompteBancaire {

	private int numCompte;
	private String proprietaire;
	private double solde;
	private LocalDate dateCreation;
	private int idBanque;

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
//		Banque.soldeTotalComptes += this.solde;
		Banque.setSoldeTotalComptes(Banque.getSoldeTotalComptes() + this.solde);
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}

	@Override
	public String toString() {
		return "CompteBanquaire [\nnumCompte=" + numCompte + ", \nproprietaire=" + proprietaire.toUpperCase()
				+ ", \nsolde=" + solde + ", \ndateCreation=" + dateCreation + ", \nidBanque=" + idBanque + "\n]";
	}

	public CompteBancaire() {

		// VERSION 1 : sans encapsulation
//		Banque.nbreTotalCompte++;
//		Banque.soldeTotalComptes += this.solde;

		// VERSION 2 : avec encapsulation
		Banque.setNbreTotalCompte(Banque.getNbreTotalCompte() + 1);
//		Banque.setSoldeTotalComptes(Banque.getSoldeTotalComptes() + this.solde);
	}

	public CompteBancaire(int numCompte, String proprietaire, double solde, LocalDate dateCreation, int idBanque) {

		this.numCompte = numCompte;
		this.proprietaire = proprietaire;
//		String nom = proprietaire.toUpperCase().split(" ")[0].trim();
//		String prenom = proprietaire.toUpperCase().split(" ")[1].trim();
//		this.proprietaire = nom.substring(0,1) + nom.substring(1).toLowerCase() + 
//				" " + prenom.substring(0,1) + prenom.substring(1).toLowerCase();
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idBanque = idBanque;
		
		// VERSION 1 : sans encapsulation
//		Banque.nbreTotalCompte++;
//		Banque.soldeTotalComptes += this.solde;

		// VERSION 2 : avec encapsulation
		Banque.setNbreTotalCompte(Banque.getNbreTotalCompte() + 1);
		Banque.setSoldeTotalComptes(Banque.getSoldeTotalComptes() + this.solde);

	}

	public double crediter(double montant) {
		if (montant >= 1 && montant <= 1000) {
			this.solde += montant;
			System.out.println("Ajout de solde avec succès.");
		} else {
			System.out.println("Opération non autorisée car le montant est invalide.");
		}
		return this.solde;

	}

	public double debiter(double montant) {
		if (montant >= 1 && montant <= this.solde) {
			this.solde -= montant;
			System.out.println("Débit de solde avec succès.");
		} else {
			System.out.println("Solde insuffisant ou le montant est invalide.");
		}
		return this.solde;

	}

}
