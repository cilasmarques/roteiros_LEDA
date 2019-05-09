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

        SingleLinkedListNode aux2 = reverseA.head;

        while (!aux2.isNIL()){
            System.out.println("-- " + aux2.toString());
            aux2 = aux2.getNext();
        }
        System.out.println("ok");

    }

}
