package ratanak.pek.moneyexpense.generic.javageneric

import org.junit.Test
import java.util.*

class WildCardTest {
    @Test
    fun wildcardOfConnectionMethodAddAll() {
        val nums: MutableList<Number> = ArrayList()
        val ints: List<Int> = Arrays.asList(1, 2)
        val dbls: List<Double> = Arrays.asList(2.78, 3.14)
        nums.addAll(ints)
        nums.addAll(dbls)
        assert(nums.toString() == "[1, 2, 2.78, 3.14]")
    }

    @Test
    fun listof() {
        val ints: MutableList<Int> = ArrayList<Int>()
        ints.add(1)
        ints.add(2)
        val nums: List<Number?> = ints
        //nums.add(3.14) // compile-time error
        assert(ints.toString() == "[1, 2, 3.14]")
    }

}