package yahtzeeHuiswerk;

import java.util.Scanner;

public class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	
	void spelen() {
		System.out.println("spelen");
		boolean speelDoor = true;
		while(speelDoor) {
			System.out.println("Wilt u doorspelen? y voor ja, q voor quit");
			String input = scanner.nextLine();
			switch(input) {
				case "q":
					speelDoor = false;
			}
		}
		System.out.println("Bedankt voor het spelen");
	}
}
