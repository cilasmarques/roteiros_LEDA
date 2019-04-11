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
    *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
    *   como o selectionsort mas sem modificar nenhuma posicao do array).
    * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null.
    * - Considerar que k varia de 1 a N
    * - Sugestao: o uso de recursao ajudara sua codificacao.
    */
   @Override
   public T getOrderStatistics(T[] array, int k) {
      if (k > array.length || 0 > k)
         return null;
      else
         return selectionSort(array, k, 0);
   }

   //ESSE NEGOCIO TA ESTRANHO... MAS SEGUE AS RESTRIÇÕES :v
   private T selectionSort(T[] a, int k, int index) {

      //definindo elemento para comparação nao nulo
      while (a[index] == null)
         index++;
      int menor = index;

      //condição de parada
      if (k == 1) {
         return a[menor];
      }

      //encontrando o menor elemento
      for (int i = 0; i < a.length; i++)
         if (a[i] != null) {
            if (a[menor].compareTo(a[i]) > 0)
               menor = i;
         }

      //removendo o menor valor do array
      T valorMenor = a[menor];
      a[menor] = null;

      //analisando o resto do array
      T kesimo = selectionSort(a, k - 1, index);

      //recolocando o menor valor do array
      a[menor] = valorMenor;

      return kesimo;
   }
}
