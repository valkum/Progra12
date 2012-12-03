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
		for(int i = 0; i<5; i++){
			int j = Zufall.zahl(einwohner.length);
			Buerger target = einwohner[j];
			if(target instanceof ReicherBuerger) {
				int targetGeld = ((ReicherBuerger)target).getReichtum();
				int betrag = Zufall.zahl(targetGeld);
				((ReicherBuerger)target).setReichtum(targetGeld - betrag);
				this.diebesgut += betrag;
			}else if(target instanceof Polizist){
				break;
			}
		}
	}
}