package sorting.variationsOfSelectionsort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RecursiveSelectionSortTest {

    RecursiveSelectionSort rs = new RecursiveSelectionSort();

    @Test
    public void testSort1(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        rs.sort(arrayInteiros, 0, 9);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }


    @Test
    public void testSort2(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        rs.sort(arrayInteiros, 0, 0);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[9, 0, 3, 6, 2, 7, 5, 4, 1, 8]");
    }

    @Test
    public void testSort3(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        rs.sort(arrayInteiros, 0, 5);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[0, 2, 3, 6, 7, 9, 5, 4, 1, 8]");
    }

    @Test
    public void testSort4(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        rs.sort(arrayInteiros, 9, 10);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[9, 0, 3, 6, 2, 7, 5, 4, 1, 8]");
    }

    @Test
    public void testSort5(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        rs.sort(arrayInteiros, -1, 11);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[9, 0, 3, 6, 2, 7, 5, 4, 1, 8]");
    }

    @Test
    public void testSort6(){
        Integer[] arrayInteiros = {9,0,3,6,2,7,5,4,1,8};
        rs.sort(arrayInteiros, 5, 9);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[9, 0, 3, 6, 2, 1, 4, 5, 7, 8]");
    }

    @Test
    public void testSort7(){
        Integer[] arrayInteiros = {9,0,3,6,10,2,7,5,4,1,8};
        rs.sort(arrayInteiros, 0, 10);
        Assert.assertEquals(Arrays.toString(arrayInteiros), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

}
