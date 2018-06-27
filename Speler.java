package yahtzeeHuiswerk;

import java.util.ArrayList;

public class Speler {
	ArrayList<Worp> worpen = new ArrayList();
	String naam;
	int beurtnummer;
	
	Speler(String naam, int beurtnummer){
		this.naam = naam;
		this.beurtnummer = beurtnummer;
	}
}
