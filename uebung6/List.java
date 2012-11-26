public class List {

  private final List next;
  private final int value;

  public List(List n, int v) {
    this.next = n;
    this.value = v;
  }

  public List getNext() {
    return this.next;
  }

  public int getValue() {
    return this.value;
  }

  /**
   * Returns a String representation of this list.
   */
  public String toString() {
    // IMPLEMENT ME
  }

  /**
   * Computes the length of the list.
   */
  public int length() {
    // IMPLEMENT ME
  }

  /**
   * Returns a list containing the first <code>length</code> elements of the 
   * current list. If this list does not contain enough elements, the whole
   * list is returned instead.
   */
  public List getSublist(int length) {
    // IMPLEMENT ME
  }

}
