/**
 * Cette classe represente la classe Comptebancaire
 * 
 * 
 * 
 * 
 * @author TEAMCAT
 * @version 1.0
 */

package entities;

import java.time.LocalDate;

public class CompteBancaire {
    private int numCompte;
    private String proprietaire;
    private double solde;
    private LocalDate dateCreation;
    private int idBanque;

    public CompteBancaire() {
        
    }

    public CompteBancaire(int numCompte, String proprietaire, double solde, LocalDate dateCreation, int idBanque) {
        this.numCompte = numCompte;
        this.proprietaire = proprietaire.toUpperCase(); 
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.idBanque = idBanque;
        Banque.soldeTotalComptes += solde;
        Banque.nbreTotalCompte++;
    }

    // Getters and setters
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
        this.proprietaire = proprietaire.toUpperCase();
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

    // Méthode pour créditer le solde
    public double crediter(double montant) {
        if (montant > 0 && montant < 1000) {
            solde += montant;
            Banque.soldeTotalComptes += montant;
        } else {
            System.out.println("Erreur : Montant invalide !");
        }
        return solde;
    }

    // Méthode pour débiter le solde
    public double debiter(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            Banque.soldeTotalComptes -= montant;
        } else {
            System.out.println("Erreur : Montant invalide ou solde insuffisant !");
        }
        return solde;
    }

    public String toString() {
        return "CompteBancaire [numCompte=" + numCompte + ", proprietaire=" + proprietaire + ", solde=" + solde
                + ", dateCreation=" + dateCreation + ", idBanque=" + idBanque + "]";
    }
}
