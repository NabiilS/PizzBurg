package packagePizza;
import java.sql.*;
import java.util.*;

public class ClientDb {

	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ClientDb clientdb = new ClientDb();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/pizzeria"; /* Commande pour savoir le port mysql: show global variables like 'PORT'; */
			String dbUsername = "root";
			String password = "";
			
			connection = DriverManager.getConnection(dbURL, dbUsername, password);
			
			System.out.println("Enter choice");
			System.out.println("1. Inserer");
			System.out.println("2. Supprimer");
			System.out.println("3. Selection");
			System.out.println("4. ...");
			int choice = Integer.parseInt(scanner.nextLine());
			
			
			
			switch(choice) {
			case 1:
				clientdb.insert();
				break;
			case 2: 
				clientdb.deleteTable();
				break;
			case 3:
				clientdb.selectRecord();
				break;
			default:
				System.out.println("Mauvais choix");
				break;
				
			}	
		} catch (Exception e) {
			throw new RuntimeException("Erreur detecte");
		}
		
		

	}
	
	private void insert() throws SQLException {

		
		String sql = "insert into client(nomClient, prenomClient, telClient) values (?,?,?)";
		
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("Entrez un nom");
		preparedStatement.setString(1, scanner.nextLine());
		System.out.println("Entrez un prénom");
		preparedStatement.setString(2, scanner.nextLine());
		System.out.println("Entrez un numéro de téléphone");
		preparedStatement.setString(3, scanner.nextLine());
		
		
		
		int rows = preparedStatement.executeUpdate();
		
		if(rows > 0) {
			System.out.println("Insertion exécuté avec succès");
		}
	}
	private void deleteTable() throws SQLException {
		String sql = "delete from client";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement = connection.prepareStatement(sql);

		
		
		preparedStatement.executeUpdate();
		System.out.println("Suppression des données éxécuté avec succès");
	
		
		/* Réinitialisation de l'auto increment */
		String sql2 = "ALTER TABLE client AUTO_INCREMENT = 0";
		preparedStatement = connection.prepareStatement(sql2);
		preparedStatement.executeUpdate();
	}
	public void selectRecord() throws SQLException {
		
		System.out.println("Entrez l'id du client souhaité");
		int idSelect = Integer.parseInt(scanner.nextLine());
		
		String sql3 = "select * from client where idClient = "+idSelect;
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql3);
		
		if(result.next()) {
			int idClient = result.getInt("idClient");
			String nomClient = result.getString("nomClient");
			String prenomClient = result.getString("prenomClient");
			String telClient = result.getString("telClient");
			
			System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
		} else System.out.println("Pas de données trouvés...");
	}
}









