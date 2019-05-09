package adt.linkedList.extended;

import java.util.Arrays;
import java.util.Comparator;

import adt.linkedList.LinkedList;
import adt.linkedList.RecursiveSingleLinkedListImpl;

/**
 * This class is an implementation of an ordered recursive single linked list
 * that behaves like a Set (it cannot contain repeated elements). The constraint
 * of this list is that the elements MUST be ordered in descending order. Tip:
 * think about if it is necessary to override insert, search and remove to use
 * the comparator and respect the constraint.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class DescendingOrderedRecursiveLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> {

	private Comparator<T> comparator;

	public DescendingOrderedRecursiveLinkedListImpl() {
		super();
		this.comparator = comparator;
	}

	/**
	 * It returns the maximum element of the list or null if the list is empty.
	 * 
	 * @return
	 */
	public T maximum() {
		if (this.isEmpty()) {
			return null;
		}

		sortLinkedList(this);
		T[] a = this.toArray();
		return a[size()-1];
	}

	/**
	 * It puts all elements of otherList in this list. Try to make this methods
	 * as fast as possible.
	 * 
	 * @param otherList
	 */
	public void insertAll(LinkedList<T> otherList) {
		if(!otherList.isEmpty()) {
			RecursiveSingleLinkedListImpl otherListTemp = (RecursiveSingleLinkedListImpl) otherList;
			DescendingOrderedRecursiveLinkedListImpl thisNext = (DescendingOrderedRecursiveLinkedListImpl) this.getNext();

			if (this.isEmpty()) {
				insert((T) otherListTemp.getData());
				this.setNext((otherListTemp.getNext()));
			} else {
				thisNext.insertAll(otherList);
			}
		} else if (!this.isEmpty() && size() > 1) {
			sortLinkedList(this);
			removeDuplicate(this);
		}
	}

	/**
	 * This methods compares (for set equality) this list with otherList
	 * (possibly containing repeated elements). This this method returns true if
	 * the lists have the same elements. It does not matter how many times they
	 * appear in otherList.
	 * 
	 * @param otherList
	 */
	public boolean equalsAsSet(LinkedList<T> otherList) {
		return this.toArray().equals(otherList.toArray());
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}


	public void removeDuplicate(RecursiveSingleLinkedListImpl node) {
		if (!node.isEmpty() && !node.getNext().isEmpty()) {
			T value1 = (T) node.getData();
			T value2 = (T) node.getNext().getData();
			if (value1.equals(value2)) {
				remove(value2);
				removeDuplicate(node);
			} else {
				removeDuplicate(node.getNext());
			}
		}
	}

	public void sortLinkedList(RecursiveSingleLinkedListImpl minnorNode) {
		RecursiveSingleLinkedListImpl thisAux = minnorNode.getNext();
		RecursiveSingleLinkedListImpl minnorNodeActual = minnorNode;
		T minnorValue = (T) minnorNode.getData();

		if (!minnorNode.isEmpty() && minnorValue != null) {
			while (!thisAux.isEmpty() && thisAux.getData() != null) {
				T actualValue = (T) thisAux.getData();
				if (getComparator().compare(minnorValue, actualValue) == 1) {
					minnorNodeActual = thisAux;
					minnorValue = actualValue;
				}
				thisAux = thisAux.getNext();
			}

			minnorNodeActual.setData(minnorNode.getData());
			minnorNode.setData(minnorValue);
			sortLinkedList(minnorNode.getNext());
		}
	}
}
