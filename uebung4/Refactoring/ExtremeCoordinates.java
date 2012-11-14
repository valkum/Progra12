// kapselt Minima und Maxima in zwei Dimensionen
public class ExtremeCoordinates {
    public int maxX ;
    public int maxY ;
    public int minX ;
    public int minY ;
    // Initialisierung der Extremkoordinaten
    public static ExtremeCoordinates create () {
        ExtremeCoordinates res = new ExtremeCoordinates ();
        res . minX = 0;
        res . maxX = 0;
        res . minY = 0;
        res . maxY = 0;
        return res ;
    }
}