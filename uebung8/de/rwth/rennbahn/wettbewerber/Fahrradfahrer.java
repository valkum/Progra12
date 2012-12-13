package de.rwth.rennbahn.wettbewerber;

public class Fahrradfahrer extends Wettbewerber implements ApplausEmpfindlich {
	private int motivationsbonus = 0;

	public String toString() {
		return "Fahrradfahrer! Motivationsbonus: "+this.motivationsbonus+", Position: "+this.getPosition();
	}


	public void weiter() {
		this.weiter(7);
		for(int i = 1; i<= this.motivationsbonus; i++) {
			this.weiter(7);
		}
	}

	public void istHinter() {
		this.motivationsbonus++;
	}

	public void applaus(){
		this.motivationsbonus++;
	}
}
