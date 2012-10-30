public class Bank {
  Konto[] konten;

  public static void main(String[] args) {
    Bank bank = new Bank();

    Konto k1 = new Konto();
    k1.kontonummer = 8234;
    k1.betrag = 100;

    Konto k2 = new Konto();
    k2.kontonummer = 7119;
    k2.betrag = 300;

    // a)

    bank.konten = new Konto[] {k1, k2};

    // Sonderzins
    k1.betrag *= 1.1;

    // b)
    
    bank.zinsen();

    k1 = k2;

    // c)
  }

  public void zinsen() {
    // Jahreszinsen
    for (Konto k : konten) {
      k.betrag *= 1.05;
    }
  }
}

