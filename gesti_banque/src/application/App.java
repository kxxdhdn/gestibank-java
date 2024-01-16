/**
 * Cette classe gère l'application de gestion de banque.
 * Elle permet de créer des banques, des comptes et d'afficher des informations.
 * 
 * Pour utiliser cette application, veuillez suivre les instructions affichées à l'écran.
 * 
 * @author TEAMCAT
 * @version 1.0
 */


package application;

import entities.Banque;
import entities.CompteBancaire;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création de la première banque
        Banque banque1 = saisirBanque(scanner, "premiere");

        // Création de deux comptes pour la première banque
        CompteBancaire compte1Banque1 = saisirCompte(scanner, banque1);
        CompteBancaire compte2Banque1 = saisirCompte(scanner, banque1);

      

        // Création de la deuxième banque
        Banque banque2 = saisirBanque(scanner, "deuxieme");

        // Création de deux comptes pour la deuxième banque
        CompteBancaire compte1Banque2 = saisirCompte(scanner, banque2);
        CompteBancaire compte2Banque2 = saisirCompte(scanner, banque2);

      

        // Comparaison des soldes et affichage de la banque avec le plus grand solde
        Banque banqueAvecPlusGrandSolde = comparerSolde(banque1, banque2);
        System.out.println("\nLa banque avec le plus grand solde est :");
        System.out.println(banqueAvecPlusGrandSolde.toString());

        // Fermer le scanner
        scanner.close();
    }

    // Méthode pour saisir les informations d'une banque
    private static Banque saisirBanque(Scanner scanner, String ordinal) {
        System.out.println("Saisir les informations pour la " + ordinal + " banque :");
        System.out.print("ID de la banque : ");
        int idBanque = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nom de la banque : ");
        String nomBanque = scanner.nextLine();
        System.out.print("Adresse de la banque : ");
        String adresseBanque = scanner.nextLine();
        System.out.print("Capital de la banque : ");
        double capitalBanque = scanner.nextDouble();

       
        return new Banque(idBanque, nomBanque, adresseBanque, capitalBanque);
    }

    // Méthode pour saisir les informations d'un compte associé à une banque
    private static CompteBancaire saisirCompte(Scanner scanner, Banque banque) {
        System.out.println("\nSaisir les informations pour un compte de la banque " + banque.getNomBanque() + " :");
        System.out.print("Numéro de compte : ");
        int numCompte = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Propriétaire du compte : ");
        String proprietaire = scanner.nextLine();
        System.out.print("Solde du compte : ");
        double soldeCompte = scanner.nextDouble();
        System.out.print("Date de création du compte (AAAA-MM-JJ) : ");
        LocalDate dateCreation = LocalDate.parse(scanner.next());

       
        return new CompteBancaire(numCompte, proprietaire, soldeCompte, dateCreation, banque.getIdBanque());
    }

    
    
 // Méthode pour comparer les soldes entre deux banques
    private static Banque comparerSolde(Banque banque1, Banque banque2) {
        return (Banque.getSoldeTotalComptes() >= Banque.getSoldeTotalComptes()) ? banque1 : banque2;
    }
}
