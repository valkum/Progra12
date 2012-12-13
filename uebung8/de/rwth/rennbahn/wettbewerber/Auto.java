package de.rwth.rennbahn.wettbewerber;

public class Auto extends Spritschlucker {


	public Auto (int ps) {
		super(ps, ps/10);
	}

	public String toString() {
		return "Auto! Tank: "+this.getTankInhalt()+", Position: "+this.getPosition();
	}
}
