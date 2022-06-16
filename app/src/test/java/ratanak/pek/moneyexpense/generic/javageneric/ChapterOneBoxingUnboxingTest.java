package ratanak.pek.moneyexpense.generic.javageneric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChapterOneBoxingUnboxingTest {

    @Test
    public void compareBoxingAndUnboxing(){
        List<Integer> bigs = Arrays.asList(100,200,300);
        assert sumInteger(bigs) == sum(bigs);

        //object return, if u wanna compare object plz use equal() or unbox first
        assert sumInteger(bigs) != sumInteger(bigs);
        assert sumInteger(bigs).equals(sumInteger(bigs));

        List<Integer> smalls = Arrays.asList(1,2,3);
        assert sumInteger(smalls) == sum(smalls);
        //cache of Integer from -128 -> 127 and 1+2+3=6 is in between, so the result the cache value
        //recommend not to use ==, should use equal()
        assert sumInteger(smalls) == sumInteger(smalls);
    }


    public int sum (List<Integer> ints) {
        int s = 0;
        for (int n : ints) { s += n; }
        return s;
    }

    public static Integer sumInteger(List<Integer> ints) {
        Integer s = 0;
        for (Integer n : ints) { s += n; }
        return s;
    }

    //============================

    @Test
    public void autoBoxingAndUnboxingEquivalent() {
        List<Integer> ints = new ArrayList<>();
        ints.add(Integer.valueOf(1));
        int n = ints.get(9).intValue();
    }

    @Test
    public void autoBoxingAndUnboxing() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        int n = ints.get(9);
    }
}
