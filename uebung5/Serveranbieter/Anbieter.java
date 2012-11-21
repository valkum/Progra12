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

  public Anbieter(){
    anzahl++;
    this.id = anzahl;
  }

  public Kunde neuerKunde() {
    Kunde kunde = new Kunde(this);
    return kunde;
  }


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
    res = "(ANBIETER "+this.id+") Kontostand: "+this.kontostand+"\n";
    for (int i = 0; i < this.serverHalle.length; i++) {
      Server server = this.serverHalle[i];
      if (server != null) {
        res += "\nStellplatz " + i + " :" + server;
      }
    }
    return res;
  }
}
