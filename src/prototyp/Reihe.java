package prototyp;

import java.util.ArrayList;

public class Reihe {
	public int Id;
	ArrayList<Platz> plaetze = new ArrayList<Platz>();
	
	public void add(Platz platz) {
		
	}
	
	public boolean isNextPlatzFree(Platz platz) {
	
		return false;
		
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public ArrayList<Platz> getPlaetze() {
		return plaetze;
	}

	public void setPlaetze(ArrayList<Platz> plaetze) {
		this.plaetze = plaetze;
	}
	
	
}
