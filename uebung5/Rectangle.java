/**
 * Ein Objekt der Klasse Rectangle repraesentiert ein Rechteck.  
 */
public class Rectangle {
    private double x;
    private double y;
    private double width;
    private double height;
        
    /**
     * Erzeugt ein neues Rechteck.
     * @param x x-Anteil der oberen linken Ecke des neuen Rechtecks
     * @param y y-Anteil der oberen linken Ecke des neuen Rechtecks
     * @param width die Breite des neuen Rechtecks
     * @param height die Hoehe des neuen Rechtecks  
     */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Erzeugt ein neues Rechteck mit der Form des uebergebenen Rechtecks.
     * @param rectangle das Rechteck
     */
    public Rectangle(Rectangle rectangle){
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }
    
    /**
     * Erzeugt ein Rechteck am Punkt (0.0|0.0) mit Breite und Hoehe 0.0. 
     */
    public Rectangle(){
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;        
    }

    /**
     * Liefert die Hoehe dieses Rechtecks.
     * @return die Hoehe dieses Rechtecks
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setzt die Hoehe dieses Rechtecks.
     * @param height die neue Hoehe dieses Rechtecks 
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Liefert die Breite dieses Rechtecks.
     * @return die Breite dieses Rechtecks
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setzt die Breite dieses Rechtecks.
     * @param width die neue Breite dieses Rechtecks 
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Liefert den x-Anteil der linken oberen Ecke des Rechtecks.
     * @return x-Anteil der linken oberen Ecke des Rechtecks
     */
    public double getX() {
        return x;
    }

    /**
     * Setzt den x-Anteil der linken oberen Ecke des Rechtecks.
     * @param x der neue x-Anteil der linken oberen Ecke des Rechtecks
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Liefert den y-Anteil der linken oberen Ecke des Rechtecks.
     * @return y-Anteil der linken oberen Ecke des Rechtecks
     */
    public double getY() {
        return y;
    }

    /**
     * Setzt den y-Anteil der linken oberen Ecke des Rechtecks.
     * @param y der neue y-Anteil der linken oberen Ecke des Rechtecks
     */
    public void setY(double y) {
        this.y = y;
    }
     

    /**
     * Verschiebt dieses Rechteck an einen neuen Punkt.  
     * @param x x-Anteil des Punktes
     * @param y y-Anteil des Punktes
     */
    public void move(double x,double y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Prueft, ob ein Punkt in dem Rechteck enthalten ist.   
     * @param x x-Anteil des Punktes
     * @param y y-Anteil des Punktes 
     * @return true, der Punkt ist im Rechteck enthalten, false, sonst 
     */
    public boolean contains(double x,double y){
        return (this.x <= x) && (x <= this.x+this.width) &&
               (this.y <= y) && (y <= this.y+this.height); 
    }
    
    /**
     * Gibt die Flaeche des Rechtecks zurueck.
     * @return die Flaeche des Rechtecks
     */
    public double size(){
        return this.height*this.width;
    }
    
    /**
     * Dehnt diese Rechteck um einen Faktor.
     * @param factor der Faktor
     */
    public void stretch(double factor){
        this.width = this.width*factor; 
        this.height = this.height*factor;
    }
    
    /**
     * Liefert die Vereinigung dieses Rechtecks mit einem anderen zurueck.
     * @param rectangle das andere Rechteck 
     * @return Vereinigung der Rechtecke  
     */
    public Rectangle union(Rectangle rectangle){
        double nx = Math.min(this.x,rectangle.x); 
        double ny = Math.min(this.y,rectangle.y);
        double nw = Math.max(this.x+this.width,rectangle.x+rectangle.width)-nx; 
        double nh = Math.max(this.y+this.height,rectangle.y+rectangle.height)-ny; 
        return new Rectangle(nx,ny,nw,nh);
    }
    
    /**
     * Liefert den Schnitt dieses Rechtecks mit einem anderen zurueck,
     * wenn der Schnitt leer ist wird null zurueckgegeben.
     * @param rectangle das andere Rechteck 
     * @return Schnitt der Rechtecke oder null wenn der Schnitt leer
     */
    public Rectangle intersection(Rectangle rectangle){
        double nx = Math.max(this.x,rectangle.x); 
        double ny = Math.max(this.y,rectangle.y);
        double nw = Math.min(this.x+this.width,rectangle.x+rectangle.width)-nx; 
        double nh = Math.min(this.y+this.height,rectangle.y+rectangle.height)-ny; 
        if (nw < 0 || nh < 0){
            return null;
        }
        return new Rectangle(nx,ny,nw,nh);
    }
    
    /**
     * Gibt eine Kopie dieses Rechtecks zurueck, wobei die Kopie dieselbe Form hat.
     * @return Eine Kopie mit derselben Form 
     */
    public Rectangle copy(){
        return new Rectangle(this);
    }
    
    /**
     * Gibt eine String-Repraesentation zurueck. 
     * @return Die String-Repraesentation  
     */
    public String toString(){
        return "("+this.x+"|"+this.y+"),"+this.width+","+this.height;
    }

    /**
     * Vergleicht die Form dieses Rechtecks mit der Form eines anderen.  
     * @param rectangle das Rechteck zum vergleichen 
     * @return true, wenn das ubergebene Rechteck dieselbe form hat, sonst false
     */
    public boolean isEqualTo(Rectangle rectangle){
        if (rectangle == null) return false;
        return this.x == rectangle.x && 
               this.y == rectangle.y && 
               this.width == rectangle.width &&
               this.height == rectangle.height; 
    }
    
    /**
     * Liefert ein neues Einheitsrechteck mit Breite und Hoehe 1.0, wobei 
     * die linke obere Ecke am Punkt (0.0|0.0) ist.   
     * @return ein neues Einheitsrechteck
     */
    public static Rectangle unity(){
        return new Rectangle(0.0,0.0,1.0,1.0);
    }
}
