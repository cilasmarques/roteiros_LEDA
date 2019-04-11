package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for (int index = leftIndex+1; index<=rightIndex; index++){
			int anterior = index - 1;
			while(index > leftIndex && array[index].compareTo(array[anterior]) < 0){
				Util.swap(array,index,anterior);
				index -= 1;
				anterior -= 1;
			}
		}
	}
}