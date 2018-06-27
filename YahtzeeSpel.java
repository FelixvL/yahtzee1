package yahtzeeHuiswerk;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
	Speler actieveSpeler;
	Speler[] spelers;
	
	int[] blockArray = new int[5]; // DOUBLE
	int ronde;
	YahtzeeSpel(){
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
	}
	void spelersAanmaken() {
		System.out.println("Hoeveel spelers willen meespelen");
		String aantalSpelersString = scanner.nextLine();
		int aantalSpelers = Integer.parseInt(aantalSpelersString);
		spelers = new Speler[aantalSpelers];
		for(int x = 0 ; x < aantalSpelers; x++) {
			System.out.println("Wat is de naam van speler " +(x+1));
			String spelernaam = scanner.nextLine();
			spelers[x] = new Speler(spelernaam, x);
		}
		actieveSpeler = spelers[0];
	}
	void spelen() {
		spelersAanmaken();
		System.out.println("spelen");
		boolean speelDoor = true;
		while(speelDoor) {
			System.out.println("Wilt u doorspelen? y voor ja, q voor quit");
			String input = scanner.nextLine();
			switch(input) {
				case "q":
					speelDoor = false;
					break;
				case "y":
					nieuweWorp();
					break;
				default:
					System.out.println("ongeldige invoer");
			}
		}
		toonGeschiedenis();
		System.out.println("Bedankt voor het spelen");
	}
	void toonGeschiedenis() {
		for(Speler speler : spelers) {
			System.out.println("De geschiedenis van " + speler.naam + " is:");
			for(Worp w : speler.worpen) {
				w.tonen();
			}
		}
	}
	void nieuweWorp() {
		System.out.println("Aan de beurt is: " + actieveSpeler.naam);
		werpenEnPrinten(1);
		vasthouden();
		werpenEnPrinten(2);
		resetten();
	}
	void resetten() {
		worpOpslaan(actieveSpeler);
		ronde++;
		for(int x = 0; x < blockArray.length; x++) {blockArray[x]=0;} // DOUBLE
		for(Dobbelsteen db : dobbelstenen) {
			db.locked = false;
		}
		volgendeSpeler();
	}
	void volgendeSpeler() {
		int volgende = actieveSpeler.beurtnummer + 1;
		if(volgende >= spelers.length) {
			volgende = 0;
		}
		actieveSpeler = spelers[volgende];
	}
	void worpOpslaan(Speler speler) {
		speler.worpen.add(
				new Worp(ronde, new int[] {
						dobbelstenen.get(0).face,
						dobbelstenen.get(1).face,
						dobbelstenen.get(2).face,
						dobbelstenen.get(3).face,
						dobbelstenen.get(4).face}
				)
		);
	}
	void vasthouden() {
		System.out.println("Welke dobbelstenen wil je vasthouden? bijv 125 of 34 of 145");
		String vasthouden = scanner.nextLine();
		System.out.println("vastgehouden" + vasthouden);
		int aantal = vasthouden.length();
		for(int x = 0 ; x < aantal ; x++) {
			String index = vasthouden.substring(x, x+1);
			int indexInt = Integer.parseInt(index);
//			dobbelstenen.get(indexInt - 1).locked = true;  // RELEVANT VOOR DUBBELCHECK
			blockArray[indexInt - 1] = 1;   // DOUBLE
		}
	}
	void werpenEnPrinten(int beurt) {
		System.out.println("");
		System.out.println("WORP"+beurt);
		System.out.println("-1---2---3---4---5-");
		int counter = 0;
		for(Dobbelsteen db : dobbelstenen) {
			if(blockArray[counter] == 0) {  // DOUBLE
				db.werpen();
			}								// DOUBLE
			System.out.print(" "+db.face+"  ");
			counter++;						// DOUBLE
		}
		System.out.println("");
		System.out.println("");
	}
}
