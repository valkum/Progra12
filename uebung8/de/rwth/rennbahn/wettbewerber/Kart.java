package de.rwth.rennbahn.wettbewerber;

public class Kart extends Spritschlucker {

	public Kart (int ps) {
		super(ps, 3d);
	}


	public String toString() {
		return "Kart! Tank: "+this.getTankInhalt()+", Position: "+this.getPosition();
	}
}
