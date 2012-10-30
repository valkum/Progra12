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

		return ((inRechteck(px, py, (cx-r-1), (cy-2*r),(cx+r+1),(cy)) && !(inKreis(px,py,(cx-r-1),(cy-r),r) || inKreis(px,py,(cx+r+1),(cy-r), r) ) ) || //in Rechteck aber nicht in den außeren kreisen
			inKreis(px, py, cx, (cy-(3.5*r)), r)	 || //Kreis mitte
			inKreis(px,py,(cx-r), (cy-(1.7*r)), r) ||  //kreis links
			inKreis(px,py, (cx+r),(cy-(1.7*r)), r)); //kreis rechts
	}

	public static void main(String[] args) {
		System.out.println("Giben Sie ihre Wunschhöhe ein: ");
		int h = Integer.parseInt(System.console().readLine());
		int cx = h/2+1;
		int cy = h;
		for(int y=0;y<=h;y=y+2) {
			for (int x=0; x<=h+2; x++){
				if(inKreuz(x, y, cx, cy, h)){
					System.out.print("@");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
			
		}
			double r = h/4;
			double Ax = cx;
									double Ay = cy-((3.4+Math.PI)*r);
			double Bx = cx-r;
			double By = cy-(1.7*r);
			double Cx = cx+r;
			double Cy = cy-(1.7*r);

			System.out.println("Kreis oben: x: " + Ax + " y: "+ Ay);
			System.out.println("Kreis links: x: " +Bx+" y: "+ By);
			System.out.println("Kreis rechts: x: " + Cx+" y: "+ Cy);
			

			double dx = Ax - Bx;
			double dy = Ay - By;
			System.out.println("AB = "+( Math.sqrt( dx*dx + dy*dy ) ) ) ;
			dx = Bx - Cx;
			dy = By - Cy;
			System.out.println("BC = "+( Math.sqrt( dx*dx + dy*dy ) ) ) ;
			dx = Cx - Ax;
			dy = Cy - Ay;
			System.out.println("CA = "+( Math.sqrt( dx*dx + dy*dy ) ) ) ;

	}
}
