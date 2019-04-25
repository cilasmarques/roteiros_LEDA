package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);

		//Lista com 10 elementos
		lista9.insert(9);
		lista9.insert(8);
		lista9.insert(7);
		lista9.insert(6);
		lista9.insert(5);
		lista9.insert(5);
		lista9.insert(4);
		lista9.insert(3);
		lista9.insert(2);
		lista9.insert(1);

	}

	private void getImplementations() {
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
		lista9 = new SingleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}


	@Test
	public void test2() {
		lista9.remove(5);
		Assert.assertEquals(9, lista9.size());
		Assert.assertArrayEquals(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, lista9.toArray());
		lista9.remove(5);
		Assert.assertEquals(8, lista9.size());
		Assert.assertArrayEquals(new Integer[] { 9, 8, 7, 6, 4, 3, 2, 1 }, lista9.toArray());
	}
}