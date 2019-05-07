package adt.linkedList.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentSetLinkedListTest {

   protected SetLinkedListImpl<Integer> lista1;
   protected SetLinkedListImpl<Integer> lista2;

   @Before
   public void setUp() throws Exception {

      getImplementations();

      lista1.insert(1);
      lista1.insert(2);
      lista1.insert(3);
      lista1.insert(3);
      lista1.insert(3);
      lista1.insert(2);

      lista2.insert(1);
      lista2.insert(4);
      lista2.insert(5);
   }

   private void getImplementations() {
      lista1 = new SetLinkedListImpl<>();
      lista2 = new SetLinkedListImpl<>();
   }

   @Test
   public void testConcatenate() {
      Assert.assertArrayEquals(new Integer[] { 1, 4, 5 }, lista2.toArray());
      Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 3, 3, 2 }, lista1.toArray());
      lista1.concatenate(lista2);
      Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 3, 3, 2, 1, 4, 5 }, lista1.toArray());
   }

   @Test
   public void testRemoveD() {
      Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 3, 3, 2 }, lista1.toArray());
      lista1.removeDuplicates();
      Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, lista1.toArray());
   }

   @Test
   public void testUnion() {
      Assert.assertArrayEquals(new Integer[] { 1, 4, 5 }, lista2.toArray());
      Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 3, 3, 2 }, lista1.toArray());
      SetLinkedList<Integer> a = lista1.union(lista2);
      Assert.assertArrayEquals(new Integer[] { 1, 4, 5, 1, 2, 3, 3, 3, 2 }, a.toArray());
   }

   @Test
   public void testIntersection() {
      Assert.assertArrayEquals(new Integer[] { 1, 4, 5 }, lista2.toArray());
      Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 3, 3, 2 }, lista1.toArray());
      SetLinkedList<Integer> a = lista1.intersection(lista2);
      Assert.assertArrayEquals(new Integer[] { 1 }, a.toArray());
   }

}