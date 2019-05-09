package problems;


import org.junit.Test;

public class teste2 {

    FloorCeilBinarySearch teste2 = new FloorCeilBinarySearch();

    @Test
    public void teste() {
        Integer[] inteiros = {0,1,2,3,4,6,7,8,9};
        Integer ceil1 = teste2.ceil(inteiros, 10);
        Integer floor1 = teste2.floor(inteiros, -1);
        System.out.println(ceil1);
        System.out.println(floor1);

        Integer ceil2 = teste2.ceil(inteiros, 5);
        Integer floor2 = teste2.floor(inteiros, 5);
        System.out.println(ceil2);
        System.out.println(floor2);


        Integer ceil3 = teste2.ceil(inteiros, 0);
        Integer floor3 = teste2.floor(inteiros, 9);
        System.out.println(ceil3);
        System.out.println(floor3);
    }

}
