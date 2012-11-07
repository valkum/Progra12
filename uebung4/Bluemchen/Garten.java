/*
 * Diese Klasse ermoeglicht es, eine Bienchen-und-Bluemchen-Simulation zu spielen.
 * Im Laufe des Spiels kann und muss man Bluemchen in verschiedenen Beeten giessen.
 * Ausserdem ist es moeglich, durch die Hilfe von Bienchen, neue Bluemchen zu erzeugen.
 */
public class Garten {

  /**
   * Die Anzahl der Bluemchenbeete in diesem Spiel
   */
  public static int BEETE = 3;

  /**
   * Die Anzahl der Start-Bluemchen pro Beet
   */
  public static int INITBLUEMCHEN = 2;

  /**  
   * Die Wassermenge, die pro Giessvorgang an die einzelnen Bluemchen verteilt wird
   */
  public static int GIESSVOLUMEN = 12;

  /**
   * Hier werden die einzelnen Beete gespeichert
   */
  public static Bluemchenbeet[] bluemchenbeete = new Bluemchenbeet[BEETE];

  /**
   * Main methode
   * @param args Ungenutzte Kommandozeilenparameter
   */
  public static void main(String[] args) {
    // Erzeuge die Beete mit den Start-Bluemchen
    for (int i = 0; i < BEETE; i++) {
      Bluemchenbeet neuesBeet = new Bluemchenbeet();
      for (int j = 0; j < INITBLUEMCHEN; j++) {
        // Die genaue Auswahl der Start-Bluemchen ist in die Methode neuesBluemchen() ausgelagert.
        neuesBeet.neuesBluemchen(neuesBluemchen());
      }
      bluemchenbeete[i] = neuesBeet;
    }

    int tag = 0;

    /*
     * Die Hauptschleife des Spiels.
     * 1) Lasse einen neuen Tag beginnen
     * 2) Lasse alle Bluemchen Wasser verbrauchen
     * 3) Giesse die Bluemchen
     * 4) Schicke die Bienchen los
     */
    while (lebendig()) {
      tag++;
      System.out.println("Tag " + tag + " bricht an!");
      verbraucheWasser();
      // Wenn kein Bluemchen mehr lebt, macht das Giessen keinen Sinn
      if (lebendig()) {
        zeichneBeete();
        giessen();
      }
      if (lebendig()) {
        zeichneBeete();
        bienchen();
      }
      System.out.println("Druecke Enter, um den naechsten Tag zu beginnen.");
      System.console().readLine();
    }
    System.out.println("Du warst " + tag + " Tage lang ein guter Gaertner.");
  }

  /**
   * Sorge dafuer, dass alle Bluemchen Wasser verbrauchen. Hierfuer wird die
   * entsprechende Methode eines jeden Beetes aufgerufen.
   */
  public static void verbraucheWasser() {
    for (Bluemchenbeet beet : bluemchenbeete) {
      if (beet != null) {
        beet.verbraucheWasser();
      }
    }
  }

  /**
   * Gib dem Benutzer pro Beet die Moeglichkeit zu giessen.
   */
  public static void giessen() {
    for (int i = 0; i < BEETE; i++) {
      System.out.println("Moechtest du Beet " + (i+1) + " giessen (Wassermenge: " + GIESSVOLUMEN + ")? (1 fuer ja, sonst nein)");
      int antwort = Integer.parseInt(System.console().readLine());
      if (antwort == 1) {
        Bluemchenbeet beet = bluemchenbeete[i];
        if (beet != null) {
          beet.giessen(GIESSVOLUMEN);
        }
      }
    }
  }

  /**
   * Schicke Bienchen von einem Beet zu einem anderen (oder zum gleichen) Beet.
   */
  public static void bienchen() {
    System.out.println("Moechtest du die Bienchen losschicken? (1 fuer ja, sonst nein)");
    int antwort = Integer.parseInt(System.console().readLine());
    if (antwort == 1) {
      int beetNummer = -1;
      while (beetNummer == -1) {
        System.out.println("In welchem Beet sollen die Bienchen starten?");
        beetNummer = Integer.parseInt(System.console().readLine());
        if (beetNummer > BEETE || beetNummer < 1) {
          beetNummer = -1;
        }
      }
      Bluemchenbeet beetStart = bluemchenbeete[beetNummer-1];

      beetNummer = -1;
      while (beetNummer == -1) {
        System.out.println("In welchem Beet sollen die Bienchen ihre Reise beenden?");
        beetNummer = Integer.parseInt(System.console().readLine());
        if (beetNummer > BEETE || beetNummer < 1) {
          beetNummer = -1;
        }
      }
      Bluemchenbeet beetEnde = bluemchenbeete[beetNummer-1];

      Bienchen.flieg(beetStart, beetEnde);
    }
  }

  /**
   * Erzeuge ein zufaelliges neues Bluemchen
   * @return ein neues Bluemchen
   */
  public static Bluemchen neuesBluemchen() {
    int zufall = Zufall.zufallszahl(Typ.values().length);
    return Bluemchen.neuesBluemchen(Typ.values()[zufall - 1]);
  }

  /**
   * Gib Informationen zu allen Beeten
   */
  public static void zeichneBeete() {
    System.out.println("Deine Beete sehen aktuell so aus:");
    for (int i = 0; i < bluemchenbeete.length; i++) {
      Bluemchenbeet beet = bluemchenbeete[i];
      if (beet != null) {
        System.out.println("Beet " + (i+1) + ":");
        System.out.println(beet.toString());
        System.out.println("---");
      }
    }
  }

  /**
   * Hier wird genau dann "true" zurueckgegeben, wenn in mindestens einem Beet
   * noch mindestens eine Pflanze existiert ("lebt").
   * @return true, wenn noch etwas lebt, false sonst  
   */
  public static boolean lebendig() {
    for (Bluemchenbeet beet : bluemchenbeete) {
      if (beet != null && beet.lebendig()) {
        return true;
      }
    }
    return false;
  }
}
