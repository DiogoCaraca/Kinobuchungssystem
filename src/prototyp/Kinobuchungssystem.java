package prototyp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Kinobuchungssystem {
	public Sammlung s = new Sammlung();
	public Scanner sc = new Scanner(System.in);
	public String eingabe;

	public Kinobuchungssystem() throws ClassNotFoundException, SQLException, InterruptedException {
		reservierungSperichern(null);
		reservierungLöschen();
	}

	public void reservierungSperichern(Reservierung reservierung)
			throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Eine Verbindung aufbauen durch die "Connection" Klasse
		// Hier wird der Pfad, Username und Password übergeben MS SQL Server
		Connection conn = DriverManager.getConnection(DbHelper.url, DbHelper.userName, DbHelper.password);
		// System.out.println("IT WORKS :)");

		// Objekt bereit machen für die Queries/Abfragen
		java.sql.Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("Select id_vorstellung, name, Datum, Saal_Nr, Reihe, Platznummer from tbl_Film f\r\n"
						+ " inner join tbl_Vorstellung v on id_film = FK_film \r\n"
						+ " inner join tbl_Saal s on id_saal = FK_Saal\r\n"
						+ " inner join tbl_Reservierung r on r.FK_vorstellung = v.id_vorstellung\r\n"
						+ " inner join tbl_Platz p on id_platz = FK_platz\r\n"
						+ " inner join tbl_Reihe re on re.id_reihe = FK_reihe;\r\n" + " ");

		System.out.print("Reservierungen werden geladen");
		for (int i = 0; i < 10; i++) {
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(500);
		}

		rs = stmt.executeQuery("Select id_res, name, Datum, Saal_Nr, Reihe, Platznummer from tbl_Film f\r\n"
				+ " inner join tbl_Vorstellung v on id_film = FK_film \r\n"
				+ " inner join tbl_Saal s on id_saal = FK_Saal\r\n"
				+ " inner join tbl_Reservierung r on r.FK_vorstellung = v.id_vorstellung\r\n"
				+ " inner join tbl_Platz p on id_platz = FK_platz\r\n"
				+ " inner join tbl_Reihe re on re.id_reihe = FK_reihe;\r\n" + " ");

		while (rs.next()) {
			System.out.println("\nID: " + rs.getString(1) + ", Titel: " + rs.getString(2) + ", Datum: "
					+ rs.getString(3) + ", Saal: " + rs.getString(4) + ", Reihe: " + rs.getString(5) + ", Sitz: "
					+ rs.getString(6));

		}

		System.out.println("");

	}

	public void reservierungLöschen() throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Eine Verbindung aufbauen durch die "Connection" Klasse
		// Hier wird der Pfad, Username und Password übergeben MS SQL Server
		Connection conn = DriverManager.getConnection(DbHelper.url, DbHelper.userName, DbHelper.password);
		// System.out.println("IT WORKS :)");

		// Objekt bereit machen für die Queries/Abfragen
		java.sql.Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select name, Datum, Saal_Nr, Reihe, Platznummer from tbl_Film f\r\n"
				+ " inner join tbl_Vorstellung v on id_film = FK_film \r\n"
				+ " inner join tbl_Saal s on id_saal = FK_Saal\r\n"
				+ " inner join tbl_Reservierung r on r.FK_vorstellung = v.id_vorstellung\r\n"
				+ " inner join tbl_Platz p on id_platz = FK_platz\r\n"
				+ " inner join tbl_Reihe re on re.id_reihe = FK_reihe;\r\n" + " ");
		
		
		
			
		  
			System.out.println("Möchten sie Reservierung löschen (y/n)");
			eingabe = sc.next();
			if (eingabe.equals("y")) {
				System.out.println("Möchten sie alle Reservierungen löschen(y/n)");
				eingabe = sc.next();
				
				//rs = stmt.executeQuery("DROP table if exists tbl_Reservierung");
				
				if(eingabe.equals("n")) {
					System.out.println("Reservierung (id): ");
					String resid = sc.next();
					
					rs = stmt.executeQuery("DELETE from tbl_Reservierung WHERE id_res = " + resid);
					
					
				}
			} else if(eingabe.equals("n")) {
				StartApp str = new StartApp();
				str.menu();
			}
				
				

				
			} 

	public void registerBesucher(Besucher besucher) {

	}

}
