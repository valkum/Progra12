public class Dieb extends Buerger {
	
	private int diebesgut;
	Dieb(String name) {
		super(name);
		this.diebesgut = 0;
	}

	public boolean hatDiebesgut() {
		return (this.diebesgut < 0);
	}

	public void aktion(Buerger[] einwohner) {
		System.out.println("Dieb " + this.getName() + " sucht nach Diebesgut!");
		for(int i = 0; i<5; i++){
			int j = Zufall.zahl(einwohner.length);
			Buerger target = einwohner[j];
			if(target instanceof ReicherBuerger) {
				int targetGeld = ((ReicherBuerger)target).getReichtum();
				int betrag = Zufall.zahl(targetGeld);
				((ReicherBuerger)target).setReichtum(targetGeld - betrag);
				this.diebesgut += betrag;
				System.out.println("Dieb " + this.getName() + " klaut " + target.getName() + " " + betrag + " Euro!");
			}else if(target instanceof Polizist){
				System.out.println("Dieb " + this.getName() + " bricht die Suche ab!");
				break;
			}
		}
	}
}