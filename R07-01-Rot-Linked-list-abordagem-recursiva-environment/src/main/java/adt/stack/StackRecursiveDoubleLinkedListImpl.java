package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		this.top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty())
			throw new StackUnderflowException();

		T element = this.top();
		this.top.removeLast();
		return element;
	}

	@Override
	public T top() {
		if (!isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) this.top;
			if (aux.getNext().isEmpty())
				return aux.getData();
			else
				return this.top(aux);
		}
		return null;
	}

	private T top(RecursiveDoubleLinkedListImpl<T> aux) {
		if (aux.getNext().isEmpty()) {
			return aux.getData();
		} else {
			return top((RecursiveDoubleLinkedListImpl<T>) aux.getNext());
		}
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == this.top.size();
	}

}
