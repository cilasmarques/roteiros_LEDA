package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		if (isEmpty()) return 0;

		return 1 + getNext().size();
	}

	@Override
	public T search(T element) {
		if (element == null || isEmpty()) return null;

		if (getData().equals(element)) {return element;}

		return getNext().search(element);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()){
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<>());
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element == null || isEmpty()) return;

		if (this.getData().equals(element)){
			this.setData(getNext().getData());
			this.setNext(getNext().getNext());
		} else {
			getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
		T[] a = (T[]) new Object[size()];
		insertArray(a, 0, this);
		return a;
	}

	private void insertArray(T[] array, int i, RecursiveSingleLinkedListImpl node){
		if (node.getData() != null && i < size()) {
			array[i] = (T) node.getData();
			insertArray(array, i + 1, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
