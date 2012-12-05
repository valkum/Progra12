public class Buerger {
	private String name;

	Buerger (String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	public boolean hatDiebesgut() {
		return false;
	}
	public void aktion (Buerger[] einwohner) {
		System.out.println("Buerger " + this.getName() + " geht spazieren!");
	}

	public String toString(){
		return this.getName();
	}
}