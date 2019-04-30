package orderStatistic;

import org.junit.Assert;
import org.junit.Test;

public class OrderStatisticsSelectionTest<T> {

    OrderStatisticsSelectionImpl oss = new OrderStatisticsSelectionImpl();

    @Test
    public void testSort0(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, -1);
        System.out.println("expected: null " + x);
    }

    @Test
    public void testSort1(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 0);
        System.out.println("expected: null " + x);
    }

    @Test
    public void testSort2(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 1);
        System.out.println("expected: 0 " + x);
    }

    @Test
    public void testSort3(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 3);
        System.out.println("expected: 2 " + x);
    }

    @Test
    public void testSort4(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 5);
        System.out.println("expected: 4 " + x);
    }

    @Test
    public void testSort5(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 8);
        System.out.println("expected: 7 " + x);
    }

    @Test
    public void testSort6(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 9);
        System.out.println("expected: 8 " + x);
    }

    @Test
    public void testSort7() {
        Integer[] arrayInteiros = {9, 0, 3, 6, 2, 7, 5, 4, 1, 8};
        T x = (T) oss.getOrderStatistics(arrayInteiros, 10);
        System.out.println("expected: 9 " + x);
    }

}



