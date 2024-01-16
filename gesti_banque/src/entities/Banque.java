package entities;

public class Banque {

	public int idBanque;
	public String nomBanque;
	public String adresseBanque;
	public double capitalBanque;
	public static double soldeTotalComptes;
	public static int nbreTotalCompte;

//	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", nomBanque=" + nomBanque + ", adresseBanque=" + adresseBanque
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

}
