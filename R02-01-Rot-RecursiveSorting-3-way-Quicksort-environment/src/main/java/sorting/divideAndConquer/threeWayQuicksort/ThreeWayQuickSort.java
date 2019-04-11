package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot.
	 *
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot.
	 *
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente.
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

	if (leftIndex < 0) {
			leftIndex = 0;
		}
		if (rightIndex > array.length - 1) {
			rightIndex = array.length - 1;
		}

		if ((array != null) && (array.length > 0) && (leftIndex < rightIndex)) {
			quickSortMedianOfThree(array, leftIndex, rightIndex);
		}
	}

	private void quickSortMedianOfThree(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			if ((rightIndex - leftIndex) <= 3) {
				bubble(array, leftIndex, rightIndex);
			} else {
				int median = med(array, leftIndex, rightIndex);
				Util.swap(array, median, rightIndex - 1);
				int pos_pivot = particiona(array, leftIndex, rightIndex);
				quickSortMedianOfThree(array, leftIndex, pos_pivot - 1);
				quickSortMedianOfThree(array, pos_pivot + 1, rightIndex);
			}
		}
	}

	public int particiona(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int i = leftIndex;
		for (int j = leftIndex + 1; j < rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

	public int med(T[] array, int leftIndex, int rightIndex) {

		int center = (leftIndex + rightIndex) / 2;

		if (array[center].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, rightIndex, center);
		}
		if (array[center].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, leftIndex, center);
		}
		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}

		return center;

	}

	private void bubble(T[] array, int ini, int fim) {
		boolean achou;
		do {
			achou = false;
			for (int i = ini; i < fim; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					achou = true;
					Util.swap(array, i, i + 1);
				}
			}

		} while (achou);
	}
}
