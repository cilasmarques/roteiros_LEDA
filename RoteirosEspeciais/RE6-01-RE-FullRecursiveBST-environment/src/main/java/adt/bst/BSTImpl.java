package adt.bst;

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
		return height(getRoot());
	}

	private int height(BSTNode<T> node) {
		if (isEmpty())
			return -1;
		return 1 + Math.max(height((BSTNode<T>) node.getRight()), height((BSTNode<T>) node.getLeft()));
	}

	@Override
	public BSTNode<T> search(T element) {
		if (element != null)
			return search(element, getRoot());
		return null;
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		if (node.getData().equals(element))
			return node;
		if (node.getData().compareTo(element) > 0)
			return search(element, (BSTNode<T>) node.getLeft());
		else if (node.getData().compareTo(element) < 0)
			return search(element, (BSTNode<T>) node.getRight());
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null)
			insert(element, getRoot(), null);
	}

	private void insert(T element, BSTNode<T> node, BSTNode<T> parent) {
		if (node.isEmpty()){
			node.setParent(parent);
			node.setData(element);
			node.setRight(new BSTNode<T>());
			node.setLeft(new BSTNode<T>());
		} else {
			if (node.getData().compareTo(element) > 0)
				insert(element, (BSTNode<T>) node.getLeft(), node);
			else if (node.getData().compareTo(element) < 0)
				insert(element, (BSTNode<T>) node.getRight(), node);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(getRoot());
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.isEmpty() || node == null)
			return null;
		if (node.getRight().isEmpty())
			return node;
		else
			return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(getRoot());
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.isEmpty() || node == null)
			return null;
		if (node.getLeft().isEmpty())
			return node;
		else
			return maximum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (node != null && !node.isEmpty())
			return sucessor(node);
		return null;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> sucessor = minimum(node);
		if (sucessor == null || sucessor.isEmpty()){
			sucessor = (BSTNode<T>) sucessor.getParent();
			while (sucessor != null && !sucessor.isEmpty() && sucessor.getData().compareTo(node.getData()) < 0)
				sucessor = (BSTNode<T>) sucessor.getParent();
		}

		if (sucessor.isEmpty() || sucessor == null)
			return null;
		else
			return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (node != null && !node.isEmpty())
			return predecessor(node);
		return null;
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {
		BSTNode<T> predecessor = maximum(node);
		if (predecessor == null || predecessor.isEmpty()){
			predecessor = (BSTNode<T>) predecessor.getParent();
			while (predecessor != null && !predecessor.isEmpty() && predecessor.getData().compareTo(node.getData()) > 0)
				predecessor = (BSTNode<T>) predecessor.getParent();
		}

		if (predecessor.isEmpty() || predecessor == null)
			return null;
		else
			return predecessor;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (node != null && !node.isEmpty())
				remove(getRoot());
		}
	}

	private void remove(BSTNode<T> node) {
		boolean onlyRightChild = node.getLeft() == null && node.getRight() != null;
		boolean onlyLeftChild = node.getRight() == null && node.getLeft() != null;

		if (node.isLeaf())
			node.setData(null);
		if (onlyLeftChild || onlyRightChild)
			removeOneChild(node);
		else 
			removeTwoChild(node);
	}


	private void removeOneChild(BSTNode<T> node) {
		if(node.getParent() != null){
			if(isLeftChild(node)) {
				if (!node.getLeft().isEmpty() && node.getLeft() != null){
					node.getParent().setLeft(node.getLeft());
					node.getLeft().setParent(node.getParent());
				} else {
					node.getParent().setLeft(node.getRight());
					node.getRight().setParent(node.getParent());
				}
			} else {
				if(!node.getRight().isEmpty() && node.getRight() != null){
					node.getParent().setRight(node.getRight());
					node.getRight().setParent(node.getParent());
				} else {
					node.getParent().setRight(node.getLeft());
					node.getLeft().setParent(node.getParent());
				}
			}
		} else {
			if (node.getLeft().isEmpty())
				root = (BSTNode<T>) node.getRight();
			else
				root = (BSTNode<T>) node.getLeft();
			root.setParent(null);
		}
	}

	private void removeTwoChild(BSTNode<T> node) {
		BSTNode tempNode = sucessor(node);
		node.setData((T) tempNode.getData());
		remove(tempNode);
	}

	private boolean isLeftChild(BSTNode<T> node) {
		return node.getParent().getLeft().equals(node);
	}

	@Override
	public T[] preOrder() {
		//raiz, esquerda, direita
		T[] array = (T[]) new Comparable[size()];
		preOrder(array, getRoot(), 0);
		return array;
	}

	private int preOrder(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()){
			array[index] = node.getData();
			index++;
			index = preOrder(array, (BSTNode<T>) node.getLeft(), index);
			index = preOrder(array, (BSTNode<T>) node.getRight(), index);
		}
		return index;
	}

	@Override
	public T[] order() {
		// esquerda, raiz, direita
		T[] array = (T[]) new Comparable[size()];
		order(array, getRoot(), 0);
		return array;

	}

	private int order(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()){
			index = order(array, (BSTNode<T>) node.getLeft(), index);
			array[index] = node.getData();
			index++;
			index = order(array, (BSTNode<T>) node.getRight(), index);
		}
		return index;
	}

	@Override
	public T[] postOrder() {
		// esquerda, direita, raiz
		T[] array = (T[]) new Comparable[size()];
		postOrder(array, getRoot(), 0);
		return array;

	}

	private int postOrder(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()){
			index = postOrder(array, (BSTNode<T>) node.getLeft(), index);
			index = postOrder(array, (BSTNode<T>) node.getRight(), index);
			array[index] = node.getData();
			index++;
		}
		return index;
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
