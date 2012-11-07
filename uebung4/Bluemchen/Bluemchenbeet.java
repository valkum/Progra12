public class Bluemchenbeet {
    /**
     * Hier wird die Groesse eines jeden Beetes beschraenkt.
     */
    public static int MAXBLUEMCHEN = 9;

    /**
     * Die einzelnen Bluemchen-Objekte werden hier gespeichert
     */
    Bluemchen[] bluemchenImBeet = new Bluemchen[MAXBLUEMCHEN];

    /**
     * Gib das Array, in dem alle Bluemchen gespeichert sind, zurueck.
     * @return array aller Bluemchen 
     */
    public Bluemchen[] gibBluemchen() {
        return this.bluemchenImBeet;
    }

    /**
     * Hier wird genau dann "true" zurueckgegeben, wenn mindestens ein Bluemchen
     * in diesem Beet existiert ("lebt").
     * @return true, wenn lebendig, sonst false.
     */
    public boolean lebendig() {
       // TO DO
    }

    /**
     * Pflanze das neue Bluemchen in einen freien Platz in diesem Beet.
     * Wenn kein Platz mehr ist, wird das neue Bluemchen ignoriert.
     * @param neuesBluemchen das Bluemchen wird eingepflanzt
     */
    public void neuesBluemchen(Bluemchen neuesBluemchen) {
       // TO DO
    }

    /**
     * Pflanze die Bluemchen, die in dem uebergebenen Array gespeichert sind, in dieses Beet.
     * Falls nicht genug Platz zur Verfuegung steht, wird jedes neue Bluemchen ignoriert.
     * @param neueBluemchen die Bluemchen werden eingepflanzt
     */
    public void neueBluemchen(Bluemchen[] neueBluemchen) {
       // TO DO
    }

    /**
     * Giesse alle Bluemchen in diesem Beet mit der angegebenen Menge Wasser.
     * @param menge Liter zum Giessen
     */
    public void giessen(int menge) {
    	// TO DO
    }

    /**
     * Zeige Informationen fuer alle Bluemchen in diesem Beet.
     * @return Ein String mit allen Informationen 
     */
    public String toString() {
    	// TO DO
    }

    /**
     * Sorge dafuer, dass jedes Bluemchen in diesem Beet Wasser verbraucht.
     */
    public void verbraucheWasser() {
    	// TO DO
    }
}
