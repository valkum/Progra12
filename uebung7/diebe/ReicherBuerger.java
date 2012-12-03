public class ReicherBuerger extends Buerger {
	
	private int reichtum;
	
	ReicherBuerger(String name, int reichtum) {
		super(name);
		this.reichtum = reichtum;
	}

	public int getReichtum() {
		return this.reichtum;
	}
	public void setReichtum(int reichtum) {
		this.reichtum = reichtum;
	}

	public void aktion(Buerger[] einwohner) {
		int reichtum = this.getReichtum();
		int ausgaben = Zufall.zahl(reichtum);
		this.setReichtum(reichtum - ausgaben);
		System.out.println("Reicher Bürger " + this.getName() + "besticht einen Politiker mit " + ausgaben + "Euro!");
	}
}