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

  public String toString() {
    return Band.arrayToString(this.inhalt);
  }

  public Muell leere(){
    for(int i = 0; i < this.inhalt.length; i++){
      if(this.inhalt[i] != null){
        //System.out.println("leere folgendes: "+this.inhalt[i].toString());
        Muell temp = this.inhalt[i];
        this.inhalt[i] = null;
        return temp;
      }
    }
    return null;
  }
}
