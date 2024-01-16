package entities;

public class Banque {

	private int idBanque;
	private String nomBanque;
	private String adresseBanque;
	private double capitalBanque;
	private static double soldeTotalComptes;
	public static int nbreTotalCompte;

//	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", \nnomBanque=" 
	+ nomBanque + ", \nadresseBanque=" + adresseBanque
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
