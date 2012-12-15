public class SetNode<E> {
	private boolean active = true;
	private E element;
	private SetNode<E> next;


	public SetNode(E e, SetNode<E> next) {
		this.next = next;
		this.element = e;
	}
	public boolean getActive() {
		return this.active;
	}
	public E getElement() {
		return this.element;
	}
	public SetNode<E> getNext() {
		return this.next;
	}
	public void setActive(boolean x, Object o) {
		if (this.element != null && this.element.equals(o)) {
            this.active = x;
        } else if(o == null && this.element == null){
        	this.active = x;
        } else {
            this.next.setActive(x, o);
        }
	}
	public boolean contains(Object o){
		if (this.element == null) {
            if (o == null) {
                return true;
            } else {
            	if(this.next != null)
                	return this.next.contains(o);
                return false;
            }
        } else if (this.element.equals(o)) {
            return true;
        } else {
        	if(this.next != null)
            	return this.next.contains(o);
            return false;
        }
	}
}