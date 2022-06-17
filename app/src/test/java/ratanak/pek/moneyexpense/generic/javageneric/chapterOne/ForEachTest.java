package ratanak.pek.moneyexpense.generic.javageneric.chapterOne;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEachTest {

    @Test
    public void forEachTest() {
        List<Integer> lists = Arrays.asList(1, 2, 3);
        int sum = 0;
        for (int i : lists) {
            sum += i;
        }
        assert sum == 6;
    }

    @Test
    public void forEachProcessDetail() {
        List<Integer> lists = Arrays.asList(1, 2, 3);
        int sum = 0;
        for (Iterator<Integer> ints = lists.iterator(); ints.hasNext(); ) {
            sum+= ints.next();
        }
        assert sum == 6;
    }

    @Test
    public void compareTwoValue(){
        assert 14 == dot(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(1.0, 2.0, 3.0));
    }

    public double dot(List<Double> u, List<Double> v) {
        if (u.size() != v.size())
            throw new IllegalArgumentException("different sizes");
        double d = 0;
        Iterator<Double> uIt = u.iterator();
        Iterator<Double> vIt = v.iterator();
        while (uIt.hasNext()) {
            assert uIt.hasNext() && vIt.hasNext();
            d += uIt.next() * vIt.next();
        }
        assert !uIt.hasNext() && !vIt.hasNext();
        return d;
    }

}
