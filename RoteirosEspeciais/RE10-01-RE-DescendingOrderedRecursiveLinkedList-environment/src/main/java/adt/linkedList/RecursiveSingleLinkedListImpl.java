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
		if (element == null) return;

		if (isEmpty()){
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			getNext().insert(element);
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
		insertArray(a, 0, this.getData());
		return a;
	}

	private void insertArray(T[] array, int i, T element){
		if (element != null && i < size()) {
			array[i] = element;
			insertArray(array, i + 1, element);
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
