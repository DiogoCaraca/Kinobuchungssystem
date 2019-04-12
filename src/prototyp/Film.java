package prototyp;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Film {
	public ArrayList<Film> film = new ArrayList<Film>();
	public int id;
	public String titel;
	public String dauer;
	
	public ArrayList<Film> getFilm() {
		return film;
	}

	public void setFilm(ArrayList<Film> film) {
		this.film = film;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getDauer() {
		return dauer;
	}

	public void setDauer(String dauer) {
		this.dauer = dauer;
	}

	public Film() {
		
	}
	
	public Film(int id, String titel, String dauer) {
		this.id = id;
		this.titel = titel;
		this.dauer = dauer;
	}
	
	public String toString() {
		return "Film: " + this.getId() + ", " + this.getTitel() + ", " + this.getDauer() + "\n";
	}
	
	
	
}
