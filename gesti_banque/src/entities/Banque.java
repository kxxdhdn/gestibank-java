/**
 * Cette classe represente la classe Banque
 * 
 * 
 * 
 * @author TEAMCAT
 * @version 1.0
 */


package entities;

public class Banque {
    private int idBanque;
    private String nomBanque;
    private String adresseBanque;
    private double capitalBanque;
    public static double soldeTotalComptes;
    public static int nbreTotalCompte;

    public Banque() {
        
    }

    public Banque(int idBanque, String nomBanque, String adresseBanque, double capitalBanque) {
        this.idBanque = idBanque;
        this.nomBanque = nomBanque;
        this.adresseBanque = adresseBanque;
        this.capitalBanque = capitalBanque;
    }

    // Getters and setters
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

    public static int getNbreTotalCompte() {
        return nbreTotalCompte;
    }

  
    public String toString() {
        return "Banque [idBanque=" + idBanque + ", nomBanque=" + nomBanque + ", adresseBanque=" + adresseBanque
                + ", capitalBanque=" + capitalBanque + "]";
    }
    
    
    public static Banque trouverBanquePlusGrandSolde(Banque banque1, Banque banque2) {
        return (Banque.getSoldeTotalComptes() > Banque.getSoldeTotalComptes()) ? banque1 : banque2;
    }
}
