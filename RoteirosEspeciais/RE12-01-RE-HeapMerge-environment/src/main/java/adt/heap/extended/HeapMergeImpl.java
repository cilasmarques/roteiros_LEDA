package adt.heap.extended;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import adt.heap.HeapImpl;

public class HeapMergeImpl extends HeapImpl<Integer> implements HeapMerge {

	public HeapMergeImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer[] mergeArraysAndOrder(List<Integer[]> arrays) {

		for (Integer[] array: arrays){
			for (int i = 0; i < array.length; i ++){
				insert(array[i]);
			}
		}
		return heapsort(heap);
	}

	/*
	@Override
	public Integer[] mergeArraysAndOrder(List<Integer[]> arrays) {
		ArrayList mergeArrays = new ArrayList();
		for (Integer[] array: arrays){
			mergeArrays.add(array);
		}
		Collections.sort(mergeArrays);
		return (Integer[]) mergeArrays.toArray();
	}
	*/

	@Override
	public int sumRange(int k1, int k2) {
		this.comparator = Comparator.reverseOrder();
		Integer[] array = heapsort(this.heap);
		int sumRange = 0;
		for (int i = heap.length - 1; i > k1; i--){
			if (i < k2)
				sumRange += array[i];
		}
		return sumRange;
	}

}
