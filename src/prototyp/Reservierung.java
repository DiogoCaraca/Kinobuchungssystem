package prototyp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Reservierung {
	public Platz p;
	public Besucher b;
	public Vorstellung v;
	
	public Vorstellung getVorstellung(int id) {
		return v;
	}
	
	public Reservierung() {
		
	}
	
	public Reservierung(Platz platz, Besucher besucher, Vorstellung vorstellung) {
		this.p = platz;
		this.b = besucher;
		this.v = vorstellung;
	}

	public Platz getP() {
		return p;
	}

	public void setP(Platz p) {
		this.p = p;
	}

	public Besucher getB() {
		return b;
	}

	public void setB(Besucher b) {
		this.b = b;
	}

	public Vorstellung getV() {
		return v;
	}

	public void setV(Vorstellung v) {
		this.v = v;
	}
	
	
	public String toString() {
		return "Reservierung: " + this.getB() + ", " + this.getV() + ", " + this.getP() + "\n";
	}
	
	
	
	
}
