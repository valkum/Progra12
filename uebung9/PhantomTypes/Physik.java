public class Physik  {


	public static Wert<Sekunden> berechneFalldauer(Wert<Meter> h, Wert<Division<Meter, Multiplikation<Sekunden, Sekunden>>> g) {
		return new Wert<Sekunden>(Math.sqrt(2*h.getWert() / g.getWert()));
	}


	public static Wert<Meter> berechneStrecke(Wert<Division<Meter, Sekunden>> v, Wert<Sekunden> t) {
		return new Wert<Meter>(v.getWert() * t.getWert());
	}

	public static Wert<Meter> berechneAbwurfentfernung(Wert<Meter> h, Wert<Division<Meter, Sekunden>> v) {
			Wert<Division<Meter, Multiplikation<Sekunden, Sekunden>>> g = new Wert<Division<Meter, Multiplikation<Sekunden, Sekunden>>>(9.81d);
		 	Wert<Sekunden> falldauer = berechneFalldauer(h, g);
		 	Wert<Meter> strecke = berechneStrecke(v, falldauer);

		 	return strecke;

	}

	public static void main(String[] args) {
		System.out.println("Willkommen beim automatischen Abwurfberechner des Weihnachtsmannes.");
		System.out.println("-------------------------------------------------------------------");
		System.out.print("Bitte geben sie die Höhe ihres Schlittens ein: ");
		Wert<Meter> h = new Wert<Meter>(Integer.parseInt(System.console().readLine()));
		System.out.print("Bitte geben sie die Geschwindigkeit ihres Schlittens ein: ");
		Wert<Division<Meter, Sekunden>> v = new Wert<Division<Meter, Sekunden>>(Integer.parseInt(System.console().readLine()));

		System.out.println("Sie sollten die Geschenke " + berechneAbwurfentfernung(h, v).getWert() + "m vor dem Schornstein abwerfen.");
	}
}