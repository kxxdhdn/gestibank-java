package application;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import entities.Banque;
import entities.CompteBancaire;

public class SaisieClavier {

	public static Banque creerBanqueClavier(Scanner sc) {
		System.out.println("\n****** Saisie des informations de la banque ******\n");
		Banque banque = new Banque();

		System.out.println("Donner l'ID de la banque : ");
		banque.setIdBanque(sc.nextInt());
		sc.nextLine(); // absorber une espace
		System.out.println("Donner le nom de la banque : ");
		banque.setNomBanque(sc.nextLine());
		System.out.println("Donner l'adresse de la banque : ");
		banque.setAdresseBanque(sc.nextLine());
		System.out.println("Donner le capital de la banque : ");
		banque.setCapitalBanque(sc.nextDouble());

		return banque;
	}

	public static CompteBancaire creerCompteClavier(Scanner sc, Banque banque) {
		System.out.println("\n****** Saisie des informations du compte ******\n");
		CompteBancaire cb = new CompteBancaire(); // mise à jour du solde avec un zéro

		System.out.println("Donner le numero du compte : ");
		cb.setNumCompte(sc.nextInt());
		sc.nextLine(); // absorber une espace
		System.out.println("Donner le nom et prenom de proprietaire du compte : ");
		cb.setProprietaire(sc.nextLine());
		System.out.println("Donner le solde initial du compte : ");
		cb.setSolde(sc.nextDouble());
		cb.setDateCreation(LocalDate.now());
//		System.out.println("Donner la date de la création du compte : ");
//		String creationDate = sc.nextString();
//		cb.setDateCreation(LocalDate.of(creationDate.split(" ")[0], creationDate.split(" ")[1], creationDate.split(" ")[2]));
		int idB;
		do {
			System.out.println("Donner l'ID de la banque du compte : ");
			idB = sc.nextInt();
		} while (idB != banque.getIdBanque());
		cb.setIdBanque(idB);

		// Mise à jour des infos de la banque correspondante
		banque.setNbreTotalComptes(banque.getNbreTotalComptes() + 1);
		banque.setSoldeTotalComptes(banque.getSoldeTotalComptes() + cb.getSolde());
		banque.addComptesBancaires(cb);

		return cb;
	}

	// Question 14
	public static Banque afficherBanqueGrandSolde(Banque[] banques) {
		double solde = 0;
		Banque banqueGrandSolde = null;
		for (Banque banque : banques) {
			if (banque.getSoldeTotalComptes() > solde) {
				solde = banque.getSoldeTotalComptes();
				banqueGrandSolde = banque;
			}
		}

//		for (int i = 0; i < banques.length - 1; i++) {
//			if (banques[i].getSoldeTotalComptes() < banques[i + 1].getSoldeTotalComptes()) {
//				banqueGrand = banques[i + 1];
//			} else {
//				banqueGrand = banques[i];
//			}
//		}

		System.out.println("La banque ayant le plus grand solde est : " + banqueGrandSolde.getNomBanque());

		return banqueGrandSolde;
	}

	// Partie 3 (JDBC et MySQL)
	public static void crudBanqueClavier(Scanner sc, Statement stmt, String operation) throws SQLException {

		switch (operation) {
		case "c":
			System.out.println("\n****** Créer une nouvelle banque ******\n");
			Banque newb = creerBanqueClavier(sc);
			stmt.executeUpdate("insert into banques(idBanque,nomBanque,adresseBanque,capitalBanque,"
					+ "soldeTotalComptes,nbreTotalComptes) values('" + newb.getIdBanque() + "','" + newb.getNomBanque()
					+ "','" + newb.getAdresseBanque() + "','" + newb.getCapitalBanque() + "','"
					+ newb.getSoldeTotalComptes() + "','" + newb.getNbreTotalComptes() + "')");
			break;

		case "u":
			System.out.println("\n****** Mettre à jour le capital d'une banque ******\n");
			System.out.println("Donner l'ID de la banque dont le capital est mis à jour : ");
			int idb = sc.nextInt();
			System.out.println("Donner le nouveau capital : ");
			double capitalBanque = sc.nextDouble();

			stmt.executeUpdate(
					"update banques set capitalBanque = '" + capitalBanque + "' where idBanque ='" + idb + "'");
			break;

		case "d":
			System.out.println("\n****** Supprimer une banque ******\n");
			System.out.println("Donner l'ID de la banque à supprimer : ");
			idb = sc.nextInt();
			stmt.executeUpdate("delete from banques where idBanque ='" + idb + "'");
			break;

		default:
			System.out.println("\n****** Afficher toutes les banques ******\n");
			ResultSet rs = stmt.executeQuery("select * from banques");

			while (rs.next()) {
				int idBanque = rs.getInt("idBanque");
				String nomBanque = rs.getString("nomBanque");
				String adresseBanque = rs.getString("adresseBanque");
				capitalBanque = rs.getDouble("capitalBanque");
				double soldeTotalComptes = rs.getDouble("soldeTotalComptes");
				int nbreTotalComptes = rs.getInt("nbreTotalComptes");
				System.out.println(idBanque + "\n" + nomBanque + "\n" + adresseBanque + "\n" + capitalBanque + "\n"
						+ soldeTotalComptes + "\n" + nbreTotalComptes + "\n");
			}
			break;
		}
	}

	public static void crudCompteClavier(Scanner sc, Banque banque, Statement stmt, String operation)
			throws SQLException {

		switch (operation) {
		case "c":
			System.out.println("\n****** Créer une nouveau compte bancaire ******\n");
			CompteBancaire newcb = creerCompteClavier(sc, banque);
			stmt.executeUpdate(
					"insert into comptesbancaires(numCompte,proprietaire,solde,dateCreation,idBanque) values('"
							+ newcb.getNumCompte() + "','" + newcb.getProprietaire() + "','" + newcb.getSolde() + "','"
							+ newcb.getDateCreation() + "','" + newcb.getIdBanque() + "')");
			// Mettre à jour la table banques
			int idb = newcb.getIdBanque();
			stmt.executeUpdate("update banques set soldeTotalComptes = '" + banque.getSoldeTotalComptes()
					+ "' where idBanque ='" + idb + "'");
			stmt.executeUpdate("update banques set nbreTotalComptes = '" + banque.getNbreTotalComptes()
					+ "' where idBanque ='" + idb + "'");
			break;

		case "u":
			System.out.println("\n****** Mettre à jour le solde d'un compte bancaire ******\n");
			System.out.println("Donner le numéro du compte dont le solde est mis à jour : ");
			int idcb = sc.nextInt();
			ResultSet rs = stmt.executeQuery("select * from comptesbancaires where numCompte = '" + idcb + "'");
			double oldSolde = 0.0;
			while (rs.next()) {
				oldSolde = rs.getDouble("solde");
			}
			System.out.println("Donner le nouveau solde : ");
			double newSolde = sc.nextDouble();
			stmt.executeUpdate(
					"update comptesbancaires set solde = '" + newSolde + "' where numCompte ='" + idcb + "'");
			// Mettre à jour la table banques
			banque.setSoldeTotalComptes(banque.getSoldeTotalComptes() - oldSolde + newSolde);
			break;

		case "d":
			System.out.println("\n****** Supprimer un compte bancaire ******\n");
			System.out.println("Donner le numéro du compte à supprimer : ");
			idcb = sc.nextInt();
			stmt.executeUpdate("delete from comptesbancaires where numCompte ='" + idcb + "'");
			// Mettre à jour la table banques
			rs = stmt.executeQuery("select * from comptesbancaires where numCompte = '" + idcb + "'");
			idb = 0;
			double rmSolde = 0.0;
			while (rs.next()) {
				idb = rs.getInt("idBanque");
				rmSolde = rs.getDouble("solde");
			}
			banque.setNbreTotalComptes(banque.getNbreTotalComptes() - 1);
			banque.setSoldeTotalComptes(banque.getSoldeTotalComptes() - rmSolde);
//			banque.rmComptesBancaires(cb);
			stmt.executeUpdate("update banques set soldeTotalComptes = '" + banque.getSoldeTotalComptes()
					+ "' where idBanque ='" + idb + "'");
			stmt.executeUpdate("update banques set nbreTotalComptes = '" + banque.getNbreTotalComptes()
					+ "' where idBanque ='" + idb + "'");
			break;

		default:
			System.out.println("\n****** Afficher tous les comptes bancaires ******\n");
			rs = stmt.executeQuery("select * from comptesbancaires");

			while (rs.next()) {
				int numCompte = rs.getInt("numCompte");
				String proprietaire = rs.getString("proprietaire");
				double solde = rs.getDouble("solde");
				Date dateCreation = rs.getDate("dateCreation");
				int idBanque = rs.getInt("idBanque");
				System.out.println(
						numCompte + "\n" + proprietaire + "\n" + solde + "\n" + dateCreation + "\n" + idBanque + "\n");
			}
			break;
		}
	}

}
