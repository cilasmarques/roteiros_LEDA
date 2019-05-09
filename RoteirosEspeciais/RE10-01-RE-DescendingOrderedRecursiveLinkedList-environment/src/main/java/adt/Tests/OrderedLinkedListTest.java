package adt.Tests;

import adt.linkedList.LinkedList;
import adt.linkedList.RecursiveSingleLinkedListImpl;
import adt.linkedList.extended.DescendingOrderedRecursiveLinkedListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedLinkedListTest {

	protected DescendingOrderedRecursiveLinkedListImpl<Integer> lista1;
	protected DescendingOrderedRecursiveLinkedListImpl<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);
		lista1.insert(3);
		lista1.insert(4);
		lista1.insert(4);
		lista1.insert(4);
		lista1.insert(4);
		lista1.insert(6);
		lista1.insert(4);
		lista1.insert(3);
		lista1.insert(4);
		lista1.insert(3);
		lista1.insert(5);

	}

	private void getImplementations() {
		lista1 = new DescendingOrderedRecursiveLinkedListImpl<>();
		lista2 = new DescendingOrderedRecursiveLinkedListImpl<>();
	}

	@Test
	public void max() {
		lista1.setComparator(new Comparator<Integer>() {
			@Override
			public int compare(Integer integer, Integer t1) {
				return integer.compareTo(t1);
			}
		});

		System.out.println(lista1.maximum()); // 6
		System.out.println(lista2.maximum()); // null
	}

	@Test
	public void sortLinkedList() {
		lista1.setComparator(new Comparator<Integer>() {
			@Override
			public int compare(Integer integer, Integer t1) {
				return integer.compareTo(t1);
			}
		});
		lista1.sortLinkedList(lista1);
		System.out.println(Arrays.toString(lista1.toArray()));
	}

	@Test
	public void removeDuplicated() {
		lista1.setComparator(new Comparator<Integer>() {
			@Override
			public int compare(Integer integer, Integer t1) {
				return integer.compareTo(t1);
			}
		});
		lista1.sortLinkedList(lista1);
		System.out.println(Arrays.toString(lista1.toArray()));

		lista1.removeDuplicate(lista1);
		System.out.println(Arrays.toString(lista1.toArray()));

	}
}