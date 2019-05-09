package adt.linkedList.reverseappend;

import adt.linkedList.SingleLinkedListNode;
import org.junit.Test;

public class Teste {

    SingleLinkedListReverseAppendImpl reverseA = new SingleLinkedListReverseAppendImpl();

    @Test
    public void teste1() {
        reverseA.doIt(1);
        reverseA.doIt(2);
        reverseA.doIt(3);
        reverseA.doIt(4);
        reverseA.doIt(5);
        reverseA.doIt(6);
        reverseA.doIt(7);
        reverseA.doIt(8);
        reverseA.doIt(9);
        reverseA.doIt(10);
        reverseA.doIt(11);
        reverseA.doIt(12);

        SingleLinkedListNode aux2 = reverseA.head;

        while (!aux2.isNIL()){
            System.out.println("-- " + aux2.toString());
            aux2 = aux2.getNext();
        }
        System.out.println("ok");

    }

}
