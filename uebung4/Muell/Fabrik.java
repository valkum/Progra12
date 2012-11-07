public class Fabrik {

  public static int anzahl = 10;

  public static Band bandEins;
  public static Band bandZwei;

  public static void main(String[] args) {
    Wagen wagen = Wagen.zufallsWagen();
    bandEins = new Band();
    bandZwei = new Band();
    bandEins.inhalt = new Muell[anzahl/2];
    bandZwei.inhalt = new Muell[anzahl/2];

    // TODO
  }
}
