public class Band {
  public Muell[] inhalt;


  public static String arrayToString(Muell[] m) {
  	String string = "";
  	for(int i= 0; i < m.length; i++) {
  		if (m[i] != null) string += m[i].toString();
  	}
  	return string;
  }

  public String toString() {
  	return this.arrayToString(this.inhalt);
  }
  
  public void drauf(Muell m){
    for(int i = 0; i < this.inhalt.length; i++){
      if(this.inhalt[i] == null){
        this.inhalt[i] = m;
      }
    }
  }
}
