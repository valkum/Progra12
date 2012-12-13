package de.rwth.rennbahn.wettbewerber;
import de.rwth.rennbahn.AusgeschiedenException;
abstract public class Wettbewerber {
	private int position;

	public int getPosition() {
		return this.position;
	}

	void weiter(int meter) {
		this.position += meter;
	}
	public abstract void weiter() throws AusgeschiedenException;
	public void istHinter(Wettbewerber x) {}
}