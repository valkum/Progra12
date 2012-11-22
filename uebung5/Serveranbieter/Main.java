public class Main {
	
	public static void main(String[] args) {

		Anbieter a1 = new Anbieter();
		Anbieter a2 = new Anbieter();

		Kunde k1 = a1.neuerKunde();
		Kunde k2 = a1.neuerKunde();
		Kunde k3 = a2.neuerKunde();

		k1.neuerServer(8, 2);
		k2.neuerServer(16, 10);
		k3.neuerServer(192, 15);
		System.out.print(k1.toString());
		System.out.print(k2.toString());
		System.out.print(k3.toString());
		System.out.println();
		System.out.println("Aufgabe i)");
		k1.mehrRam(8);
		System.out.print(k1.toString());
	}
}