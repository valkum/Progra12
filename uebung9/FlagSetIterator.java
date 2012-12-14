import java.util.*;

public class FlagSetIterator<E> implements Iterator<E> {
	private FlagSet<E> current;

	private E recentElem;


	public FlagSetIterator(FlagSet<E> head)
    {
        this.current = head;
        this.recentElem = null;
        this.removable = false;
        this.set = functionalSet;
        this.forwardToNextUnusedSet();
    }
	public boolean hasNext() {
		 return this.current != null;
	}
	public E next() {

	}
	public void remove() {

	}
}