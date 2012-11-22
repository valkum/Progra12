public class Kunde {
	

	private double kontostand = 1000;

	private Anbieter anbieter;
	private int stellplatz = -1;
	/**
	 * Legt einen neuen Kunden an.
	 */
	public Kunde(Anbieter anbieter) {
		this.anbieter = anbieter;
	}
	/**
	 * Gibt den Kontostand zurück.
	 * @return double Aktueller Kontostand
	 */
	public double getKontostand() {
		return this.kontostand;
	}
	/**
	 * Gibt dem Server des Kunden bei seinem Anbieter mehr ram.
	 * @param ram int Anzahl an GB an RAM
	 */
	public void mehrRam(int ram) {
		this.anbieter.mehrRam(ram, stellplatz, this);
	}
	/**
	 * @return eine String-Darstellung dieses Kunden, die den Stellplatz, die ID des Anbieters, der
   * Kontostand und eine Auflistung der Server enthält.
	 */
	public String toString() {
	    String res = "";
	    res = "\n\n(Kunde) Kontostand: "+this.kontostand+"\n";
	    res += (this.stellplatz != -1) ? "Stellplatz: "+this.stellplatz+"\n": "";
	   	res += this.anbieter.toString();
	    return res;
	}
	/**
	 * Zieht vom Kundenkonto den Preis ab
	 * @param preis double Wert der abgezogen werden soll
	 */
	public void bezahle(double preis) {
		this.kontostand = this.kontostand - preis;
	}

	/**
	 * Legt einen neuen Server beim Anbieter der Kunden an
	 * @param ram int Anzahl an GB an RAM
	 * @param hdd int Anzahl an TB an Festplattenspeicherplatz
	 */
	public void neuerServer(int ram, int hdd) {
		this.stellplatz = this.anbieter.neuerServer(ram, hdd, this);
	}
}