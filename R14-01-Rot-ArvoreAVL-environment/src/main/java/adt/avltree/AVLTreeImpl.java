package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if(!node.isEmpty() && node != null)
			return height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		return 0;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		if (balance > 1) {
			BSTNode<T> leftChild = (BSTNode<T>) node.getLeft();
			if (this.calculateBalance(leftChild) <= -1)
				leftRotation(leftChild);
			rightRotation(node);

		} else if (balance < -1) {
			BSTNode<T> rightChild = (BSTNode<T>) node.getRight();
			if (this.calculateBalance(rightChild) >= 1)
				rightRotation(rightChild);
			leftRotation(node);
		}
	}

	private void rightRotation(BSTNode<T> node) {
		BSTNode<T> balancedNode = Util.rightRotation(node);
		if (balancedNode.getParent() == null) {
			this.root = balancedNode;
		}
	}

	private void leftRotation(BSTNode<T> node) {
		BSTNode<T> balancedNode = Util.leftRotation(node);
		if (balancedNode.getParent() == null) {
			this.root = balancedNode;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BTNode<T> parent = node.getParent();
		while(parent!=null){
			rebalance((BSTNode<T>) parent);
			parent= parent.getParent();
		}
	}

	@Override
	public void insert(T element) {
		super.insert(element);
		BSTNode node = search(element);
		rebalanceUp(node);
	}

	@Override
	public void remove(T element) {
		BSTNode node = search(element);
		if(!node.isEmpty()){
			node = super.remove(node);
			rebalanceUp(node);
		}
	}
}
