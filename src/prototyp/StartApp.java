package prototyp;

import java.util.Scanner;

public class StartApp {
		public int auswahl;
		public Scanner sc = new Scanner(System.in);
		
		public StartApp() {
			menu();
		}
	
		public void menu() {
			System.out.println("1) Vorstellung auswaehlen");
			System.out.println("2) Reservierung details");
			System.out.println("3) Besucher details");
			System.out.println("4) Kontoverwaltung");
			System.out.println("5) Konto erstellen");
			
			eingabe();
			
			switch(auswahl) {
			case 1:
				vorstellungAuswaehlen();
				break;
			case 2: 
				reservierungDetails();
				break;
			case 3: 
				besucherDetails();
				break;
			case 4:
				kontoVerwaltung();
				break;
			case 5:
				kontoErstellen();
				break;
			}
			
		}

		private void kontoVerwaltung() {
			// TODO Auto-generated method stub
			
		}

		private void besucherDetails() {
			// TODO Auto-generated method stub
			
		}

		private void reservierungDetails() {
			// TODO Auto-generated method stub
			
		}

		private void vorstellungAuswaehlen() {
			// TODO Auto-generated method stub
			
		}
		
		private void kontoErstellen() {
			// TODO Auto-generates method stub
		}

		public void eingabe() {
			// Hier wird die Eingabe wiederholt, bis man eine Zahl eingegeben hat

					try {
						
						sc = new Scanner(System.in);
						auswahl = sc.nextInt();

					} catch (Exception e) {
						System.out.println("Bitte eine gueltige Zahl eingeben: ");
						eingabe();
					}
			
		}
		
		
		
	
}
