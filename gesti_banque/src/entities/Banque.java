package entities;

import java.util.ArrayList;

public class Banque {

	private int idBanque;
	private String nomBanque;
	private String adresseBanque;
	private double capitalBanque;

	// Cas d'une seule banque = GK_Gestibanque
//	private static double soldeTotalComptes;
//	private static int nbreTotalCompte;

	// Cas de plusieurs banque
	private double soldeTotalComptes;
	private int nbreTotalCompte;

	// Partie 2 début
	private ArrayList<CompteBancaire> comptesBancaires = new ArrayList<>();
	

	public ArrayList<CompteBancaire> getComptesBancaires() {
		return comptesBancaires;
	}

//	public void setComptesBancaires(ArrayList<CompteBancaire> comptesBancaires) {
//		this.comptesBancaires = comptesBancaires;
//	}
	
	public void addComptesBancaires(CompteBancaire cb) {
		this.comptesBancaires.add(cb);
	}
	
	public void rmComptesBancaires(CompteBancaire cb) {
		this.comptesBancaires.remove(cb);
	}
	// Partie 2 fin

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

	/*
	 * public static double getSoldeTotalComptes() { return soldeTotalComptes; }
	 * 
	 * public static void setSoldeTotalComptes(double soldeTotalComptes) {
	 * Banque.soldeTotalComptes = soldeTotalComptes; }
	 * 
	 * public static int getNbreTotalCompte() { return nbreTotalCompte; }
	 * 
	 * public static void setNbreTotalCompte(int nbreTotalCompte) {
	 * Banque.nbreTotalCompte = nbreTotalCompte; }
	 * 
	 * @Override public String toString() { return "Banque [\nidBanque=" + idBanque
	 * + ", \nnomBanque=" + nomBanque + ", \nadresseBanque=" + adresseBanque +
	 * ", \ncapitalBanque=" + capitalBanque + "\n]"; }
	 */

	public double getSoldeTotalComptes() {
		return soldeTotalComptes;
	}

	public void setSoldeTotalComptes(double soldeTotalComptes) {
		this.soldeTotalComptes = soldeTotalComptes;
	}

	public int getNbreTotalCompte() {
		return nbreTotalCompte;
	}

	public void setNbreTotalCompte(int nbreTotalCompte) {
		this.nbreTotalCompte = nbreTotalCompte;
	}

	@Override
	public String toString() {
		return "Banque [\nidBanque=" + idBanque + ", \nnomBanque=" + nomBanque + ", \nadresseBanque=" + adresseBanque
				+ ", \ncapitalBanque=" + capitalBanque + ", \nsoldeTotalComptes=" + soldeTotalComptes
				+ ", \nnbreTotalCompte=" + nbreTotalCompte + "\n]";
	}

	public Banque() {

	}

	public Banque(int idBanque, String nomBanque, String adresseBanque, double capitalBanque) {

		this.idBanque = idBanque;
		this.nomBanque = nomBanque;
		this.adresseBanque = adresseBanque;
		this.capitalBanque = capitalBanque;

	}

}
