package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

import java.util.ArrayList;

public class FullRecursiveBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FullRecursiveBST<T> {

	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	@Override
	public BSTNode<T> maximum(){
		return maximum(getRoot());
	}

	private BSTNode<T> maximum(BSTNode node){
		if (node.getRight().isEmpty())
			return node;
		return maximum((BSTNode) node.getRight());
	}


	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	@Override
	public BSTNode<T> minimum(){
		return minimum(getRoot());
	}


	private BSTNode<T> minimum(BSTNode node){
		if (node.getLeft().isEmpty())
			return node;
		return minimum((BSTNode) node.getLeft());
	}


	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a direita
	 * entao o sucessor sera o minimum do filho a direita. Caso contrario
	 * o sucessor sera o primeiro ascendente a ter um valor maior.
	 */
	@Override
	public BSTNode<T> sucessor(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty() && node != null)
				return sucessor(getRoot());
		}
		return null;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> sucessor = minimum(node);
		if (sucessor != null && !sucessor.isEmpty() && sucessor.getData().compareTo(node.getData()) > 0)
			return sucessor;
		else if (node.getParent() != null && node.getParent().getRight() != null)
			return sucessor((BSTNode<T>) node.getParent().getRight());
		return (BSTNode<T>) node.getParent();
	}

	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a esquerda
	 * entao o predecessor sera o maximum do filho a esquerda. Caso contrario
	 * o predecessor sera o primeiro ascendente a ter um valor menor.
	 */
	@Override
	public BSTNode<T> predecessor(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty() && node != null)
				return predecessor(getRoot());
		}
		return null;
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {
		BSTNode<T> predecessor = maximum(node);
		if (predecessor != null && !predecessor.isEmpty() && predecessor.getData().compareTo(node.getData()) < 0)
			return predecessor;
		else if (node.getParent() != null && node.getParent().getLeft() != null && !node.getParent().getLeft().equals(node))
			return predecessor((BSTNode<T>) node.getParent().getLeft());
		else if (node.getParent() != null && node.getParent().getLeft() == null && !node.getParent().getLeft().equals(node))
			return (BSTNode<T>) node.getParent();
		return node;
	}

	@Override
	public T[] elementsAtDistance(int k) {
		ArrayList array = new ArrayList();
		elementsAtDistance(k, getRoot(), array, 0);
		return (T[]) array.toArray();
	}

	private int elementsAtDistance(int k, BSTNode<T> node, ArrayList array, int i) {
		if (k == 0){
			array.add(node.getData());
		} else if ( k > 1) {
			i = elementsAtDistance(k - 1, (BSTNode<T>) node.getRight(), array, i);
			i = elementsAtDistance(k - 1, (BSTNode<T>) node.getLeft(), array, i);
		}
		return i;
	}
}
