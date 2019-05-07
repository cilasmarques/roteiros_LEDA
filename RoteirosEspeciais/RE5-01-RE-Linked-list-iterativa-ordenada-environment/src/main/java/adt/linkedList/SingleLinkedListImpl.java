package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> aux = this.head;

		int size = 0;
		while (!aux.getNext().isNIL()){
			size++;
			aux = aux.getNext();
		}

		return size;
	}

	@Override
	public T search(T element) {
		if (element != null && !isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			while (!aux.getNext().isNIL()) {
				if (aux.getData().equals(element))
					return element;
				aux = aux.getNext();
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()){
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<>());
			}

			else {
				SingleLinkedListNode<T> aux = this.head;
				while (!aux.getNext().isNIL()) {aux = aux.getNext();}
				aux.setNext(new SingleLinkedListNode(element, aux.getNext()));
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()){

			if(this.head.equals(element))
				setHead(this.head.getNext());

			else {
				SingleLinkedListNode<T> aux = this.head;
				while (!aux.isNIL()) {
					if (aux.getData().equals(element))
						aux.setNext(aux.getNext());

					aux = aux.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size()];

		SingleLinkedListNode<T> aux = this.head;
		int count = 0;
		while (!aux.getNext().isNIL()) {
			array[count] = aux.getData();
			aux = aux.getNext();
			count++;
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
