/**
 * Ein Objekt der Klasse Bluemchen repraesentiert ein Bluemchen, wobei es
 * mehrere Arten mit unterschiedlichen Eigenschaften gibt. Jedes Bluemchen
 * verbraucht pro Tag eine bestimmte Menge an Wasser und muss deswegen
 * regelmaessig gegossen werden.
 */
public class Bluemchen {
    /**
     * aktuelle Wasservorrat des Bluemchens 
     */
    public int wasserVorrat;
    
    /**
     * maximale Wasservorrat des Bluemchens 
     */
    public int maxWasserVorrat;
    
    /**
     * Name des Bluemchens 
     */
    public String name;
    
    /**
     * Typ des Bluemchens
     */
    public Typ typ;
    
    /**
     * Verbrauch des Bluemchens
     */
    public int verbrauch;

    /**
     * Erzeuge ein neues Bluemchen des angegebenen Typen.
     * Bei ungueltigen Eingaben wird eine Tulpe erzeugt.
     * @param typDerBlume Blumentyp 
     * @return das neue Bluemchen
     */
    public static Bluemchen neuesBluemchen(Typ typDerBlume) {
    	/*
    	 * Abhaengig vom Typen wird ein Bluemchen mit folgenden Eigenschaften erzeugt.
    	 * Typ 0: Tulpe, max. Wasservorrat 40, Verbrauch pro Tag 7
    	 * Typ 1: Rittersporn, max. Wasservorrat 20, Verbrauch pro Tag 6
    	 * Typ 2: Osterglocke, max. Wasservorrat 25, Verbrauch pro Tag 4
    	 * Typ 3: Sumpf-Schwertlilie, max. Wasservorrat 32, Verbrauch pro Tag 5
    	 */

    	// TO DO
    }

    /**
     * Gib eine String-Repraesentation des Bluemchens, so dass man den Typen
     * und wichtige Details zum Wasserverbrauch und -status ablesen kann.
     * @return alle Informationen des Bluemchens als String
     */
    public String toString() {
    	// TO DO
    }

    /**
     * Giesse das Bluemchen mit der angegebenen Menge Wasser. Wenn das
     * Bluemchen zu viel gegossen wurde, wird "false" zurueckgegeben, um das
     * Sterben der Pflanze anzudeuten.
     * @return true, das Bluemchen lebt noch, false, das Bluemchen ist ertrunken 
     */
    public boolean giessen(int menge) {
    	// TO DO
    }

    /**
     * Wenn diese Methode aufgerufen wird, verbraucht das Bluemchen Wasser. Je
     * nach Bluemchen-Typ wird hierbei eine unterschiedliche Menge von Wasser
     * verbraucht. Wenn nicht genug Wasser vorraetig ist, stirbt das Bluemchen
     * - was durch die Rueckgabe von "false" weitergegeben wird.
     * @return true, das Bluemchen lebt noch, false, das Bluemchen ist verdurstet 
     */
    public boolean verbraucheWasser() {
    	// TO DO
    }
}
