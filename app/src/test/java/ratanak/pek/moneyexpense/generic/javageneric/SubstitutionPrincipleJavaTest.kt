package ratanak.pek.moneyexpense.generic.javageneric

import org.junit.Test

class SubstitutionPrincipleJavaTest {
    @Test
    fun doSubstitutionPrincipleJava() {
        val nums: MutableList<Number> = ArrayList()
        nums.add(2)
        nums.add(3.14)
        nums.add(2.3f)
        assert(nums.toString() == "[2, 3.14, 2.3]")
    }

    @Test
    fun `Is List type of Integer equal List of type Number ---- no`() {
        val ints: MutableList<Int> = ArrayList()
        ints.add(1)
        ints.add(2)
//        ints.add(1.2)
        val nums: List<Number> = ints
        // compile-time error
        // nums.add(3.14)
        assert(ints.toString() == "[1, 2, 3.14]")
    }
}