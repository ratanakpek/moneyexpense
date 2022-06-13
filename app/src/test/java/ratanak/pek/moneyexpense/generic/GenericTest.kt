package ratanak.pek.moneyexpense

import org.junit.Test
import ratanak.pek.moneyexpense.generic.GenericMethodJava
import ratanak.pek.moneyexpense.generic.GenericMethodJava.*
import ratanak.pek.moneyexpense.generic.MyCustomListJava

class GenericTest {

    @Test
    fun `Generic type with method by upper bound wild card`() {
        println(sumOfNumberList(listOf(1, 2.0)))
        println(sumOfNumberList(listOf(1.0, 2L)))
        println(sumOfNumberList(listOf(1L, 2L)))
    }

    @Test
    fun `Generic type with method by lower bound wild card`() {
        val emptyList = arrayListOf<Number>()
        sumOfNumberListSuper(emptyList)
        println(emptyList)
    }

    @Test
    fun `Generic type with method in kotlin without any restriction`() {
        val str = doubleValue("hello")
        val dou = doubleValue(9.0)
        val intV = doubleValue(1)
        println(str + " " + dou + " " + intV)

        val doDuplication = arrayListOf(1, 2, 3)
        GenericMethodJava.duplicate(doDuplication)
        println(doDuplication)

        val doDuplicationStr = arrayListOf("My", "Love")
        GenericMethodJava.duplicate(doDuplication)
        println(doDuplicationStr)
    }


    @Test
    fun `Generic type with java class`() {
//        val customList = MyCustomListJava<String>()
//        customList.addElement("Element One")
//        customList.addElement("Element Two")
//        customList.addElement("Element Three")
//        println(customList)
//        println(customList.get(0))

        val customList =
            MyCustomListJava<Double>()
        customList.addElement(1.0)
        customList.addElement(2.0)
        println(customList)
        println(customList.get(0))

        val customList2 =
            MyCustomListJava<Int>()
        customList2.addElement(1)
        customList2.addElement(2)
        customList2.addElement(3)
        println(customList2)
        println(customList2.get(0))
    }


    @Test
    fun `Generic type with class in Kotlin`() {
        val customList = MyCustomList<String>()
        customList.addElement("Element One")
        customList.addElement("Element Two")
        customList.addElement("Element Three")
        println(customList)
        println(customList.getElementByIndex(0))

        val customList2 = MyCustomList<Int>()
        customList2.addElement(1)
        customList2.addElement(2)
        customList2.addElement(3)
        println(customList2)
        println(customList2.getElementByIndex(0))
    }

}

class MyCustomList<T> {
    private var list = arrayListOf<T>()
    fun addElement(item: T) {
        list.add(item)
    }

    fun removeElement(item: T) {
        list.remove(item)
    }

    override fun toString(): String {
        return list.toString()
    }

    fun getElementByIndex(index: Int): T {
        return list[index]
    }
}