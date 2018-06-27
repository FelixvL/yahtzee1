package yahtzeeHuiswerk;

import java.util.Random;

public class Dobbelsteen {
	static Random random = new Random();
	int face;
	boolean locked = false;
	
	int werpen() {
		if(!locked) {
			face = random.nextInt(6)+1;
		}
		return face;
	}
}
