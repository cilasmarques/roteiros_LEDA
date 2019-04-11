package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim poraplciar sucessivas selecoes.
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if(array.length >= k && k > 0) {
			return selectionSort(array, k, selectSmaller(array, k), selectBigger(array, k));
		}
		return null;
	}

	private T selectionSort(T[] array, int k, T previousMinor, T maior) {
		if (k > 1) {
			T actualMinor = maior;

			for (int i = 0; i < array.length; i++) {
				if ((array[i].compareTo(previousMinor) > 0) && (array[i].compareTo(actualMinor) < 0)) {
					actualMinor = array[i];
				}
			}
			return selectionSort(array, k - 1, actualMinor, maior);
		}
		return previousMinor;
	}

	private T selectSmaller(T[] array, int k) {
		T menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(menor) < 0) {

				menor = array[i];

			}
		}
		return menor;
	}

	private T selectBigger(T[] array, int k) {
		T maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(maior) > 0) {
				maior= array[i];
			}
		}
		return maior;
	}

}
