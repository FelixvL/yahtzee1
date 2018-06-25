package yahtzeeHuiswerk;

import java.util.Random;
import java.util.Scanner;

public class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
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
					System.out.println(werpen());
					break;
				default:
					System.out.println("ongeldige invoer");
			}
		}
		System.out.println("Bedankt voor het spelen");
	}
	int werpen() {
		return random.nextInt(6)+1;
	}
}
