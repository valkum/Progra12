public class Herz {
	public static boolean inKreis(double px, double py, double cx, double cy, double r) {
		double dx = px - cx;
		double dy = py - cy;

		double d = Math.sqrt(dx*dx + dy*dy);

		return (d<=r);
	}
	public static boolean inRaute(double px, double py, double cx, double cy, double b) {
		double dx = Math.abs(cx-px);
		double dy = Math.abs(cy-py);
		return ((dx+dy) <= b);
	}

	public static boolean inHerz(double px, double py, double cx, double cy, double g) {
		double b=g / (1+(2/ Math.sqrt(2) ) );
		double r=b / Math.sqrt(2);
		

		return (inRaute(px, py, cx, cy, b) || inKreis(px, py, (cx-b/2), (cy-b/2),r ) || inKreis(px,py,(cx+b/2), (cy-b/2), r));
	}

	public static void main(String[] args) {
		System.out.println("Gib eine Breite ein: ");
		int b = Integer.parseInt(System.console().readLine());
		int c = b/2;
		for(int y=0;y*2<=b;y++) {
			for (int x=0; x<=b; x++){
				if(inHerz(x, y*2, c, c, b)){
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
