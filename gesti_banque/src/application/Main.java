package application;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import entities.Banque;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		// 0-lire l'accès de la base de données
		String url = "";
		String username = "";
		String password = "";
		try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
			Properties config = new Properties();

			config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));

			String servername = config.getProperty("servername");
			String dbname = config.getProperty("dbname");
			url = "jdbc:mysql://" + servername + "/" + dbname + "?autoReconnect=true&useSSL=false";
			username = config.getProperty("username");
			password = config.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 1-vérification de la connexion
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(con);

		Statement stmt = con.createStatement();

		Scanner sc = new Scanner(System.in);

		/*
		 * // 2-insertion d'un client System.out.println("Donner votre nom : "); String
		 * nomClient = sc.nextLine(); System.out.println("Donner votre adresse : ");
		 * String adresseClient = sc.nextLine();
		 * 
		 * int result = stmt .executeUpdate("insert into client(nom,adresse) values('" +
		 * nomClient + "','" + adresseClient + "')");
		 * System.out.println("Nombre d'insertions : " + result); // c'est le nombre
		 * d'insertion
		 * 
		 * // Question 1 : suppresion d'un client
		 * System.out.println("Donner l'ID du client à supprimer : "); int idc =
		 * sc.nextInt();
		 * 
		 * result = stmt.executeUpdate("delete from client where ID ='" + idc + "'"); //
		 * insert, delete et update System.out.println("Nombre de suppressions : " +
		 * result);
		 * 
		 * // Question 2 : mise à jour de l'adresse d'un client
		 * System.out.println("Donner l'ID du client dont l'adresse est mise à jour : "
		 * ); idc = sc.nextInt(); sc.nextLine();
		 * System.out.println("Donner la nouvelle adresse : "); adresseClient =
		 * sc.nextLine();
		 * 
		 * result = stmt.executeUpdate("update client set adresse = '" + adresseClient +
		 * "' where id ='" + idc + "'");
		 * System.out.println("Nombre d'adresses mises à jour : " + result);
		 * 
		 * // 3-affichage des elements de la base ResultSet rs =
		 * stmt.executeQuery("select id, nom, adresse from client");
		 * 
		 * while (rs.next()) { int id = rs.getInt("id"); String nom =
		 * rs.getString("nom"); String adresse = rs.getString("adresse");
		 * System.out.println(id + " | " + nom + " | " + adresse); }
		 */

		// Partie 3 (JDBC et MySQL)
		SaisieClavier.crudBanqueClavier(sc, stmt, "c");
		SaisieClavier.crudBanqueClavier(sc, stmt, "r");
		SaisieClavier.crudBanqueClavier(sc, stmt, "u");
		SaisieClavier.crudBanqueClavier(sc, stmt, "r");
		SaisieClavier.crudBanqueClavier(sc, stmt, "d");
		SaisieClavier.crudBanqueClavier(sc, stmt, "r");

		Banque banque = new Banque();
		System.out.println("Donner l'ID de la banque dont vous gérez les comptes : ");
		int idb = sc.nextInt();
		ResultSet rs = stmt.executeQuery("select * from banques where idBanque = '" + idb + "'");
		while (rs.next()) {
			banque.setIdBanque(rs.getInt("idBanque"));
			banque.setNomBanque(rs.getString("nomBanque"));
			banque.setAdresseBanque(rs.getString("adresseBanque"));
			banque.setCapitalBanque(rs.getDouble("capitalBanque"));
			banque.setSoldeTotalComptes(rs.getDouble("soldeTotalComptes"));
			banque.setNbreTotalComptes(rs.getInt("nbreTotalComptes"));
		}
		SaisieClavier.crudCompteClavier(sc, banque, stmt, "c");
		SaisieClavier.crudCompteClavier(sc, banque, stmt, "r");
		SaisieClavier.crudCompteClavier(sc, banque, stmt, "u");
		SaisieClavier.crudCompteClavier(sc, banque, stmt, "r");
		SaisieClavier.crudCompteClavier(sc, banque, stmt, "d");
		SaisieClavier.crudCompteClavier(sc, banque, stmt, "r");

		sc.close();
	}

}
