// repraesentiert einen Punkt im zweidimensionalen Raum
public class Point {

    public int x;
    public int y;

    // erzeugt einen Punkt mit den gegebenen Koordinaten
    public static Point create(int xNeu, int yNeu) {
        Point res = new Point();
        res.x = xNeu;
        res.y = yNeu;
        return res;
    }

    // berechnet die Determinante zwischen dem aktuellen und dem uebergebenen Punkt 
    // (die Punkte werden dabei als Vektoren interpretiert)
    public int determinant(Point p) {
        return this.x * p.y - this.y * p.x;
    }

    // testet, ob zwei Punkte gleich sind
    public boolean equals(Point p) {
        return p.x == this.x && p.y == this.y;
    }

    // berechnet die Norm des aktuellen Punktes (dies ist der Betrag des 
    // Vektors, der mit diesem Punkt identifiziert werden kann)
    public double norm() {
        return Math.hypot(this.x, this.y);
    }

    // berechnet das Skalarprodukt zwischen dem aktuellen und dem uebergebenen Punkt 
    // (die Punkte werden dabei als Vektoren interpretiert)
    public int scalarProduct(Point p) {
        return this.x * p.x + this.y * p.y;
    }

    // berechnet den Differenzvektor zwischen dem aktuellen und dem uebergebenen Punkt 
    // (die Punkte werden dabei als Vektoren interpretiert)
    public Point sub(Point p) {
        return Point.create(this.x - p.x, this.y - p.y);
    }

}
