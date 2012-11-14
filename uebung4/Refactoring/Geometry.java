public class Geometry {

    // Eingabe der Punkte des Polygons und Bestimmung der Extremkoordinaten
    public static ExtremeCoordinates input ( Point [] polygon ) {
        ExtremeCoordinates res = ExtremeCoordinates.create ();
        for (int i = 0; i < polygon . length ; i ++) {
            // Einlesen eines Punktes
            System .out.println (" Geben Sie die X- Koordinate des " + (i + 1) + "-ten Punktes ein .");
            int x = readInt();
            System .out.println (" Geben Sie die Y- Koordinate des " + (i + 1) + "-ten Punktes ein .");
            int y = readInt();
            polygon [i] = Point . create (x, y);
            // Update der Extremkoordinaten
            res . minX = Math . min( res.minX , polygon [i].x);
            res . minY = Math . min( res.minY , polygon [i].y);
            res . maxX = Math . max( res.maxX , polygon [i].x);
            res . maxY = Math . max( res.maxY , polygon [i].y);
        }
        return res ;
    }
    // Liest ein Polygon ein und gibt es auf der Konsole aus
    public static void main(String[] args) {
        // Eingabe der Anzahl Punkte , welche das Polygon bestimmen , und Anlegen des zugehoerigen Arrays
        System.out.println (" Geben Sie die Anzahl an Punkten ein , welche das Polygon bestimmen sollen .");
        Point [] polygon = new Point [ Integer . parseInt ( System . console (). readLine ())];
        Geometry.output ( Geometry . input ( polygon ), polygon );
    }

    // Ausgabe des Polygons auf der Konsole
    public static void output(ExtremeCoordinates ex, Point[] polygon){ 
        System.out.println();
        for (int i = ex.maxY; i >= ex.minY; i--) {
            for (int j = ex.minX; j <= ex.maxX; j++) {
                Point p = Point.create(j, i);
                System.out.print((inPolygon(polygon, p)) ? "#" : " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int readInt() {
        return Integer.parseInt(System.console().readLine());
    }

    // Test, ob Punkt in Polygon liegt
    public static boolean inPolygon(Point[] polygon, Point p){
        double sum = 0.0;
        for (int k = 0; k < polygon.length; k++) {
            
            double angle = winkel(polygon, polygon[k].sub(p), polygon[(k + 1) % polygon.length].sub(p));
            // Sonderfall: Punkt liegt auf einer Ecke oder Kante des Polygons
            if (p.equals(polygon[k]) || angle == 180) {
                //Ist der Sonderfall eingetreten, so liegt der Punkt innerhalb des Polygons
                return true;
            }
            // Aufsummierung der Winkel
            sum = sum + angle;
        }
        // Ist Betrag der Winkelsumme 360 (Rundung zur Steigerung der Robustheit gegenueber 
        // Rundungsfehlern), so liegt der Punkt innerhalb des Polygons
        return (Math.abs(Math.round(sum)) == 360);
    }
    // Berechnung des Winkels zwischen den Punkten polygon[i], p und 
    // polygon[i + 1 % polygon.length]
    // Ergebnis liegt zwischen -179 und 180 (positive Werte zeigen einen Winkel gegen den 
    // Uhrzeigersinn an)
    public static double winkel(Point[] polygon, Point v1, Point v2){
            float signum = Math.signum(v1.determinant(v2));
            double angle = Math.toDegrees(Math.acos((v1.scalarProduct(v2)) / (v1.norm() * v2.norm())));
            return signum == 0 ? Math.round(angle) : signum * angle;
    }

}
