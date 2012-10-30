public class Main {
  public static void main(String[] args) {
    Pilz steinpilz = new Pilz(); // TODO a.1)
	steinpilz.gewicht = 100;
	steinpilz.name = "Steinpilz";

    Pilz champignon = new Pilz(); // TODO a.1)
	champignon.gewicht = 200;
	champignon.name = "Champignon";

    Pilz pfifferling = new Pilz(); // TODO a.1)
	pfifferling.gewicht = 150;
	pfifferling.name = "Pfifferling";

    Mensch bonnie = new Mensch(); // TODO a.2)
	bonnie.name = "Bonnie";
	bonnie.maxGewicht = 400;
	bonnie.korb = new Pilz[3];

    Mensch clyde = new Mensch();// TODO a.2)
	clyde.name = "Clyde";
	clyde.maxGewicht = 500;
	clyde.korb = new Pilz[4];

    Pilz[] wald = new Pilz[] {steinpilz, champignon, champignon, pfifferling,
      steinpilz, pfifferling, champignon};

    //TODO c)
    for(Pilz p : wald) {
    	if(bonnie.hatPlatz() && bonnie.gewichtOK(p.gewicht)) {
			bonnie.anzahl++;
			bonnie.korb[bonnie.anzahl-1] = p;
    	}else if(clyde.hatPlatz() && clyde.gewichtOK(p.gewicht)) {
    		clyde.anzahl++;
    		clyde.korb[clyde.anzahl-1] = p;
    	}
    	bonnie.ausgabe();
    	clyde.ausgabe();
		System.out.println("----------");
    }
  }
}
