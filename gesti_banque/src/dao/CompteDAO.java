package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import entities.CompteBancaire;

public class CompteDAO {

	private static String url = "";
	private static String username = "";
	private static String password = "";

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private ArrayList<CompteBancaire> cbs = new ArrayList<>();

	// 1) Méthode pour lire (et afficher) toutes les comptes bancaires
	public ArrayList<CompteBancaire> findAll() throws SQLException, IOException {
		initConnection(); // établissement de la connection + création du statement

		// Code pour sélectionner
		rs = stmt.executeQuery("select * from comptesbancaires");

		while (rs.next()) {
			CompteBancaire cb = new CompteBancaire();

			int numCompte = rs.getInt("numCompte");
			String proprietaire = rs.getString("proprietaire");
			double solde = rs.getDouble("solde");
			LocalDate dateCreation = rs.getDate("dateCreation").toLocalDate();
			int idBanque = rs.getInt("idBanque");

			cb.setNumCompte(numCompte);
			cb.setProprietaire(proprietaire);
			cb.setSolde(solde);
			cb.setDateCreation(dateCreation);
			cb.setIdBanque(idBanque);

			this.cbs.add(cb); // on ajoute le compte bancaire dans la liste des comptes
		}

		closeConnection();

		return this.cbs;
	}

	// 2) Méthode pour créer un nouveau compte bancaire
	public void create(CompteBancaire cb) throws SQLException, IOException {
		initConnection();

		// Code pour insérer
		int result = stmt.executeUpdate(
				"insert into comptesbancaires(numCompte,proprietaire,solde,dateCreation,idBanque) values('"
						+ cb.getNumCompte() + "','" + cb.getProprietaire() + "','" + cb.getSolde() + "','"
						+ cb.getDateCreation() + "','" + cb.getIdBanque() + "')");
		System.out.println("Nombre d'insertions des comptes bancaires : " + result);

		closeConnection();

	}

	// 3) Méthode pour mettre à jour
	public void update(int numCompte, double newSolde) throws SQLException, IOException {
		initConnection();

		// Code pour faire la mise à jour
		int result = stmt.executeUpdate(
				"update comptesbancaires set solde = '" + newSolde + "' where numCompte ='" + numCompte + "'");
		System.out.println("Nombre de mises à jour : " + result);

		closeConnection();

	}

	// 4) Méthode pour supprimer une banque par son id
	public void delete(int numCompte) throws SQLException, IOException {
		initConnection();

		// Code pour supprimer
		int result = stmt.executeUpdate("delete from comptesbancaires where numCompte ='" + numCompte + "'");
		System.out.println("Nombre de supressions des comptes bancaires : " + result);

		closeConnection();

	}

	public static void initConnection() throws SQLException, IOException {
		try (InputStream input = BanqueDAO.class.getClassLoader().getResourceAsStream("config.properties")) {
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

		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stmt = con.createStatement();
	}

	public static void closeConnection() throws SQLException {
		con.close();
	}

}
