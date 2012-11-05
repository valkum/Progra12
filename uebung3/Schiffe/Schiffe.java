public class Schiffe {

    // Laenge des laengsten Schiffs im Spiel
    public static int biggestShip = 5;

    // Fehlermeldung bei Kollision
    public static String fehlerKollision ="Ungueltige Eingabe! Das Schiff kollidiert mit einem bereits vorhandenen Schiff!";

    // Fehlermeldung bei Schiffeintragung ausserhalb des Spielfeldes
    public static String fehlerPasstNicht = "Ungueltige Eingabe! Das Schiff passt nicht ins Spielfeld!";

    // Seitenlaenge des quadratischen Spielfeldes
    public static int fieldsize = 10;

    // Laenge des kuerzesten Schiffs im Spiel
    public static int smallestShip = 2;

    // Gibt das Spielfeld aus.
    public static void ausgabe(boolean[][] schiffe,boolean[][] schuesse,boolean schiffeSichtbar)
    {
        // 0 Indizes werden fuer Beschriftung genutzt, Arrayindizes sind
        // um 1 verschoben
        for (int i = 0; i <= Schiffe.fieldsize; i++) {
            for (int j = 0; j <= Schiffe.fieldsize; j++) {
                if (i > 0) {
                    if (j > 0) {
                        // wir sind im Spielfeld
                        if (schuesse[i - 1][j - 1]) {
                            System.out.print(schiffe[i - 1][j - 1] ? "X" : "O");
                        } else {
                            System.out.print(schiffeSichtbar && schiffe[i - 1][j - 1] ? "S" : " "
                            );
                        }
                    } else {
                        // wir sind in der Zeilenbeschriftung (j == 0)
                        System.out.print((char) (64 + i));
                    }
                } else {
                    // wir sind in der Spaltenbeschriftung (i == 0)
                    // fuer j == 0 wird ein Leerzeichen ausgegeben
                    System.out.print(j > 0 ? j - 1 : " ");
                }
                // nach jedem Eintrag kommt ein Trennsymbol
                System.out.print("|");
            }
            // nach jeder Zeile kommt ein Zeilenumbruch
            System.out.println();
            // und anschliessend eine Trennzeile
            Schiffe.linie(Schiffe.fieldsize);
        }
        // zur Abgrenzung weiterer Ausgaben wird ein zusaetzlicher 
        // Zeilenumbruch am Ende hinzugefuegt
        System.out.println();
    }

    // Prueft, ob alle Schiffe versenkt wurden.
    public static boolean gewonnen(boolean[][] schiffe,boolean[][] schuesse)
    {
        for (int i = 0; i < Schiffe.fieldsize; i++) {
            for (int j = 0; j < Schiffe.fieldsize; j++) {
                if (schiffe[i][j] && !schuesse[i][j]) {
                    return false;
                }
            }
        }
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
                "Geben Sie die Groesse des Spielfelds ein(zwischen 10 und 26): "
            );
            feld = Integer.parseInt(System.console().readLine());
        } while (feld < 10 || feld > 26);
        int big;
        do {
            System.out.print(
                "Geben Sie die Laenge des laengsten Schiffes ein(zwischen 1 und" +(feld / 2)+"): "
            );
            big = Integer.parseInt(System.console().readLine());
        } while (big < 1 || big > feld / 2);
        int small;
        do {
            System.out.print(
                "Geben Sie die Laenge des kuerzesten Schiffes ein(zwischen 1 und "+ big + "): "
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
		private int fFelder = 0;
        for (int i = 0; i <= Schiffe.fieldsize; i++) {
            for (int j = 0; j <= Schiffe.fieldsize; j++) {
				if(!schuesse[i][j]){
					fFelder++;
				}
			}
		}
		return fFelder;
				
				
    }

    // Fordert den Benutzer zur Eingabe von Koordinaten und Ausrichtung 
    // der Schiffe auf, liest diese ein und traegt schliesslich die 
    // Schiffe ins Spielfeld ein. Dabei wird kontrolliert, ob die 
    // eingegebene Positionierung gueltig ist und im Falle einer 
    // ungueltigen Positionierung wird die Eingabeaufforderung wiederholt.
    public static void schiffeEintragen(boolean[][] schiffe, boolean[][] schuesse)
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
    public static boolean schiffEintragen(boolean[][] schiffe,int zeile,int spalte,boolean senkrecht,int laenge){
	//Zuerst Abfrage, ob das Schiff innerhalb des Feldes liegt, wir 
	//benutzen eine Verzweigung, da sich je nach Ausrichtung die borders
	//aendern, da wir jedes mal die Laenge des Schiffes dazurechnen muessen#
	private boolean[][] copy = schiffe;
		if(senkrecht){
			if(zeile < 0 || spalte < 0 || spalte + laenge + 1  > fieldsize || zeile > fieldsize){
				System.out.println(fehlerPasstNicht);
				return schiffe;
			}
			if(!schiffe[zeile-1][spalte] || schiffe[zeile + laenge + 1][spalte]){
				for(int i = zeile;i < zeile + laenge;i++){
					if(!schiffe[i][spalte] && !schiffe[i][spalte-1] && !schiffe[i][spalte+1]){
						copy[i][spalte] = true;
					}
					else
					{
					System.out.println(fehlerKollision);
					return schiffe;
					}
				}
				return copy;
			}
		}
        else{
			if(zeile < 0 || spalte < 0 || spalte > fieldsize || zeile + laenge + 1 > fieldsize){
				System.out.println(fehlerPasstNicht);
			}
			if(!schiffe[zeile][spalte-1] || schiffe[zeile][spalte + laenge + 1]){
				for(int i = spalte;i < spalte + laenge;i++){
					if(!schiffe[zeile][i] && !schiffe[zeile -1][i] && !schiffe[zeile+1][i]){
						copy[zeile][i] = true;
					}
					else
					{
					System.out.println(fehlerKollision);
					return schiffe;
					}
				}
				return copy;
			}
		}
		
    }

    // Fordert den Benutzer zur Eingabe der naechsten Schusskoordinaten 
    // auf und liest diese ein. Sind die Koordinaten gueltig (also 
    // innerhalb des Spielfeldes), werden der Schuss und eventuell 
    // zusaetzlich inferiertes Wissen eingetragen. Ansonsten wird die 
    // Eingabeaufforderung wiederholt.
    public static void schussEingeben(boolean[][] schiffe, boolean[][] schuesse){
		private int zeile = '0';
		private int spalte = 0;
		do{
			System.out.println("Bitte geben sie die Zeile des Ziels ein");
			zeile = System.console.readLine().toUpperCase().charAt(0) - 65;
		while(zeile =< fieldsize);
		do{
			System.out.println("Bitte geben sie die Spalte des Ziels ein");
			spalte = Integer.parseInt(System.console.readline());
		while(spalte =< fieldsize);
		schuesse[zeile][spalte] = true;
     SchiffeSecret.zusaetzlicheFelder(schiffe, schuesse, zeile, spalte);
    }

}
