package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		node.setRight(pivot.getRight());
		pivot.setLeft(node);

		if (node.getParent() != null) {
			if (!node.getParent().isEmpty() && !node.getParent().getLeft().isEmpty() && node.getParent().getLeft().getData().equals(node.getData()))
				node.getParent().setLeft(pivot);
			else
				node.getParent().setRight(pivot);
		}

		pivot.setParent(node.getParent());
		node.setParent(pivot);

		return pivot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();
		node.setLeft(pivot.getRight());
		pivot.setRight(node);

		if (node.getParent() != null) {
			if (!(!node.getParent().isEmpty() && !node.getParent().getLeft().isEmpty() && node.getParent().getLeft().getData().equals(node.getData())))
				node.getParent().setLeft(pivot);
			else
				node.getParent().setRight(pivot);
		}

		pivot.setParent(node.getParent());
		node.setParent(pivot);

		return pivot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
