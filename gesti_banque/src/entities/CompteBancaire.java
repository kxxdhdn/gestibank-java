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


//	@Override
	public String toString() {
		return "CompteBanquaire [numCompte=" + 
	numCompte + ", \nproprietaire=" + proprietaire.toUpperCase() + "\nsolde=" + solde
				+ ", dateCreation=" + dateCreation + ", idBanque=" + idBanque + "]";
	}

	public CompteBancaire() {
		super();
	}

	public CompteBancaire(int numCompte, String proprietaire, double solde, LocalDate dateCreation, int idBanque) {
		super();
		this.numCompte = numCompte;
		this.proprietaire = proprietaire;
//		String nom = proprietaire.toUpperCase().split(" ")[0].trim();
//		String prenom = proprietaire.toUpperCase().split(" ")[1].trim();
//		this.proprietaire = nom.substring(0,1) + nom.substring(1).toLowerCase() + 
//				" " + prenom.substring(0,1) + prenom.substring(1).toLowerCase();
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idBanque = idBanque;
	}

	public double crediter(double montant) {
		if(montant > 1 && montant < 1000){
			this.solde += montant;
		}
		else {
			System.out.println(" operation non autorisée");
		}
		return this.solde;

	}

	public double debiter(double montant) {
		if(this.solde >=  montant ) {
			this.solde -= montant;

		} else {

			System.out.println("Solde insuffisant ")
		}
		return this.solde;

	}



}
