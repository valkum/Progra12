package supermarkt;

import supermarkt.artikel.*;

public class Supermarkt {
    public Artikel[] regal = {
        new Adventskalender(),
        new Adventskalender(),
        new Orangensaft(),
        new Orangensaft(),
        new Plastikweihnachtsbaum(),
        new Plastikweihnachtsbaum(),
        null,
        new Regenschirm(),
        new Regenschirm(),
        new Regenschirm()
    };

    public Nahrungsmittel[] kuehlfach = {
        new Fisch(),
        new Fisch(),
        new Fisch(),
        new Weihnachtsgans(),
        new Weihnachtsgans(),
        new Weihnachtsgans(),
        null
    };

    public static void main(String[] args) {
        Supermarkt xDreamStore = new Supermarkt();
        Supermarkt xDreamTeuerStore = xDreamStore;
        for (int tage=32;tage>=-10;tage--){
            System.out.println("Noch " + tage + " Tage bis Weihnachten!");
            xDreamTeuerStore.tageBisWeihnachten(tage);
            xDreamTeuerStore.auflisten();
            System.out.println("==================================================");
        }
    }

    public void auflisten() {
        for (Artikel a : regal) {
            // TODO Problem: Bei einem leeren Fach tritt eine
            // NullPointerException auf, es soll dann allerdings "leeres Fach"
            // ausgegeben werden.
            System.out.println("leeres Fach");
        }
        for (Nahrungsmittel n : kuehlfach) {
            // TODO Problem: Bei einem leeren Fach tritt eine
            // NullPointerException auf, es soll dann allerdings "leeres Fach"
            // ausgegeben werden.
            System.out.println("leeres Fach");
        }
    }

    public void tageBisWeihnachten(int tage){
        // TODO Aufgabenteil e)
    }

    private void setzePreisWennWeihnachtsangebot(Artikel artikel, int tage) {
        if (artikel instanceof Weihnachtsartikel){
            Weihnachtsartikel angebot = (Weihnachtsartikel) artikel;
            angebot.setzeTagespreis(tage);
        }
    }

    // TODO Problem: Methode wirft eine NullPointerException, wenn statt einem
    // Artikel null uebergeben wird.
    private void fachAusgeben(Artikel artikel) {
        System.out.println(artikel.toString());
    }
}
