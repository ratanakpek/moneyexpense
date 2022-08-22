package ratanak.pek.moneyexpense.cleancode.errorhandling

import org.junit.Test
import ratanak.pek.moneyexpense.cleancode.errorhandling.specialcasepattern.Customer
import java.time.LocalDate

class ErrorHandlingTest {

    @Test
    fun `Use Exception Rather Than Return codes`() {
        //LocalDate.parse("Hello-06-12")  //Text 'Hello-06-12' could not be parsed at index 0
        try {
            LocalDate.parse("Hello-06-12")
        } catch (ex: Exception) {

        }
    }

    @Test
    fun `Special case pattern to avoid return null object, hard to check null all the place`() {
        val customerInfo = Customer()
        val info =  customerInfo.getCustomerInfo()

        //need null check
        if (info != null) {
            println(info.getCustomerInfo())
        }

        val infoNonNull = customerInfo.getCustomerInfoNonNull()
        println(infoNonNull.id.toString())
    }

}