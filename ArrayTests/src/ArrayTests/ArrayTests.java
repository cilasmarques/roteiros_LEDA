package ArrayTests;

import java.util.Random;

public class ArrayTests {

    public Integer[] randomArrayMaker(){
        Integer[] array = new Integer[2000];
        Random r = new Random();
        for (int i = 0; i < 2000; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    public Integer[] equalsArrayMaker(){
        Integer[] array = new Integer[2000];
        for (int i = 0; i < 2000; i++) {
            array[i] = 2;
        }
        return array;
    }

    public Integer[] repeatedArrayMaker(){
        Integer[] array = new Integer[2000];
        Random r = new Random();
        int ri = array.length-1;
        for (int i = 0; i < 1000; i++) {
            array[i] = r.nextInt();
            array[ri - i] = array[i];
        }
        return array;
    }

    public Integer[] oddArrayMaker(){
        Integer[] array = new Integer[2001];
        Random r = new Random();
        for (int i = 0; i < 2001; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    public Integer[] sortedArrayMaker(){
        Integer[] array = new Integer[2000];
        for (int i = 0; i < 2000; i++) {
            array[i] = i;
        }
        return array;
    }

    public Integer[] emptyArrayMaker(){
        Integer[] array = {};
        return array;
    }

    public Integer[] nullArrayMaker(){
        Integer[] array = new Integer[2000];
        for (int i = 0; i < 2000; i++) {
            array[i] = null;
        }
        return array;
    }

}
