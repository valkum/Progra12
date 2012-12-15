import java.util.*;

public class FlagSet<E> extends AbstractIterableSet<E> {
	private SetNode<E> head;

	public FlagSet(){
		this.head = null;
	}
	public boolean add(E e) {
		if (this.contains(e)) {
			this.head.setActive(true, e);
            return true;
        } else {
            this.head = new SetNode<E>(e, this.head);
            return true;
        }
	}
	public void clear() {
		this.head = null;
	}
	public boolean contains(Object o) {
		if (this.head != null)
			return this.head.contains(o);
		return false;
	}
	public Iterator<E> iterator() {
		return new FlagSetIterator<E>(this, this.head);
	}
	public boolean remove(Object o) {
		  if (this.contains(o)) {
            this.head.setActive(false, o);
            return true;
        } else {
            return false;
        }
	}
}