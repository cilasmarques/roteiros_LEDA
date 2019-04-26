package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
				getPrevious().setNext(this);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
				RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
				newNode.setData(this.getData());
				this.setData(element);
				aux.setPrevious(newNode);
				newNode.setNext(this.getNext());
				newNode.setPrevious(this);
				this.setNext(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			setData(getNext().getData());
			setPrevious(new RecursiveDoubleLinkedListImpl<>());
			setNext(getNext().getNext());
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()){
			if (getNext().getData() == null)
				setData(null);
			else {
				RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
				aux.removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
