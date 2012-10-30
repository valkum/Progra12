public class Mensch {
  String name;
  Pilz[] korb;
  int anzahl = 0;
  int maxGewicht;


  public boolean hatPlatz() {

  	return (anzahl < korb.length);
  }

  public int gewicht() {
  	int gesGewicht = 0;

  	for(int i = 0;i < anzahl; i++){
  		if (korb[i] != null) {
  			gesGewicht = gesGewicht + korb[i].gewicht;
		}
  	}
  	return gesGewicht;
  }

  public boolean gewichtOK(int zusatzGewicht) {
  	return ((gewicht() + zusatzGewicht) <= maxGewicht);
  }

  public void ausgabe() {
  	System.out.println(name + ":");
  	 for (int i = 0; i < anzahl; i++) {
      System.out.println(korb[i].name);
    }
    System.out.println("Platz: "+anzahl + "/" + korb.length);
  }
}
