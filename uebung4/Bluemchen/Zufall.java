import java.util.Random;
/**
 * Die Klasse Zufall bietet einige Methoden zur erzeugung von Zufallselementen  
 */
public class Zufall {
    /** 
     * Fuer die Erzeugung von Zufallswerten
     * intern verwendeter Zufallsgenerator
     */
    private static Random zufGen = new Random();

    /**
     * Erzeugt eine Zufallszahl aus dem
     * Wertebereich {1, ..., n}
     * @return Zufallszahl 
     */
    public static int zufallszahl(int n) {
        return zufGen.nextInt(n) + 1;
    }

    /**
     * Produziert einen Zufallswert aus dem
     * Wertebereich {'A', ..., c}
     * @return Zufallszeichen
     */
    public static char zufallszeichen(char c) {
        // Erzeugt eine passende Zufallszahl
        int zufallsInt = zufGen.nextInt(c - 'A' + 1);

        // Projiziert die Zufallszahl in den 
        // Wertebereich {'A', ..., c}
        return (char) (zufallsInt + 'A');
   }

}
