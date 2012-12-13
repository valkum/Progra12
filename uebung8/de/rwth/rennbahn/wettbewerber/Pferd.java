package de.rwth.rennbahn.wettbewerber;

public class Pferd extends Wettbewerber implements ApplausEmpfindlich{
	private double gesundheit = 1.0d;

	public double getGesundheit() {
		return this.gesundheit;
	}
	public String toString() {
		return "Pferd! Gesundheit: "+(int)Math.floor((this.gesundheit * 100))+"%, Position: "+this.getPosition();
	}

	public void weiter() {
		if(this.gesundheit == 1.0d) {
			this.weiter(50);
		}else{
			this.weiter((int)(this.gesundheit * 50));
		}
		this.gesundheit = this.gesundheit * 1.03;
	}

	public void istHinter(Wettbewerber x) {
		if (x instanceof Spritschlucker && !((Spritschlucker)x).tankLeer()) {
			this.krank();
		}
	}
	void krank() {
		this.gesundheit = this.gesundheit * 0.8;
		if(this.gesundheit < 0.1d) {
			this.gesundheit = 0.1d;
		}

	}
	public void applaus(){
		this.krank();
	}
}