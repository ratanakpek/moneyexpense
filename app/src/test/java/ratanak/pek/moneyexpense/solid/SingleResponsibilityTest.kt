package ratanak.pek.moneyexpense

import org.junit.Assert
import org.junit.Test
import ratanak.pek.moneyexpense.experiment.solid.singleresponsibility.Crush
import ratanak.pek.moneyexpense.experiment.util.ConnectionMockUp

class SingleResponsibilityTest {

    @Test
    fun `save test`() {
        val myCrush = Crush()
        val connectionMockUp = ConnectionMockUp()
        connectionMockUp.save(myCrush)
    }


    @Test
    fun `How to use get&set in kotlin`() {
        val myCrush = Crush()
        //1. Enter valid name
        myCrush.validName = "Mrs.BB"
        Assert.assertEquals("Mrs.BB", myCrush.validName)

        //2. Name length not greater than 3, so it throw exception
        Assert.assertThrows(IllegalArgumentException::class.java) {
            myCrush.validName = "Mrs"
        }


        //3. Enter valid age
        myCrush.validAge = 18
        Assert.assertEquals(18, myCrush.validAge)

        //4. Invalid age
        Assert.assertThrows(IllegalArgumentException::class.java) {
            myCrush.validAge = 12
        }
    }
}
