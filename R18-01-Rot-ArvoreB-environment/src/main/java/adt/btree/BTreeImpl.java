package adt.btree;

import java.util.LinkedList;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() { return height(this.root); }

	private int height(BNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			if (node.isLeaf())
				return 0;
			else
				result = 1 + height(node.children.get(0));
		}
		return result;
	}

	@Override
	public BNode<T>[] depthLeftOrder() {
		BNode<T>[] array = new BNode[size(getRoot())];
		depthLeftOrder(array, 0, this.root);
		return array;
	}

	private int depthLeftOrder(BNode<T> array[], int index, BNode<T> node) {
		if (!node.isEmpty()) {
			array[index++] = node;
			for (int i = 0; i < node.children.size(); i++) {
				index = depthLeftOrder(array, index, node.children.get(i));
			}
		}
		return index;
	}

	@Override
	public int size() {
		return size(getRoot());
	}

	private int size(BNode<T> node) {
		if (node.isEmpty())
			return 0;

		int result = node.size();
		for (int i = 0; i < node.children.size(); i++) {
			result += size(node.children.get(i));
		}
		return result ;
	}

	@Override
	public BNodePosition<T> search(T element) {
		if (element != null){
			return search(getRoot(), element);
		}
		return null;
	}

	private BNodePosition<T> search(BNode<T> node, T element) {
		int i = 1;
		while (i <= node.size() && element.compareTo(node.elements.get(i)) > 0 ) {i++;}
		if (i < node.size() && element.equals(node.elements.get(i)))
			return new BNodePosition<>(node,i);
		if (node.isLeaf())
			return new BNodePosition<>();

		return search(node.getChildren().get(i), element);
	}

	@Override
	public void insert(T element) {
		if (element != null)
			insert(element, getCorrectNode(getRoot(), element));
	}

	private void insert(T element, BNode<T> node) {
		if (node.isFull()){
			split(node, element);
			promote(node, element);
		}
		node.addElement(element);
	}

	private BNode<T> getCorrectNode(BNode<T> node, T element) {
		if ((node.isEmpty() || node.isLeaf()) && !node.isFull())
			return node;

		if (node.isLeaf() && node.isFull()){
			return node;
		}

		else {
			int i = 0;
			while (i <= node.size() && element.compareTo(node.getElementAt(i)) > 0 ) {i++;}
			return getCorrectNode(node.getChildren().get(i), element);
		}
	}

	private void split(BNode<T> node, T element) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	private void promote(BNode<T> node, T element) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
