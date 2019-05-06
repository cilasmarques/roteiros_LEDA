import adt.linkedList.batch.BatchLinkedListImpl;
import org.junit.Test;
import util.GenericException;

public class Tests {

    @Test
    public void teste1() throws GenericException {
        BatchLinkedListImpl bl = new BatchLinkedListImpl();
        Integer[] a = new Integer[4];

        System.out.println(bl.toString());

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;

        bl.inserirEmBatch(0, a);
        System.out.println(bl.toString());
    }

}
