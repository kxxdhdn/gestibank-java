package application;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import dao.BanqueDAO;
import dao.CompteDAO;
import entities.Banque;
import entities.CompteBancaire;

public class MainBanque {

	public static void main(String[] args) throws SQLException, IOException {

		// Saisie au clavier des informations
		Scanner sc = new Scanner(System.in);
		
		// Création de l'objet DAO BanqueDAO banqueDAO = new BanqueDAO();
		BanqueDAO banqueDAO = new BanqueDAO();
		/*
		// CRUD.C-Création de banque
		System.out.println("\n****** Créer une nouvelle banque ******\n");

		// Création de l'objet en mémoire Banque newBanque = new Banque();
		Banque newBanque = SaisieClavier.creerBanqueClavier(sc);
		try {
			banqueDAO.create(newBanque);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.R-Afficher toutes les banques
		System.out.println("\n****** Afficher toutes les banques ******\n");

		try {
//			System.out.println(banqueDAO.findAll());
			for (Banque banque : banqueDAO.findAll()) {
				System.out.println(banque);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.U-Mettre à jour une banque
		System.out.println("\n****** Mettre à jour le capital d'une banque ******\n");

		System.out.println("Donner l'ID de la banque dont le capital est mis à jour : ");
		int idb = sc.nextInt();
		System.out.println("Donner le nouveau capital : ");
		double newCapitale = sc.nextDouble();
		try {
			banqueDAO.update(idb, newCapitale);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.D-Supprimer une banque
		System.out.println("\n****** Supprimer une banque ******\n");

		System.out.println("Donner l'ID de la banque à supprimer : ");
		int idBanque = sc.nextInt();
		try {
			banqueDAO.delete(idBanque);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		// CRUD.R-Afficher toutes les banques
		System.out.println("\n****** Afficher toutes les banques ******\n");

		try {
			for (Banque banque : banqueDAO.findAll()) {
				System.out.println(banque);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ******************************

		// ******************************

		// Création de l'objet DAO : compteDAO
		CompteDAO compteDAO = new CompteDAO();

		// CRUD.C-Création de compte bancaire
		System.out.println("\n****** Créer une nouveau compte bancaire ******\n");

		// Création de l'objet en mémoire : newCompte
		Banque bnp = banqueDAO.findAll().get(0);
//		System.out.println("coucou "+bnp.getIdBanque());
		CompteBancaire newCompte = SaisieClavier.creerCompteClavier(sc, bnp);
		try {
			compteDAO.create(newCompte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.R-Afficher tous les comptes bancaires
		System.out.println("\n****** Afficher tous les comptes bancaires ******\n");

		try {
//			System.out.println(compteDAO.findAll());
			for (CompteBancaire cb : compteDAO.findAll()) {
				System.out.println(cb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.U-Mettre à jour un compte bancaire
		System.out.println("\n****** Mettre à jour le solde d'un compte bancaire ******\n");

		System.out.println("Donner l'ID du compte dont le solde est mis à jour : ");
		int idcb = sc.nextInt();
		System.out.println("Donner le nouveau solde : ");
		double newSolde = sc.nextDouble();
		try {
			compteDAO.update(idcb, newSolde);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.D-Supprimer une banque
		System.out.println("\n****** Supprimer un compte bancaire ******\n");

		System.out.println("Donner l'ID du compte bancaire à supprimer : ");
		int numCompte = sc.nextInt();
		try {
			compteDAO.delete(numCompte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CRUD.R-Afficher tous les comptes bancaires
		System.out.println("\n****** Afficher tous les comptes bancaires ******\n");

		try {
			for (CompteBancaire cb : compteDAO.findAll()) {
				System.out.println(cb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();

	}

}
