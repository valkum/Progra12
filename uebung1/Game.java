public class Game {
  
	public static void main (String [] arguments) {

		int spieler1, spieler2, round;
		round = 1;
		spieler1 = 101;
		spieler2 = 101;
		// Spieler 1 eingabe
		System.out.print("Spieler 1, geben Sie eine Zahl zwischen 0 und 100 ein: ");
    	        spieler1 = Integer.parseInt(String.valueOf(System.console().readPassword()));
	        while(spieler1>100 || spieler1<0) {
	    	    System.out.println("Spieler 1, deine Zahl liegt nicht zwischen 0 und 100!");
	    	    System.out.print("Geben Sie eine Zahl zwischen 0 und 100 ein: ");
	    	    spieler1 = Integer.parseInt(String.valueOf(System.console().readPassword()));
		  }
		 //Spieler 2 eingabe
	   	System.out.println("Spieler 2, Sie sind am Zug!");
	  	while(spieler1 != spieler2) {
			System.out.print("Spieler 2, raten Sie die eingegebene Zahl: ");
	    	spieler2 = Integer.parseInt(System.console().readLine());
	    	if (spieler1 == spieler2) {
	    		System.out.println("Spieler 2, Sie haben die gesuchte Zahl in "+round+" Versuchen erraten.");
	    		break;
	    	}else if(spieler1 < spieler2) {
	    		System.out.println("Die gesuchte Zahl ist kleiner.");
	    	}else if(spieler1 > spieler2) {
	    		System.out.println("Die gesuchte Zahl ist größer.");
	    	}
	    	round++;
	    }
	}
}



