package ratanak.pek.moneyexpense.generic.javageneric.chapterOne;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

    @Test
    public void test(){
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        //nums.add(3.45); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
    }
}
