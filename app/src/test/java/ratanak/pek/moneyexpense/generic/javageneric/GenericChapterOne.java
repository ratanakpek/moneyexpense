package ratanak.pek.moneyexpense.generic.javageneric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GenericChapterOne {

    @Test
    public void concatHelloWorldStringFromList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello ");
        stringList.add("World!");
        String concatString = stringList.get(0) + stringList.get(1);
        assert concatString.equals("Hello World!");
    }

    @Test
    public void sumUpArrayElement() {
        int[] arrayElement = new int[]{1, 2, 3};
        int total = 0;
        for (int i = 0; i < arrayElement.length; i++) {
            total += arrayElement[i];
        }
        assert total == 6;
    }

    @Test
    public void sumUpArrayElementBeforeGeneric() {
        List ints = Arrays.asList(new Integer[]{
                new Integer(1), new Integer(2), new Integer(3)
        });
        int total = 0;
        for (Iterator it = ints.iterator(); it.hasNext(); ) {
            int nItem = ((Integer) it.next()).intValue();
            total += nItem;
        }
        assert total == 6;
    }

    @Test
    public void sumUpArrayElementAsList() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int total = 0;
        for (int item : list) {
            total = item + total;
        }
        assert total == 6;
    }
}
