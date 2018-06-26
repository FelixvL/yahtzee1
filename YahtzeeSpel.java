package yahtzeeHuiswerk;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();

	YahtzeeSpel(){
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
		dobbelstenen.add(new Dobbelsteen());
	}
	
	void spelen() {
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
		System.out.println("Bedankt voor het spelen");
	}
	void nieuweWorp() {
		werpenEnPrinten(1);
		vasthouden();
		werpenEnPrinten(2);
		resetten();
	}
	void resetten() {
		for(Dobbelsteen db : dobbelstenen) {
			db.locked = false;
		}
	}
	void vasthouden() {
		System.out.println("Welke dobbelstenen wil je vasthouden? bijv 125 of 34 of 145");
		String vasthouden = scanner.nextLine();
		System.out.println("vastgehouden" + vasthouden);
		int aantal = vasthouden.length();
		for(int x = 0 ; x < aantal ; x++) {
			String index = vasthouden.substring(x, x+1);
			int indexInt = Integer.parseInt(index);
			dobbelstenen.get(indexInt - 1).locked = true;
		}
	}
	void werpenEnPrinten(int beurt) {
		System.out.println("");
		System.out.println("WORP"+beurt);
		System.out.println("-1---2---3---4---5-");
		for(Dobbelsteen db : dobbelstenen) {
			db.werpen();
			System.out.print(" "+db.face+"  ");
		}
		System.out.println("");
		System.out.println("");
	}
}
