package prototyp;

import java.util.Scanner;

public class Besucher {
	public Reservierung r = new Reservierung();
	Scanner sc = new Scanner(System.in);
	public Besucher()  {
		
	}
	
	public Besucher(Reservierung reservierung) {
		this.r = reservierung;
	}
	
	public void platzReservieren(Platz platz) {
		System.out.println("Mehrere Pl�tze reservieren (j/n): ");
		String eingabe = sc.next();
		
		if(eingabe.equals("j")) {
			//Liste Reihe
			System.out.println("Welche Reihe: ");
			//-----
			//Liste Pl�tze, der angewelten Reihe
			System.out.println("Wie viele Pl�tze: ");
			int anzahl = sc.nextInt();
			
		}else if(eingabe.equals("n")) {
			//Liste Pl�tze 
			System.out.println("Welchen Platz reservieren: ");
			int sitz = sc.nextInt();
			
		} else {
			platzReservieren(platz);
		}
	}
	
}
