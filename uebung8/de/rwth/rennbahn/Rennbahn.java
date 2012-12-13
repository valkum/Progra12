package de.rwth.rennbahn;

import de.rwth.rennbahn.wettbewerber.*;
import de.rwth.Zufall;

class Rennbahn {
	static Wettbewerber[] wettbewerber;
	static int distanz;
	public static void main(String[] args) {
		wettbewerber = new Wettbewerber[5];

		wettbewerber[0] = new Fahrradfahrer();
		wettbewerber[1] = new Pferd();
		wettbewerber[2] = new Auto(90);
		wettbewerber[3] = new Auto(285);
		wettbewerber[4] = new Kart(11);


		distanz = Zufall.zahl(2400)+100;

		System.out.println("Distanz: "+distanz);

		do{
			for(int i = 0;i<5;i++) {
				try {
					if(wettbewerber[i] != null)
					wettbewerber[i].weiter();	
				}catch(AusgeschiedenException e) {
					wettbewerber[i] = null;
				}
			}
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<5;j++) {
					if(wettbewerber[i] != null && wettbewerber[j] != null) {
						if(wettbewerber[i].getPosition() < wettbewerber[j].getPosition()) {
							wettbewerber[i].istHinter(wettbewerber[j]);
						}
					}
				}	
			}
			if(Zufall.zahl(100)+1<=10) {
				for(int i = 0;i<5;i++) {
					if(wettbewerber[i] != null) {
						if(wettbewerber[i] instanceof ApplausEmpfindlich){
							((ApplausEmpfindlich)wettbewerber[i]).applaus();
						}
					}
				}
			}
			status();
		}while(!fertig());
	}	

	static boolean fertig() {
		for(Wettbewerber w : wettbewerber) {
			if(w != null && w.getPosition() >= distanz){
				return true;
			}
		}
		return false;
	}

	static void status() {
		for(Wettbewerber w : wettbewerber) {
			if(w != null)
			System.out.println(w.toString());
		}
		System.out.println("-----------");
	}
}