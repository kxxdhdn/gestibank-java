package entities;

import java.time.LocalDate;

public class Banque {

	private int idBanque;
	private String nomBanque;
	private String adresseBanque;
	private double capitalBanque;
	
	// Cas d'une seule banque = GK_Gestibanque
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

	@Override
	public String toString() {
		return "Banque [\nidBanque=" + idBanque + ", \nnomBanque=" + nomBanque + ", \nadresseBanque=" + adresseBanque
				+ ", \ncapitalBanque=" + capitalBanque + "\n]";
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
