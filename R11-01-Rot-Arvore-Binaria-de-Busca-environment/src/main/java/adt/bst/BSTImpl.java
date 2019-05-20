package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		if (!isEmpty())
			return height(getRoot());

		return -1;
	}

	private int height(BSTNode<T> node) {
		if (node.isEmpty())
			return 0;
		else
			return 1 + height((BSTNode<T>) node.getLeft()) + height((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> search(T element) {
		if (element == null)
			return null;

		return search(getRoot(), element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		if(node.getData().equals(element))
			return node;

		if(element.compareTo(node.getData()) < 0)
			return search((BSTNode<T>) node.getLeft(), element);
		else
			return search((BSTNode<T>) node.getRight(), element);

	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> maximum() {
		if (!isEmpty())
			return maximum(getRoot());

		return null;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.getRight().isEmpty())
			return node;

		return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (!isEmpty())
			return minimum(getRoot());

		return null;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.getLeft().isEmpty())
			return node;

		return maximum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);

		if (!isEmpty() && node != null)
			return sucessor(node, element);

		return null;
	}

	private BSTNode<T> sucessor(BSTNode<T> node, T element) {
		if (!node.getRight().isEmpty())
			return minimum((BSTNode<T>) node.getRight());

		BTNode<T> previousNode = node.getParent();
		while (!previousNode.isEmpty() && previousNode != null && previousNode.getData().compareTo(node.getData()) <= 0){
			node = (BSTNode<T>) previousNode;
			previousNode = previousNode.getParent();
		}

		if(node.equals(getRoot()) && node.getData().compareTo(element) < 0)
			return null;

		return node;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);

		if (!isEmpty() && node != null)
			return predecessor(node, element);

		return null;
	}

	private BSTNode<T> predecessor(BSTNode<T> node, T element) {
		if (!node.getLeft().isEmpty())
			return maximum((BSTNode<T>) node.getLeft());

		BTNode<T> previousNode = node.getParent();
		while (!previousNode.isEmpty() && previousNode != null && previousNode.getData().compareTo(node.getData()) >= 0){
			node = (BSTNode<T>) previousNode;
			previousNode = previousNode.getParent();
		}

		if(node.equals(getRoot()) && node.getData().compareTo(element) > 0)
			return null;

		return node;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
