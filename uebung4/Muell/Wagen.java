public class Wagen {
  public Muell[] inhalt;

  public static Wagen zufallsWagen() {
    java.util.Random random = new java.util.Random();
    Wagen res = new Wagen();
    res.inhalt = new Muell[Fabrik.anzahl];
    for (int i = 0; i < res.inhalt.length; i++) {
      int sorte = random.nextInt(3);
      Muell muell = Muell.fuerSorte(sorte);
      res.inhalt[i] = muell;
    }
    return res;
  }
}
