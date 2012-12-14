import java.util.*;

public class FlagSet<E> extends AbstractIterableSet<E> {
	private SetNode<E> head;

	public FlagSet(){
		this.head = new SetNode<E>(null, null);
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
		this.head = new SetNode<E>(null, null);
	}
	public boolean contains(Object o) {
		return this.head.contains(o);
	}
	public Iterator<E> iterator() {
		return new FlagSetIterator<E>(this, this.head);
	}
	public boolean remove(Object o) {
		  if (this.contains(o)) {
            this.head.setActive(true, o);
            return true;
        } else {
            return false;
        }
	}
}