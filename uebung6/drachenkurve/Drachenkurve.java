public class Drachenkurve {
	public static void kurveR(Staffelei s, int ordnung) {
	}

	public static void kurveL(Staffelei s, int ordnung) {
	}

	public static void main(String[] args) {
		Staffelei s = new Staffelei();
		s.rotate(180); // Rotiert die aktuelle Ausrichtung nach oben
		kurveR(s, 10);
	}
}
