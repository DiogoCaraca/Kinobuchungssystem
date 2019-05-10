package prototyp;

import java.beans.Statement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StartApp {
	public int eingabe;
	public Scanner sc = new Scanner(System.in);

	public StartApp() throws ClassNotFoundException, SQLException, InterruptedException {
		System.out.println("+++++++++++++++++ Willkommen.. +++++++++++++++++");
		System.out.println("+++++++++++++++ Java Kino 4.0.3 ++++++++++++++++");
		System.out.println();
		menu();
	}

	public void menu() throws ClassNotFoundException, SQLException, InterruptedException {
		System.out.println("1) Vorstellung auswählen");
		System.out.println("2) Reservierung details");
		System.out.println("3) Besucher details");

		eingabe();

		switch (eingabe) {
		case 1:
			vorstellungAuswählen();
			break;
		case 2:
			reservierungDetails();
			break;
		case 3:
			besucherDetails();
			break;

		}

	}

	private void besucherDetails() {

	}

	private void reservierungDetails() throws ClassNotFoundException, SQLException, InterruptedException {
		Kinobuchungssystem k = new Kinobuchungssystem();

	}

	private void vorstellungAuswählen() throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Eine Verbindung aufbauen durch die "Connection" Klasse
			// Hier wird der Pfad, Username und Password übergeben MS SQL Server
			Connection conn = DriverManager.getConnection(DbHelper.url, DbHelper.userName, DbHelper.password);
			// System.out.println("IT WORKS :)");

			// Objekt bereit machen für die Queries/Abfragen
			java.sql.Statement stmt = conn.createStatement();
			
			
			

			// Vorstellung in ein ResultSet speichern
			 ResultSet rs = stmt.executeQuery("Select id_vorstellung, name, Datum, Saal_Nr from tbl_Film f\r\n"
					+ "inner join tbl_Vorstellung v on id_film = FK_film \r\n"
					+ "inner join tbl_Saal s on id_saal = FK_saal;   \r\n" + " ");

			// Ladevorgang
			System.out.print("Liste Vorstellung wird zurückgegeben");
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(500);
			}

			System.out.println();

			// Alle Vorstellungen auf der Konsole printen
			while (rs.next()) {

				System.out.println("\nID: " + rs.getString(1) + ", Titel: " + rs.getString(2) + ", Datum: "
						+ rs.getString(3) + ", Saal: " + rs.getString(4));

			}

			// Vorstellung auswählen
			System.out.println();
			System.out.println("Wähle Vorstellung (id): ");
			String vorstellung = sc.next();

			// AUSGEWÄHLTER FILM IN EIN RESULTSET SPEICHERN
			rs = stmt.executeQuery("Select id_film, name, Datum, Saal_Nr from tbl_Film f\r\n"
					+ "inner join tbl_Vorstellung v on id_film = FK_film \r\n"
					+ "inner join tbl_Saal s on id_saal = FK_saal   \r\n" + "WHERE id_vorstellung = " + vorstellung);

			System.out.println();
			System.out.println("Ausgewählte Vorstellung:");
			rs.next();
			System.out.println("ID: " + rs.getString(1) + ", Titel: " + rs.getString(2) + ", Datum: " + rs.getString(3)
					+ ", Saal: " + rs.getString(4));

			rs = stmt.executeQuery("Select Reihe from tbl_Reihe");
			System.out.println();

			System.out.print("Reihe wird zurückgegeben");
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(500);
			}

			while (rs.next()) {

				System.out.println("\n Reihe: " + rs.getString(1));

			}

			System.out.println("Reihe: ");
			String reihe = sc.next();

			rs = stmt.executeQuery("Select Reihe from tbl_Reihe Where Reihe = " + "'" + reihe + "'");

			System.out.println("Ausgewählte Reihe: ");

			rs.next();
			System.out.println("Reihe: " + rs.getString(1));

			rs = stmt.executeQuery("Select Platznummer " + "from tbl_Platz p "
					+ "Where FK_reihe =  (Select id_reihe from tbl_reihe where reihe =" + "'" + reihe + "'" + ") AND"
					+ " not exists (\r\n" + "  Select *\r\n" + "  from tbl_Reservierung r\r\n"
					+ "  where r.FK_vorstellung = " + vorstellung + "  and p.id_platz = r.FK_platz\r\n " + "  )");

			System.out.print("Plätze");
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(500);
			}

			System.out.println();

			while (rs.next()) {

				System.out.println("\n Platz: " + rs.getString(1));

			}
			
			System.out.println("Platz: ");
			String platz = sc.next();

			rs = stmt.executeQuery("Select Platznummer from tbl_Platz Where Platznummer = " + platz);

			rs.next();
			System.out.println("Ausgewählter Platz: " + rs.getString(1));
			
		

			rs = stmt.executeQuery("Select p.id_platz\r\n" + "from tbl_Platz p\r\n"
					+ "inner join tbl_Reihe r on p.FK_reihe = r.id_reihe\r\n" + "where Platznummer = " + platz
					+ " and r.Reihe = " + "'" + reihe + "'");
			
			

			// System.out.println(platz + reihe);

			// rs.next();
			// System.out.println("ID: " + rs.getString(1));

			rs.next();
			String platzId = rs.getString(1);

			System.out.println();

			rs = stmt.executeQuery("insert into tbl_Reservierung(FK_vorstellung, FK_platz) OUTPUT inserted.id_res "
					+ "values ( " + vorstellung + ", " + platzId + " )");

			rs.next();
			String resid = rs.getString(1);

			System.out.print("Ticket wird ausgedruckt");
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(500);
			}

			rs = stmt.executeQuery("Select name, Datum, Saal_Nr, Reihe, Platznummer from tbl_Film f\r\n"
					+ " inner join tbl_Vorstellung v on id_film = FK_film \r\n"
					+ " inner join tbl_Saal s on id_saal = FK_Saal\r\n"
					+ " inner join tbl_Reservierung r on r.FK_vorstellung = v.id_vorstellung\r\n"
					+ " inner join tbl_Platz p on id_platz = FK_platz\r\n"
					+ " inner join tbl_Reihe re on re.id_reihe = FK_reihe\r\n" + "Where id_res = " + resid);

			rs.next();
			System.out.println("\nTitel: " + rs.getString(1) + ", Datum: " + rs.getString(2) + ", Saal: "
					+ rs.getString(3) + ", Reihe: " + rs.getString(4) + ", Sitz: " + rs.getString(5));

			System.out.println("");

			menu();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			menu();
		}

	}

	public void eingabe() {
		// Hier wird die Eingabe wiederholt, bis man eine Zahl eingegeben hat

		try {

			sc = new Scanner(System.in);
			eingabe = sc.nextInt();

		} catch (Exception e) {
			System.out.println("Bitte eine gültige Zahl eingeben: ");
			eingabe();
		}

	}

}
