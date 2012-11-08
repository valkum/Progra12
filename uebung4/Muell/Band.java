public class Band {
  public Muell[] inhalt;


  public static String arrayToString(Muell[] m) {
  	String string = "";
    int x = 0;
  	for(int i= 0; i < m.length; i++) {
      
  		if (m[i] != null){
        if(x>0) string += ", ";
        string += m[i].toString();
        x++;
      }
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
        return;
      }
    }
  }
}
