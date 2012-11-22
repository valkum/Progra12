/**
 * Objekte der Klasse Anbieter repräsentieren Anbieter von Servern.
 *
 * Jeder Anbieter hat einzelne Server, die im Auftrag von Kunden betrieben
 * werden. Weiterhin hat jeder Anbieter ein eigenes Konto, dessen Kontostand in
 * den Objekten gespeichert ist.
 */
public class Anbieter {
  /**
   * Die Server dieses Anbieters.
   */
  private Server[] serverHalle = new Server[100];

  /**
   * Anzahl der schon vergebenen IDs
   */
  private static int anzahl = 0;

  /**
   * ID des Anbieters
   */
  private int id;
  /**
   * Der Kontostand des dieses Anbieters.
   */
  private double kontostand = 0;
 /**
   * Erzeugt einen neuen Anbieter
   */
  public Anbieter(){
    anzahl++;
    this.id = anzahl;
  }
  /**
   * Erzeugt einen neuen Kunden dieses Anbieters
   * @return Kunde der neue Kunde
   */
  public Kunde neuerKunde() {
    Kunde kunde = new Kunde(this);
    return kunde;
  }
  /**
   * Erhöht das Speicher im angegebenen Server
   * @param ram int Anzahl an GB RAM
   * @param stellplatz int Stellplatz des Servers der mehr RAM bekommen soll.
   * @param kunde Kunde Der Kunde der den Server haben will.
   */
  public void mehrRam(int ram, int stellplatz, Kunde kunde) {
    if(this.serverHalle[stellplatz] != null) {
      double preis = 5*ram;
      if(this.bezahle(preis, kunde)){
        this.serverHalle[stellplatz].mehrRam(ram);
      }
    }
  }
 /**
   * Legt einen neuen Server an
   * @param ram int Anzahl an GB RAM
   * @param hdd int Anzahl an TB Festplattenspeicher
   * @param kunde Kunde Der Kunde der den Server haben will.
   * @return int Der stellplatz wenn der Server erfolgreich angelegt wurde sonst -1
   */
  public int neuerServer(int ram, int hdd, Kunde kunde) {
    for(int i= 0;i < this.serverHalle.length;i++) {
      if(this.serverHalle[i] == null){
        double preis = 5*ram+2*hdd;
        if(this.bezahle(preis, kunde)){
          this.serverHalle[i] = new Server(ram, hdd);
          return i;
        }
      }
    }
    return -1;
  }
  /**
   * Lässt den Kunden bezahlen
   * @param preis double Der Preis den der Kunde Zahlen muss.
   * @param kunde Kunde Der Kunde der bezahlen soll.
   * @return boolean true wenn preis erfolgreich abgehoben wurde von kunde
   */
  private boolean bezahle(double preis, Kunde kunde) {
    if(kunde.getKontostand() >= preis){
      kunde.bezahle(preis);
      this.kontostand += preis;
      return true;
    }
    return false;
  }
  /**
   * @return eine String-Darstellung dieses Anbieters, die die ID, der
   * Kontostand und eine Auflistung der Server enthält.
   */
  public String toString() {
    String res = "";
    res = "(ANBIETER "+this.id+") Kontostand: "+this.kontostand;
    for (int i = 0; i < this.serverHalle.length; i++) {
      Server server = this.serverHalle[i];
      if (server != null) {
        res += "\nStellplatz " + i + " :" + server;
      }
    }
    return res;
  }
}
