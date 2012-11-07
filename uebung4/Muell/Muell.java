public class Muell {
  public Sorte sorte;
  public boolean sauber = false;

  public String toString() {
    String res = sorte.toString();
    if (sauber) {
      res += " (sauber)";
    }
    return res;
  }

  public static Muell fuerSorte(int sorte) {
    Muell muell = new Muell();
    muell.sorte = Sorte.values()[sorte];
    return muell;
  }

  public void reinige() {
    this.sauber = true;
  }
}
