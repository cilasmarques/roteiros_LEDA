package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element){
		if (element != null){
			DoubleLinkedListNode newLast = new DoubleLinkedListNode(element, null, null);
			newLast.setPrevious(this.last);
			newLast.setNext(new DoubleLinkedListNode(null, null, null));
			setLast(newLast);
			if (this.last.getPrevious().isNIL())
				setHead((DoubleLinkedListNode) this.last);
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode newHead = new DoubleLinkedListNode(element, null, null);
			newHead.setNext(this.head);
			newHead.setPrevious(new DoubleLinkedListNode(null, null, null));
			setHead(newHead);
			if (this.head.getNext().isNIL())
				setLast((DoubleLinkedListNode<T>) this.head);
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()){
			DoubleLinkedListNode newHead = (DoubleLinkedListNode) this.head.getNext();
			setHead(newHead);
			newHead.setPrevious(new DoubleLinkedListNode(null,null,null));
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()){
			DoubleLinkedListNode newLast = (DoubleLinkedListNode) this.last.getPrevious();
			setLast(newLast);
			newLast.setNext(new DoubleLinkedListNode(null, null, null));
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
