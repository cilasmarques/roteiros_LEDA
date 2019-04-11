package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {

      if ((leftIndex < rightIndex) && (rightIndex < array.length)) {
		  extendedCountingSort(array, leftIndex, rightIndex);
      }
   }

   private void extendedCountingSort(Integer[] array, int leftIndex, int rightIndex) {

      int maiorInd = maiorIndice(array, leftIndex, rightIndex);
      int menorInd = menorIndice(array, leftIndex, rightIndex);

      //Criando array de frequencia zerada
      int[] frequencia = new int[array[maiorInd] - array[menorInd] + 1];

      //Contando a frequencia
      for (int i = leftIndex; i <= rightIndex; i++) {
         int key = array[i] - array[menorInd];
         frequencia[key] += 1;
      }

      //Somando frequencia[i] e frequencia[i-1]
      for (int i = 1; i < frequencia.length; i++) { //
         frequencia[i] += frequencia[i - 1];
      }

      //Inserindo o numero na posição certa
      int[] resultado = new int[array.length];
      for (int i = leftIndex; i <= rightIndex; i++) {
         resultado[frequencia[array[i] - array[menorInd]] - 1] = array[i];
         frequencia[array[i] - array[menorInd]]--;
      }

	   //Transmitindo resultado para o array original
	   int index = 0;
      for (int i = leftIndex; i <= rightIndex; i++) {
         array[i] = resultado[index - leftIndex];
         index++;
      }

   }

   private int maiorIndice(Integer[] array, int leftIndex, int rightIndex) {
      int maior = leftIndex;
      for (int index = leftIndex + 1; index <= rightIndex; index++) {
         if (array[index] > array[maior]) {
            maior = index;
         }
      }
      return maior;
   }

   private int menorIndice(Integer[] array, int leftIndex, int rightIndex) {
      int menor = leftIndex;
      for (int index = leftIndex + 1; index <= rightIndex; index++) {
         if (array[index] < array[menor]) {
            menor = index;
         }
      }
      return menor;
   }
}
