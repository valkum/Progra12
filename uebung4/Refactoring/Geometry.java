public class Geometry {

    // Liest ein Polygon ein und gibt es auf der Konsole aus
    public static void main(String[] args) {
        // Eingabe der Anzahl Punkte, welche das Polygon bestimmen, und Anlegen des zugehoerigen Arrays
        System.out.println("Geben Sie die Anzahl an Punkten ein, welche das Polygon bestimmen sollen.");
        Point[] polygon = new Point[Integer.parseInt(System.console().readLine())];
        // Eingabe der Punkte des Polygons und Bestimmung der Extremkoordinaten
        // Initialisierung der Extremkoordinaten
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        for (int i = 0; i < polygon.length; i++) {
            // Einlesen eines Punktes
            System.out.println("Geben Sie die X-Koordinate des " + (i + 1) + "-ten Punktes ein.");
            int x = Integer.parseInt(System.console().readLine());
            System.out.println("Geben Sie die Y-Koordinate des " + (i + 1) + "-ten Punktes ein.");
            int y = Integer.parseInt(System.console().readLine());
            polygon[i] = Point.create(x, y);
            // Update der Extremkoordinaten
            minX = Math.min(minX, polygon[i].x);
            minY = Math.min(minY, polygon[i].y);
            maxX = Math.max(maxX, polygon[i].x);
            maxY = Math.max(maxY, polygon[i].y);
        }
        // Ausgabe des Polygons auf der Konsole
        System.out.println();
        for (int i = maxY; i >= minY; i--) {
            for (int j = minX; j <= maxX; j++) {
                Point p = Point.create(j, i);
                // Test, ob Punkt in Polygon liegt
                boolean in = false;
                double sum = 0.0;
                for (int k = 0; k < polygon.length; k++) {
                    // Berechnung des Winkels zwischen den Punkten polygon[i], p und 
                    // polygon[i + 1 % polygon.length]
                    // Ergebnis liegt zwischen -179 und 180 (positive Werte zeigen einen Winkel gegen den 
                    // Uhrzeigersinn an)
                    Point v1 = polygon[k].sub(p);
                    Point v2 = polygon[(k + 1) % polygon.length].sub(p);
                    float signum = Math.signum(v1.determinant(v2));
                    double angle = 
                        Math.toDegrees(Math.acos((v1.scalarProduct(v2)) / (v1.norm() * v2.norm())));
                    angle = signum == 0 ? Math.round(angle) : signum * angle;
                    // Sonderfall: Punkt liegt auf einer Ecke oder Kante des Polygons
                    if (p.equals(polygon[k]) || angle == 180) {
                        in = true;
                        break;
                    }
                    // Aufsummierung der Winkel
                    sum = sum + angle;
                }
                // Ist Betrag der Winkelsumme 360 (Rundung zur Steigerung der Robustheit gegenueber 
                // Rundungsfehlern) oder ist der Sonderfall eingetreten, so liegt der Punkt innerhalb des 
                // Polygons
                System.out.print((in || Math.abs(Math.round(sum)) == 360) ? "#" : " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
