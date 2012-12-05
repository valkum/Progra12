public class Polizist extends Buerger {
	
	Polizist(String name) {
		super(name);
	}


	public void aktion(Buerger[] einwohner) {
		System.out.println("Polizist " + this.getName() + " geht auf Verbrecherjagd!");
		for(int i = 0; i < einwohner.length; i++) { 
			Buerger buerger = einwohner[i];
			if (buerger instanceof Dieb && buerger.hatDiebesgut()) {
				System.out.println("Polizist " + this.getName() + " entlarvt Dieb " + buerger.getName());
				String name = buerger.getName();
				buerger = new Gefangener(name);
			}
		}
	}
}