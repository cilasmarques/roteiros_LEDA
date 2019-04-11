package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int indiceX = buscaBinaria(array, 0, array.length - 1, x);

		if (indiceX > 0 && indiceX < array.length)
			return (array[indiceX - 1]);
		else
			return null;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int indiceY = buscaBinaria(array, 0, array.length - 1, x);

		if (indiceY >= 0 && indiceY < array.length-1)
			return (array[indiceY + 1]);
		else
			return null;
	}

	private Integer buscaBinaria(Integer[] array, int leftIndex, int rightIndex, Integer elemento) {
		int mid = (rightIndex + leftIndex) / 2;

		if (leftIndex <= rightIndex && rightIndex < array.length) {
			if (array[mid] < elemento) // direita
				return buscaBinaria(array, mid + 1, rightIndex, elemento);

			else if (array[mid] > elemento) //esquerda
				return buscaBinaria(array, leftIndex, mid - 1, elemento);

			else
				return mid;
		}
		else
			return -1;
	}
}
