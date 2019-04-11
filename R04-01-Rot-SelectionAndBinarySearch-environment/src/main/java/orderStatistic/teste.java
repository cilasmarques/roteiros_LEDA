package orderStatistic;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class teste {

    OrderStatisticsSelectionImpl teste = new OrderStatisticsSelectionImpl();

    @Test
    public void teste() {
        Integer[] inteiros = {9,3,0,1,5,7,2,8,4,6};

        Integer elemento1 = (Integer) teste.getOrderStatistics(inteiros, 5);
        System.out.println(elemento1);
        System.out.println(Arrays.toString(inteiros));
        //Nao alterou o array

        Integer elemento2 = (Integer) teste.getOrderStatistics(inteiros, -1);
        System.out.println(elemento2);
        System.out.println(Arrays.toString(inteiros));
        //Nao alterou o array

        Integer elemento3 = (Integer) teste.getOrderStatistics(inteiros, 20);
        System.out.println(elemento3);
        System.out.println(Arrays.toString(inteiros));
        //Nao alterou o array

    }

}
