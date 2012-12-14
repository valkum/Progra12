import java.util.*;

public class FlagSet<E> extends AbstractIterableSet<E> {
	private SetNode<E> head;

	public boolean add(E e) {
		if (this.contains(e)) {
            return false;
        } else {
            this.head = new SetNode<E>(e, this.head);
            return true;
        }
	}
	public void clear() {
		this.head = null;
	}
	public boolean contains(Object o) {
		return this.head.contains(o);
	}
	public Iterator<E> iterator() {
		return new FlagSetIterator<E>(this, this.head);
	}
	public boolean remove(Object o) {
		  if (this.contains(o)) {
            this.head = new RemoveSet<E>(o, this.head);
            return true;
        } else {
            return false;
        }
	}
}