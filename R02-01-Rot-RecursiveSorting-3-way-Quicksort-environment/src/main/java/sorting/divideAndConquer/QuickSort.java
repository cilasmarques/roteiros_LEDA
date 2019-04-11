package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      if (array != null && array.length > rightIndex && leftIndex >= 0 && leftIndex < rightIndex)
         quickSort(array, leftIndex, rightIndex);
   }

   private void quickSort(T[] array, int leftIndex, int rightIndex) {
      if (leftIndex < rightIndex) {
         int particion = particion(array, leftIndex, rightIndex);
         quickSort(array, leftIndex, particion - 1);
         quickSort(array, particion + 1, rightIndex);
      }
   }

   private int particion(T[] array, int leftIndex, int rightIndex) {

      int i = leftIndex + 1;
      int j = rightIndex;
      int p = leftIndex;

      while (i <= j) {
         if (array[i].compareTo(array[p]) <= 0) {
            i++;
         } else if (array[j].compareTo(array[p]) > 0) {
            j--;
         } else if (i <= j) {
            Util.swap(array, i, j);
         }
      }

      Util.swap(array, leftIndex, j);

      return j;
   }
}
