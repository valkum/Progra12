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


  public Server(int ram, int hdd){
    this.ram = ram;
    this.platz = hdd;
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
