public class Schiffe {

    // Laenge des laengsten Schiffs im Spiel
    public static int biggestShip = 5;

    // Fehlermeldung bei Kollision
    public static String fehlerKollision =
        "Ungueltige Eingabe! Das Schiff kollidiert mit einem bereits "
        + "vorhandenen Schiff!";

    // Fehlermeldung bei Schiffeintragung ausserhalb des Spielfeldes
    public static String fehlerPasstNicht = 
        "Ungueltige Eingabe! Das Schiff passt nicht ins Spielfeld!";

    // Seitenlaenge des quadratischen Spielfeldes
    public static int fieldsize = 10;

    // Laenge des kuerzesten Schiffs im Spiel
    public static int smallestShip = 2;

    // Gibt das Spielfeld aus.
    public static void ausgabe(
        boolean[][] schiffe,
        boolean[][] schuesse,
        boolean schiffeSichtbar)
    {
        // Tutoraufgabe
    }

    // Prueft, ob alle Schiffe versenkt wurden.
    public static boolean gewonnen(
        boolean[][] schiffe,
        boolean[][] schuesse)
    {
        // Tutoraufgabe
        return true;
    }

    // Gibt eine Zeile mit length + 1 vielen "-+"-en aus.
    public static void linie(int length) {
        for (int i = 0; i <= length; i++) {
            System.out.print("-+");
        }
        System.out.println();
    }

    // Fuehrt das Programm aus.
    public static void main(String[] args) {
        int feld;
        do {
            System.out.print(
                "Geben Sie die Groesse des Spielfelds ein "
                + "(zwischen 10 und 26): "
            );
            feld = Integer.parseInt(System.console().readLine());
        } while (feld < 10 || feld > 26);
        int big;
        do {
            System.out.print(
                "Geben Sie die Laenge des laengsten Schiffes ein "
                + "(zwischen 1 und "
                + (feld / 2)
                + "): "
            );
            big = Integer.parseInt(System.console().readLine());
        } while (big < 1 || big > feld / 2);
        int small;
        do {
            System.out.print(
                "Geben Sie die Laenge des kuerzesten Schiffes ein "
                + "(zwischen 1 und "
                + big
                + "): "
            );
            small = Integer.parseInt(System.console().readLine());
        } while (small < 1 || small > big);
        Schiffe.fieldsize = feld;
        Schiffe.biggestShip = big;
        Schiffe.smallestShip = small;
        // werden alle mit false initialisiert
        boolean[][] schiffe1 = 
            new boolean[Schiffe.fieldsize][Schiffe.fieldsize];
        boolean[][] schiffe2 = 
            new boolean[Schiffe.fieldsize][Schiffe.fieldsize];
        boolean[][] schuesse1 = 
            new boolean[Schiffe.fieldsize][Schiffe.fieldsize];
        boolean[][] schuesse2 = 
            new boolean[Schiffe.fieldsize][Schiffe.fieldsize];
        // Fuer Hausaufgabe ersetzen durch
        // Schiffe.schiffeEintragen(schiffe1, schuesse1);
        SchiffeSecret.schiffeEintragen(schiffe1);
        SchiffeSecret.schiffeEintragen(schiffe2);
        boolean gewonnen;
        do {
            Schiffe.ausgabe(schiffe1, schuesse1, true);
            Schiffe.ausgabe(schiffe2, schuesse2, false);
            // Fuer Hausaufgabe ersetzen durch
            // Schiffe.schussEingeben(schiffe2, schuesse2);
            SchiffeSecret.schussEingeben(schiffe2, schuesse2);
            gewonnen = Schiffe.gewonnen(schiffe2, schuesse2);
            if (gewonnen) {
                Schiffe.ausgabe(schiffe1, schuesse1, true);
                Schiffe.ausgabe(schiffe2, schuesse2, false);
                System.out.println("Spieler 1 hat gewonnen!");
            } else {
                SchiffeSecret.schussEingeben(schiffe1, schuesse1);
                gewonnen = Schiffe.gewonnen(schiffe1, schuesse1);
                if (gewonnen) {
                    Schiffe.ausgabe(schiffe1, schuesse1, true);
                    Schiffe.ausgabe(schiffe2, schuesse2, false);
                    System.out.println("Spieler 2 hat gewonnen!");
                }
            }
        } while (!gewonnen);
    }

    // Gibt die Anzahl Kaestchen zurueck, auf die noch nicht geschossen 
    // wurde.
    public static int nochFrei(boolean[][] schuesse) {
        // Hausaufgabe
        return Schiffe.fieldsize * Schiffe.fieldsize;
    }

    // Fordert den Benutzer zur Eingabe von Koordinaten und Ausrichtung 
    // der Schiffe auf, liest diese ein und traegt schliesslich die 
    // Schiffe ins Spielfeld ein. Dabei wird kontrolliert, ob die 
    // eingegebene Positionierung gueltig ist und im Falle einer 
    // ungueltigen Positionierung wird die Eingabeaufforderung wiederholt.
    public static void schiffeEintragen(
        boolean[][] schiffe,
        boolean[][] schuesse)
    {
        int zeile;
        int spalte;
        char ausrichtung;
        for (int i = Schiffe.biggestShip; i >= Schiffe.smallestShip; i--) {
            do {
                Schiffe.ausgabe(schiffe, schuesse, true);
                System.out.println(
                    "Geben Sie die oberen linken Koordinaten des Schiffs "
                    + "mit der Laenge "
                    + i
                    + " ein:"
                );
                // bestimmt aus der Spielfeldgroesse den letztmoeglichen 
                // Buchstaben
                System.out.print(
                    "Zeile (A-"
                    + ((char) (64 + Schiffe.fieldsize))
                    + "): "
                );
                // wandelt Buchstaben in Zahlen um (A = 0, B = 1, usw.)
                zeile = 
                    System.console().readLine().toUpperCase().charAt(0)
                    - 65;
                System.out.print(
                    "Spalte (0-" + (Schiffe.fieldsize - 1) + "): "
                );
                spalte = Integer.parseInt(System.console().readLine());
                do {
                    System.out.print(
                        "Soll das Schiff (w)aagerecht oder (s)enkrecht "
                        + "positioniert werden? "
                    );
                    ausrichtung = 
                        System
                        .console()
                        .readLine()
                        .toUpperCase()
                        .charAt(0);
                } while (ausrichtung != 'S' && ausrichtung != 'W');
            } while (
                !Schiffe.schiffEintragen(
                    schiffe,
                    zeile,
                    spalte,
                    ausrichtung == 'S' ? true : false,
                    i
                )
            );
        }
    }

    // Prueft, ob die Positionierung eines Schiffs mit den oberen linken 
    // Koordinaten (zeile, spalte), der Ausrichtung senkrecht (true) oder 
    // waagerecht (false) und der angegebenen Laenge laenge gueltig ist.
    public static boolean schiffEintragen(
        boolean[][] schiffe,
        int zeile,
        int spalte,
        boolean senkrecht,
        int laenge)
    {
        // Hausaufgabe
        return true;
    }

    // Fordert den Benutzer zur Eingabe der naechsten Schusskoordinaten 
    // auf und liest diese ein. Sind die Koordinaten gueltig (also 
    // innerhalb des Spielfeldes), werden der Schuss und eventuell 
    // zusaetzlich inferiertes Wissen eingetragen. Ansonsten wird die 
    // Eingabeaufforderung wiederholt.
    public static void schussEingeben(
        boolean[][] schiffe,
        boolean[][] schuesse)
    {
        // Hausaufgabe

        // Fuer Hausaufgabe am Ende der Methode einkommentieren -
        // (zeile, spalte) sind die Koordinaten des Schusses:
     // SchiffeSecret.zusaetzlicheFelder(schiffe, schuesse, zeile, spalte);
    }

}
