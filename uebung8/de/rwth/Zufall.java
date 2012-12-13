package de.rwth;

import java.util.*;

public class Zufall {
    private static Random r = new Random();

    /**
     * Gibt eine zufaellige Zahl zwischen {@code 0} und {@code i - 1} zurueck.
     * 
     * @param i
     *            Die Obergrenze (nicht eingeschlossen).
     * @return Die Zufallszahl.
     */
    public static int zahl(final int i) {
        return r.nextInt(i);
    }
}
