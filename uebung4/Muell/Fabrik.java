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

    int i = 0;
    Muell m = wagen.leere();
    System.out.println("Wagen: " + wagen.toString());
    System.out.println("Band 1: " + bandEins.toString());
    System.out.println("Band 2: " + bandZwei.toString());
    do{
      System.out.println("Wagen: " + wagen.toString());
      if((i % 2)==0){
        bandEins.drauf(m);
      }else{
        bandZwei.drauf(m);
      }
      System.out.println("Band 1: " + bandEins.toString());
      System.out.println("Band 2: " + bandZwei.toString());
      i++;
      m = wagen.leere();
    }while(m != null);
    System.out.println("Reinige ...");
    Fabrik.bearbeite(bandZwei.inhalt);
    System.out.println("Band 2: " + bandZwei.toString());
  }

  public static void bearbeite(Muell[] muell){
    for(int i = 0; i < muell.length; i++){
      if(muell[i] != null){
        switch (muell[i].sorte){

          case Metall:
            muell[i] = null;
          break;
          case Plastik:
            muell[i].reinige();
          break;
        }
      }
    }
  }
}
