/**
 * Ein Objekt der Klasse Server repräsentiert einen Server, der einen gewissen
 * RAM-Ausbau und eine bestimmte Festplattenkapazität hat.
 */
public class Server {
  /**
   * Der RAM-Ausbau (in GByte) dieses Servers
   */
  private int ram;

  /**
   * Der Festplattenplatz (in TByte) dieses Servers
   */
  private int platz;

  /**
   * Legt einen neuen Server an
   * @param ram int Anzahl an GB an RAM
   * @param hdd int Anzahl an TB an Festplattenspeicherplatz
   */
  public Server(int ram, int hdd){
    this.ram = ram;
    this.platz = hdd;
  }
  /**
   * Gibt dem Server mehr RAM.
   * @param ram int Anzahl an GB an RAM
   */
  public void mehrRam(int ram){
    this.ram += ram;
  }
  /**
   * @return eine lesbare String-Darstellung dieses Servers. Diese enthält den
   * RAM-Ausbau und die Festplattenkapazität.
   */
  public String toString() {
    return "(SERVER) RAM: " + this.ram + " GByte, Festplattenplatz: " +
      this.platz + " TByte";
  }
}
