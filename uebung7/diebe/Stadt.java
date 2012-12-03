public class Stadt {
	private Buerger[] einwohner;

	Stadt(int einwohnerzahl) {
		int buerger = 0;
		int diebe = 0;
		int polizisten = 0;
		int reicheBuerger = 0;
		int gefangene = 0;

		for(int i = 0; i<einwohnerzahl; i++) {
			int type = Zufall.zahl(5);
			System.out.println(Zufall.name());
			if( type == 0 && (buerger/einwohnerzahl) < 0.2) {
				this.einwohner[i] = new Buerger(Zufall.name());
				buerger++;
			}else if(type == 1 && (diebe/einwohnerzahl) < 0.2) {
				this.einwohner[i] = new Dieb(Zufall.name());
				diebe++;
			}else if(type == 2 && (reicheBuerger/einwohnerzahl < 0.2) ) {
				this.einwohner[i] = new ReicherBuerger(Zufall.name(), Zufall.zahl(1000));
				reicheBuerger++;
			}else if( type == 3 && (polizisten/einwohnerzahl) < 0.2) {
				this.einwohner[i] = new Polizist(Zufall.name());
				polizisten++;
			}else if(type == 3 && (polizisten/einwohnerzahl) < 0.2) {
				this.einwohner[i] = new Gefangener(Zufall.name());
				gefangene++;

			}
		}

	}
	public static void main(String[] args) {
		Stadt stadt = new Stadt(10);

		for (int i = 0; i<10; i++){
			int zufall = Zufall.zahl(stadt.einwohner.length);
			stadt.einwohner[zufall].aktion(stadt.einwohner);
		}
	}

}