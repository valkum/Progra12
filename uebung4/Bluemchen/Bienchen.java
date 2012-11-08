/*
 * Die Klasse Bienchen ermoeglicht es, einen Bienchen-Schwarm in einem
 * Bluemchenbeet starten zu lassen und von dort in ein anderes Beet fliegen zu lassen.
 * Hierbei wird simuliert, dass im ersten Beet Pollen gesammelt werden, wodurch
 * im zweiten Beet die dort existierenden Bluemchen bestaeubt werden und
 * dort deswegen neue Bluemchen entstehen koennen.
 */
public class Bienchen {
    
    /**
     * Laesst die Bienchen von einem Beet zum anderen fliegen
     * @param beetStart Startbeet
     * @param beetEnde  Zielbeet
     */
    public static void flieg(Bluemchenbeet beetStart, Bluemchenbeet beetEnde) {
        if (beetStart == null || beetEnde == null) {
            return;
        }

        Bluemchen[] bluemchenStart = beetStart.gibBluemchen();
        Bluemchen[] bluemchenEnde = beetEnde.gibBluemchen();

        /*
         * Hier werden alle Bluemchen zwischengespeichert, die durch den aktuellen.
         * Bienchen-Flug erzeugt wurden. Wenn jedes Beet maximal n Bluemchen enthalten darf,
         * koennen maximal n*n neue Bluemchen entstehen. Dieses Array ist also
         * entsprechend gross gewaehlt.
         */
        Bluemchen[] neueBluemchen = new Bluemchen[Bluemchenbeet.MAXBLUEMCHEN *
          Bluemchenbeet.MAXBLUEMCHEN];

        // TO DO (nutzen Sie die Hilfsmethode)
         for(Bluemchen bluemchen1 : bluemchenStart) {
            for(Bluemchen bluemchen2 : bluemchenEnde){
                if (bluemchen1 != null && bluemchen2 != null) erstelleNeuesBluemchen(bluemchen1, bluemchen2, neueBluemchen);
            }
         }

         beetEnde.neueBluemchen(neueBluemchen);
    }

    /**
     * Diese Hilfsmethode ueberprueft, ob mit den beiden uebergebenen Bluemchen ein
     * neues Bluemchen erzeugt werden kann. Wenn das so ist, wird entsprechend gehandelt.
     * Neue Bluemchen werden hierbei an einen freien Platz (sofern verfuegbar) des
     * uebergebenen Hilfsarrays geschrieben.
     * @param b1 erstes Mutterbluemchen 
     * @param b2 zweites Mutterbluemchen
     */
    public static void erstelleNeuesBluemchen(Bluemchen b1, Bluemchen b2,
            Bluemchen[] neueBluemchen) {
    	// Passen die beiden Bluemchen zusammen?
        if (b1.typ.ordinal() < b2.typ.ordinal()) {
        	// Wie sieht das "Kind" aus?
            int neuerTyp = (b1.typ.ordinal() + b2.typ.ordinal()) % Typ.values().length;
            Bluemchen neuesBluemchen = Bluemchen.neuesBluemchen(Typ.values()[neuerTyp]);
            System.out.println("Durch das Wunder der Bestaeubung ist das neue Bluemchen "
                    + neuesBluemchen.toString() + " entstanden!");
            for (int i = 0; i < neueBluemchen.length; i++) {
                if (neueBluemchen[i] == null) {
                    neueBluemchen[i] = neuesBluemchen;
                    return;
                }
            }
        }
    }
}
