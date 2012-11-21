public class Kunde {
	

	private double kontostand = 1000;

	private Anbieter anbieter;
	private int stellplatz = -1;

	public Kunde(Anbieter anbieter) {
		this.anbieter = anbieter;
	}
	public double getKontostand() {
		return this.kontostand;
	}


	public String toString() {
	    String res = "";
	    res = "\n(Kunde) Kontostand: "+this.kontostand+"\n";
	    res += (this.stellplatz != -1) ? "Stellplatz: "+this.stellplatz+"\n": "";
	   	res += this.anbieter.toString();
	    return res;
	}
	public void bezahle(double preis) {
		this.kontostand -= preis;
	}

	public void neuerServer(int ram, int hdd) {
		this.stellplatz = this.anbieter.neuerServer(ram, hdd, this);
	}
}