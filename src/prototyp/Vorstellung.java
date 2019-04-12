package prototyp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import java.text.SimpleDateFormat;

public class Vorstellung {
	public Kinosaal k = new Kinosaal();
	public Film f = new Film();
	public SimpleDateFormat time = new SimpleDateFormat("HH:mm");
	
	public Vorstellung() {
		
	}	
	
	
	public Kinosaal getK() {
		return k;
	}


	public void setK(Kinosaal k) {
		this.k = k;
	}


	public Film getF() {
		return f;
	}


	public void setF(Film f) {
		this.f = f;
	}


	public SimpleDateFormat getTime() {
		return time;
	}


	public void setTime(SimpleDateFormat time) {
		this.time = time;
	}
	
	public String toString() {
		return "Vorstellung: " + this.getF() + ", " + this.getK() + ", " + this.getTime() + "\n";
		
	}


	public Vorstellung(Kinosaal kinosaal, Film film, SimpleDateFormat time) {
		this.k = kinosaal;
		this.f = film;
		this.time = time;
	}
	
	
	
}
