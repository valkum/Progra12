public class Quadrate {
	
	public static void main (String[] args) {
		Staffelei s = new Staffelei();
		maleFraktal(5, s, 200);
	}

	public static void maleFraktal(int n, Staffelei s, double l) {
		if(n >= 1){
			s.square(l);	

			if(n > 1){
				s.move(-l/2, -l/2);
				maleFraktal(n-1, s, l/2);
				s.move(0, l);
				maleFraktal(n-1, s, l/2);
				s.move(l, 0);
				maleFraktal(n-1, s, l/2);
				s.move(0, -l);
				maleFraktal(n-1, s, l/2);
				s.move(-l/2, l/2);
			}
		}
		return;
	}
}