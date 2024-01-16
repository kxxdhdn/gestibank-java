package entities;

import java.time.LocalDate;

public class CompteBancaire {

	public int numCompte;
	public String proprietaire;
	public double solde;
	public LocalDate dateCreation;
	public int idBanque;

//	@Override
	public String toString() {
		return "CompteBanquaire [numCompte=" + numCompte + ", proprietaire=" + proprietaire + ", solde=" + solde
				+ ", dateCreation=" + dateCreation + ", idBanque=" + idBanque + "]";
	}

	public CompteBancaire() {
		super();
	}

	public CompteBancaire(int numCompte, String proprietaire, double solde, LocalDate dateCreation, int idBanque) {
		super();
		this.numCompte = numCompte;
		this.proprietaire = proprietaire;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idBanque = idBanque;
	}

}
