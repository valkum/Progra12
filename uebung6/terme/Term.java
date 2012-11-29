public class Term {
  private Typ typ;
  private Term erster;
  private Term zweiter;
  private Double wert;
  private String var;

  public Term(Double x) {
    this.typ = Typ.LIT;
    this.wert = x;
  }
  public Term(String var){
    this.typ = Typ.VAR;
    this.var = var;
  }
  public Term(Typ t, Term a, Term b){
    this.typ = t;
    this.erster = a;
    this.zweiter = b;
  }
  public static void main(String[] args) {
    // erzeuge einige Terme zum Testen
    Term varX = new Term("x");
    Term varY = new Term("y");
    Term zahlNeun = new Term(9.0d);
    Term add = varX.add(varY);
    Term div = zahlNeun.div(varY);
    Term term = add.mul(div);

    // gib Term als String aus
    System.out.println(term);

    // gib Groesse des Terms aus
    System.out.println(term.groesse());

    // substituiere x/1 und y/2 und gib Ergebnis aus
    Term substA = term.subst("x", 1).subst("y", 2);
    System.out.println(substA);

    // werte den Term komplett aus");
    System.out.println(substA.auswerten());

    // substituiere x/4 und y/2, gib Ergebnis aus und werte aus
    Term substB = term.subst("x", 4).subst("y", 2);
    System.out.println(substB);
    System.out.println(substB.auswerten());


    // erweitere den Test-Term sinnlos und vereinfache dann
    Term zahlNull = new Term(0.0d);
    Term zahlEins = new Term(1.0d);
    Term test = term.add(zahlNull).mul(zahlEins).sub(varX.sub(varX));
    System.out.println(test);
    System.out.println(test.vereinfache());

    //Selbsteingebauter Test ob auch Terme von Termen mit (a-a) vereinfacht werden
    Term test2 = term.sub(test.sub(test));
    System.out.println(test2);
    System.out.println(test2.vereinfache());

  }

  public String toString(){
    String res = "";
    switch(this.typ) {
      case LIT:
        res = String.valueOf(this.wert);
      break;
      case VAR:
        res = this.var;
      break;
      case ADD:
        res = "(" + this.erster + " + " + this.zweiter + ")";
      break;
      case SUB:
        res = "(" + this.erster + " - " + this.zweiter + ")";
      break;
      case MUL:
        res = "(" + this.erster + " * " + this.zweiter + ")";
      break;
      case DIV:
        res = "(" + this.erster + " / " + this.zweiter +")";
      break;
    }
    return res;
  }

  /**
   * Berechnet die größe des Terms
   * @return int Gibt die Größe zurück
   */
  public int groesse() {
    int res = 1;
    switch(this.typ) {
      case ADD:
      case SUB:
      case MUL:
      case DIV:
        res += this.erster.groesse() + this.zweiter.groesse();
      break;
    }
    return res;
  }

  /**
   * Ersetzt alle vorkommen der Variable x im Term durch die Zahl y
   * @param x String der Variablenname
   * @param y double Der Wert der zugewiesen werden soll.
   * @return Term Gibt den ersetzten Term zurück.
   */
  public Term subst (String x, double y) {
    Term res = this;
    switch (this.typ) {
      case VAR:
        if(this.var.equals(x)) {
          res = new Term(y);
        }else {
          res = this;
        }
      break;
      case LIT:
        res = this;
      break;
      case ADD:
      case SUB:
      case MUL:
      case DIV:
        res = new Term(this.typ, this.erster.subst(x, y), this.zweiter.subst(x, y));
      break;
    }
          
    return res;
  }
  /**
   * Wertet den Term aus
   * @return Double Den Wert des Terms, wenn noch eine Variable im Term vorhanden ist, wird null zurückgegeben.
   */
  public Double auswerten() {
    Double res = null;
    switch (this.typ) {
      case VAR: 
        res =  null;
      break;
      case LIT:
        res =  this.wert;
      break;
      case ADD:
        if (this.erster.auswerten() != null && this.zweiter.auswerten() != null) {
          res =  Double.valueOf(this.erster.auswerten()) + Double.valueOf(this.zweiter.auswerten());
        }else{
          res =  null;
        }
      break;
      case SUB:
        if (this.erster.auswerten() != null && this.zweiter.auswerten() != null) {
          res =  Double.valueOf(this.erster.auswerten()) - Double.valueOf(this.zweiter.auswerten());
        }else{
          res = null;
        }
      break;
      case MUL:
        if (this.erster.auswerten() != null && this.zweiter.auswerten() != null) {
          res = Double.valueOf(this.erster.auswerten()) * Double.valueOf(this.zweiter.auswerten());
        }else{
          return null;
        }
      break;
      case DIV:
        if (this.erster.auswerten() != null && this.zweiter.auswerten() != null) {
          res = Double.valueOf(this.erster.auswerten()) / Double.valueOf(this.zweiter.auswerten());
        }else{
          res = null;
        }
      break;    
    }
    return res;
  }
  /**
   * Vereinfacht einen Term mithilfe der arithmetischen gesetze (a*0) = 0 etc.
   * @return Term Den vereinfachten Term
   */
  public Term vereinfache() {
    Term res = null;
    switch(this.typ) {
      case LIT:
        res = this;
      break;
      case VAR:
        res = this;
      break;
      case ADD:
        if(this.erster.typ == Typ.LIT && this.erster.wert == 0d) {
          res = this.zweiter.vereinfache();
        }else if (this.zweiter.typ == Typ.LIT && this.zweiter.auswerten() == 0d) {
          res = this.erster.vereinfache();
        }else if (this.erster.typ == Typ.LIT && this.zweiter.typ == Typ.LIT ){
          res = new Term(this.auswerten());
        }else if(this.erster.vereinfache() == null) {
          res = this.zweiter.vereinfache();
        }else if(this.zweiter.vereinfache() == null) {
          res = this.erster.vereinfache();
        }else{
          res =  this;
        }
      break;
      case SUB:
        if(this.erster.typ == Typ.LIT && this.erster.auswerten() == 0d) {
          res = this.zweiter.vereinfache();
        }else if (this.zweiter.typ == Typ.LIT && this.zweiter.auswerten() == 0d) {
          res = this.erster.vereinfache();
        } else if(this.erster.vereinfache() == null) {
          res = this.zweiter.vereinfache();
        }else if(this.zweiter.vereinfache() == null) {
          res = this.erster.vereinfache();
        }else{
          res = new Term(Typ.SUB, this.erster.vereinfache(), this.zweiter.vereinfache());
        }
        if(this.erster.equals(this.zweiter)){
          res = null;
        }
      break;
      case MUL:
        if( (this.erster.typ == Typ.LIT && this.erster.auswerten() == 0d) ||
        (this.zweiter.typ == Typ.LIT && this.zweiter.auswerten() == 0d) ) {
          res = new Term(0d);
        } else if(this.erster.typ == Typ.LIT && this.erster.auswerten() == 1d ){
          res = this.zweiter.vereinfache();
        } else if(this.zweiter.typ == Typ.LIT && this.zweiter.auswerten() == 1d ){
          res = this.erster.vereinfache();
        } else if(this.erster.vereinfache() == null) {
          res = this.zweiter.vereinfache();
        } else if(this.zweiter.vereinfache() == null) {
          res = this.erster.vereinfache();
        }else{
          res = this;
        }
      break;
      case DIV:
        if(this.erster.typ == Typ.LIT && this.erster.auswerten() == 0d ) {
          res = new Term(0d);
        }else if (this.zweiter.typ == Typ.LIT && this.zweiter.auswerten() == 1d) {
          res = this.erster.vereinfache();
        } else if(this.erster.typ == Typ.VAR && this.zweiter.typ == Typ.VAR && this.erster.var.equals(this.zweiter.var)){
          res = new Term(1d);
        }else if(this.erster.vereinfache() == null) {
          res = this.zweiter.vereinfache();
        }else if(this.zweiter.vereinfache() == null) {
          res = this.erster.vereinfache();
        }else{
          res = this;
        }
      break;
    }
    return res;
  }
  /**
   * Testet ob der Term mit dem gegebenen Term übereinstimmt
   * @param b Term Ein beliebiger Term
   * @return boolean true wenn sie übereinstimmen.
   */
  public boolean equals(Term b) {

    if(this.typ == b.typ) {
      if(this.typ == Typ.VAR && this.var.equals(b.var)){
        return true;
      }else if(this.typ == Typ.LIT && this.wert == b.wert){
        return true;
      }else if(this.typ != Typ.VAR && this.typ != Typ.LIT){
        if(this.erster.equals(b.erster) && this.zweiter.equals(b.zweiter)){
          return true;
        }
      }
    }
    return false;
  }

  public Term add(Term summand) {
    return new Term(Typ.ADD, this, summand);
  }

  public Term sub(Term subtrahend) {
    return new Term(Typ.SUB, this, subtrahend);
  }

  public Term div(Term divisor) {
    return new Term(Typ.DIV, this, divisor);
  }

  public Term mul(Term faktor) {
    return new Term(Typ.MUL, this, faktor);
  }
}
