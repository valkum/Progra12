package de.rwth.rennbahn.wettbewerber;

import de.rwth.rennbahn.AusgeschiedenException;
abstract public class Spritschlucker extends Wettbewerber {
	protected double tankInhalt = 100d;

	protected int ps;
	protected double verbrauch;

	public Spritschlucker(int ps, double verbrauch) {
		this.ps = ps;
		this.verbrauch = verbrauch;
	}

	public double getTankInhalt() {
		return this.tankInhalt;
	}
	protected boolean tankLeer() {
		return (tankInhalt == 0d) ? true : false;
	}

	public void weiter() throws AusgeschiedenException{
		if(this.tankInhalt >= this.verbrauch) {
			this.tankInhalt -= this.verbrauch;
			this.weiter(this.ps);
		}else{
			throw new AusgeschiedenException();
		}
	}
}
