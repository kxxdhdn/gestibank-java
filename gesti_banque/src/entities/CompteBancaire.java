package entities;

import java.time.LocalDate;

public class CompteBancaire {

	private int numCompte;
	private String proprietaire;
	private double solde;
	private LocalDate dateCreation;
	private int idBanque;

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

}
