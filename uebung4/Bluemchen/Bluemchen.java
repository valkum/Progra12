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
        Bluemchen blume = new Bluemchen();
    	switch(typDerBlume) {
            default:
            case Tulpe:
                blume.typ = typDerBlume;
                blume.verbrauch = 7;
                blume.maxWasserVorrat=40;
                blume.name="Tulpe";
            break;
            case Rittersporn:
                blume.typ = typDerBlume;
                blume.verbrauch = 6;
                blume.maxWasserVorrat=20;
                blume.name="Rittersporn";
            break;
            case Osterglocke: 
                blume.typ = typDerBlume;
                blume.verbrauch = 4;
                blume.maxWasserVorrat=25;
                blume.name="Osterglocke";
            break;
            case Sumpf_Schwertlilie:
                blume.typ = typDerBlume;
                blume.verbrauch = 5;
                blume.maxWasserVorrat=32;
                blume.name="Sumpf-Schwertlilie";
            break;
        }
	System.out.println("wasser: " + 3* blume.verbrauch);
        if( ( 3 * blume.verbrauch) >= blume.maxWasserVorrat) {
            blume.wasserVorrat = 1*blume.maxWasserVorrat;
        }else{
            blume.wasserVorrat = 3*blume.verbrauch;
        }
        return blume;
    }

    /**
     * Gib eine String-Repraesentation des Bluemchens, so dass man den Typen
     * und wichtige Details zum Wasserverbrauch und -status ablesen kann.
     * @return alle Informationen des Bluemchens als String
     */
    public String toString() {
    	return "("+ this.typ.ordinal() +") "+ this.name +" ["+ this.wasserVorrat +"/"+ this.maxWasserVorrat +"] (Verbrauch: "+ this.verbrauch +")";
    }

    /**
     * Giesse das Bluemchen mit der angegebenen Menge Wasser. Wenn das
     * Bluemchen zu viel gegossen wurde, wird "false" zurueckgegeben, um das
     * Sterben der Pflanze anzudeuten.
     * @return true, das Bluemchen lebt noch, false, das Bluemchen ist ertrunken 
     */
    public boolean giessen(int menge) {
        this.wasserVorrat += menge;
    	return ( this.wasserVorrat <= maxWasserVorrat);
    }

    /**
     * Wenn diese Methode aufgerufen wird, verbraucht das Bluemchen Wasser. Je
     * nach Bluemchen-Typ wird hierbei eine unterschiedliche Menge von Wasser
     * verbraucht. Wenn nicht genug Wasser vorraetig ist, stirbt das Bluemchen
     * - was durch die Rueckgabe von "false" weitergegeben wird.
     * @return true, das Bluemchen lebt noch, false, das Bluemchen ist verdurstet 
     */
    public boolean verbraucheWasser() {
    	this.wasserVorrat = wasserVorrat - verbrauch;
        return (this.wasserVorrat > 0);
    }
}
