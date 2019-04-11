package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      if (array != null && array.length > rightIndex && leftIndex >= 0 && leftIndex < rightIndex)
         mergeSort(array, leftIndex, rightIndex);
   }

   public void mergeSort(T[] array, int leftIndex, int rightIndex) {
      if (leftIndex < rightIndex) {
         int mid = (rightIndex + leftIndex) / 2;
         mergeSort(array, leftIndex, mid);
         mergeSort(array, mid + 1, rightIndex);
         merge(array, leftIndex, mid, rightIndex);
      }
   }

   public void merge(T[] array, int leftIndex, int mid, int rightIndex) {

      T[] aux = array.clone();

      int i = leftIndex;
      int j = mid + 1;
      int k = leftIndex;

      while (i <= mid && j <= rightIndex) {
         if (aux[i].compareTo(aux[j]) < 0) {
            array[k] = aux[i];
            i++;
         } else {
            array[k] = aux[j];
            j++;
         }
         k++;
      }

      while (i <= mid) {
         array[k++] = aux[i++];
      }

      while (j <= rightIndex) {
         array[k++] = aux[j++];
      }
   }
}
