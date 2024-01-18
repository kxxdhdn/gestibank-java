package application;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// 1-vérification de la connexion
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestibanque2024", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(con);

		// 2-insertion d'un client
		Statement stmt = con.createStatement();

		Scanner sc = new Scanner(System.in);
		System.out.println("Donner votre nom : ");
		String nomClient = sc.nextLine();
		System.out.println("Donner votre adresse : ");
		String adresseClient = sc.nextLine();
		sc.close();

		int result = stmt
				.executeUpdate("insert into client(nom,adresse) values('" + nomClient + "','" + adresseClient + "')");
		System.out.println("Nombre d'insertions : " + result); // c'est le nombre d'insertion

		// 3-affichage des elements de la base
		ResultSet rs = stmt.executeQuery("select id, nom, adresse from client");

		while (rs.next()) {
			int id = rs.getInt("id");
			String nom = rs.getString("nom");
			String adresse = rs.getString("adresse");
			System.out.println(id + " | " + nom + " | " + adresse);
		}
	}

}
