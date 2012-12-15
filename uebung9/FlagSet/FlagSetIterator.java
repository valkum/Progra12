import java.util.*;

public class FlagSetIterator<E> implements Iterator<E> {

	private SetNode<E> current;

	private E recentElem;

	 /**
     * Flag indicating whether the remove operation is applicable (needed since elements may be null, so 
     * we cannot just check whether recentElem is null).
     */
    private boolean removable;

    private FlagSet<E> set;

	public FlagSetIterator(FlagSet<E> flagSet, SetNode<E> head)
    {
        this.current = head;
        this.recentElem = null;
        this.removable = false;
        this.set = flagSet;
    }
	public boolean hasNext() {
		 return this.current != null;
	}
	public E next() {
 		 if (this.hasNext()) {
            E elem = ((SetNode<E>) this.current).getElement();
            this.recentElem = elem;
            this.removable = true;
            this.current = this.current.getNext();
            this.forwardToNextActiveNodeSet();
            return elem;
        } else {
            throw new NoSuchElementException();
        }
	}
	public void remove() {
		if (this.removable) {
            this.set.remove(this.recentElem);
            this.removable = false;
        } else {
            throw new IllegalStateException(
                "The next method has not been called before this remove operation!");
        }
	}
    private void forwardToNextActiveNodeSet() {
        while(this.current != null && !((SetNode<E>) this.current).getActive() ) {
            this.current = this.current.getNext();
        }
    }
}