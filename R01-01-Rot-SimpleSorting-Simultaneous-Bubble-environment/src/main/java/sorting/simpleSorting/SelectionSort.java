package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean troca = true;

		for(int left = leftIndex; left < rightIndex; left++){
			int menor = left;
			for (int index = left+1; index <= rightIndex; index++){
				if(array[index].compareTo(array[menor]) < 0){
					menor = index;
				}
			}
			Util.swap(array,left,menor);
		}
	}
}
