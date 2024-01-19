package application;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import dao.BanqueDAO;
import entities.Banque;

public class MainBanque {

	public static void main(String[] args) throws SQLException, IOException {

		// Saisie au clavier des informations
		Scanner sc = new Scanner(System.in);

		// Création de l'objet DAO BanqueDAO banqueDAO = new BanqueDAO();
		BanqueDAO banqueDAO = new BanqueDAO();

		// CRUD.C-Création de banque
		System.out.println("\n****** Créer une nouvelle banque ******\n");
		
		// Création de l'objet en mémoire Banque banque = new Banque();
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

		// CRUD.D-Supprimer une banque
		System.out.println("\n****** Supprimer une banque ******\n");
		
		System.out.println("Donner l'ID de la banque à supprimer : ");
		int idBanque = sc.nextInt();
		try {
			banqueDAO.delete(idBanque);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		sc.close();

	}

}
