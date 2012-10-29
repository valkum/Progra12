public class Kreuz {
	public static boolean inKreis(double px, double py, double cx, double cy, double r) {
		double dx = px - cx;
		double dy = py - cy;

		double d = Math.sqrt(dx*dx + dy*dy);

		return (d<r);
	}
	public static boolean inRechteck(double px, 
									double py, 
									double ax, 
									double ay, 
									double bx,
									double by) 
	{
		return (px >= ax && py >= ay && px <= bx && py <= by);
	}
	public static boolean inKreuz(double px, double py, double cx, double cy, double h) {
		double r=h / 4;
		

		return ((inRechteck(px, py, (cx-r-1), (cy-2*r),(cx+r+1),(cy))&&
			!(inKreis(px,py,(cx-r-1),(cy-r),r) || inKreis(px,py,(cx+r+1),(cy-r), r) ) ) || 
			inKreis(px, py, cx, (cy-(3*r)), r) || //Kreis mitte
			inKreis(px,py,(cx-r), (cy-(2*r)), r) ||  //kreis links
			inKreis(px,py, (cx+r),(cy-(2*r)), r)); //kreis rechts
	}

	public static void main(String[] args) {
		System.out.println("Giben Sie ihre Wunschhöhe ein: ");
		int h = Integer.parseInt(System.console().readLine());
		int cx = h/2+1;
		int cy = h;
		for(int y=0;y*2<=h;y++) {
			for (int x=0; x<=h+2; x++){
				if(inKreuz(x, y*2, cx, cy, h)){
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
