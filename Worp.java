package yahtzeeHuiswerk;

public class Worp {
	int[] uitslag;
	int beurt;
	Worp(int beurt, int[] uitslag){
		this.uitslag = uitslag;
		this.beurt = beurt;
	}

	void tonen() {
		System.out.println("De uitslag in beurt " + beurt + " was: ");
		for(int x = 0 ; x < uitslag.length ; x ++) {
			System.out.print(uitslag[x] + " - - ");
		}
		System.out.println("");
	}
}
