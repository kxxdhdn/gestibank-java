package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import entities.Banque;

public class BanqueDAO {

	private static String url = "";
	private static String username = "";
	private static String password = "";

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private ArrayList<Banque> banques = new ArrayList<>();

	// 1) Méthode pour lire (et afficher) toutes les banques
	public ArrayList<Banque> findAll() throws SQLException, IOException {
		initConnection(); // établissement de la connection + création du statement
		
		// Code pour sélectionner
		rs = stmt.executeQuery("select * from banques"); // * = toutes les colonnes

		while (rs.next()) {
			Banque banque = new Banque();

			int idBanque = rs.getInt("idBanque");
			String nomBanque = rs.getString("nomBanque");
			String adresseBanque = rs.getString("adresseBanque");
			double capitalBanque = rs.getDouble("capitalBanque");
			double soldeTotalComptes = rs.getDouble("soldeTotalComptes");
			int nbreTotalComptes = rs.getInt("nbreTotalComptes");

			banque.setIdBanque(idBanque);
			banque.setNomBanque(nomBanque);
			banque.setAdresseBanque(adresseBanque);
			banque.setCapitalBanque(capitalBanque);
			banque.setSoldeTotalComptes(soldeTotalComptes);
			banque.setNbreTotalComptes(nbreTotalComptes);

			this.banques.add(banque); // on ajoute la banque dans la liste des banques
		}

		closeConnection();

		return this.banques;
	}

	// 2) Méthode pour créer une nouvelle banque
	public void create(Banque banque) throws SQLException, IOException {
		initConnection();
		
		// Code pour insérer
		int result = stmt.executeUpdate("insert into banques(idBanque,nomBanque,adresseBanque,capitalBanque,"
				+ "soldeTotalComptes,nbreTotalComptes) values('" + banque.getIdBanque() + "','" + banque.getNomBanque()
				+ "','" + banque.getAdresseBanque() + "','" + banque.getCapitalBanque() + "','"
				+ banque.getSoldeTotalComptes() + "','" + banque.getNbreTotalComptes() + "')");
		System.out.println("Nombre d'insertions de banques : " + result);

		closeConnection();

	}
	
	// 3) Méthode pour mettre à jour
	public void update(int idBanque, double newCapital) throws SQLException, IOException {
		initConnection();
		
		// Code pour faire la mise à jour
		int result = stmt.executeUpdate(
				"update banques set capitalBanque = '" + newCapital + "' where idBanque ='" + idBanque + "'");
		System.out.println("Nombre de mise à jour : " + result);

		closeConnection();

	}

	// 4) Méthode pour supprimer une banque par son id
	public void delete(int idBanque) throws SQLException, IOException {
		initConnection();
		
		// Code pour supprimer
		int result = stmt.executeUpdate("delete from banques where idBanque ='" + idBanque + "'");
		System.out.println("Nombre de supression de banques : " + result);

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
