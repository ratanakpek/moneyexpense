package ratanak.pek.moneyexpense.designpattern.singleton

import org.junit.Assert
import org.junit.Test
import ratanak.pek.moneyexpense.experiment.designpattern.singleton.Singleton

class SingletonTest {
    @Test
    fun testSingletonTest() {
        val singleton = Singleton.getInstance()
        singleton.name = "Hello World"

        val secondSingleton = Singleton.getInstance()
        secondSingleton.name="Test"

        Assert.assertEquals(secondSingleton.name, singleton.name)
    }

}