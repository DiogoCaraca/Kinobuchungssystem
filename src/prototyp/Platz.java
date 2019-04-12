package prototyp;

public class Platz {
	public int platzId;
	public boolean reserviert;
	
	public Platz() {
		
	}
	
	public int getPlatzId() {
		return platzId;
	}

	public void setPlatzId(int platzId) {
		this.platzId = platzId;
	}

	public boolean isReserviert() {
		return reserviert;
	}

	public void setReserviert(boolean reserviert) {
		this.reserviert = reserviert;
	}

	public Platz(int platzId) {
		this.platzId = platzId;
		
	}
	
	public Platz(int platzId, boolean reserviert) {
		this.platzId = platzId;
		this.reserviert = reserviert;
		
	}
	
	
	public String toString() {
		return "Platz: " + this.getPlatzId() + ", " + this.isReserviert() + "\n";
	}
	
	
}
