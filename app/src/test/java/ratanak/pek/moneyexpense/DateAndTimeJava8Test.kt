package ratanak.pek.moneyexpense

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 *
 *
 * https://www.baeldung.com/java-8-date-time-intro
 *
 */
class DateAndTimeJava8Test {

    @Before
    fun `before`(){
        println("============ Start of Coding ==============")
    }

    @After
    fun `After`() {
        println("============ End of Coding ===============")
    }

    @Test
    fun `Working with LocalDate` (){
        //LocalDate.now(ZoneId.systemDefault())
        //LocalDate.now()
        //println(ZoneId.systemDefault())
        val localeDate = LocalDate.now(ZoneId.of("Asia/Phnom_Penh"))
        printTag("1. Zone ID", localeDate)
        println()


        //How to set date or parse date
        val sourceDateAsInt = LocalDate.of(1999, 1, 29)
        printTag("2. Set date with Int value", sourceDateAsInt)
        println()

        printTag("3. How to print ISO LOCAL DATE", DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()))
        println()

        val sourceDateAsString = LocalDate.parse("2022-07-08", DateTimeFormatter.ISO_LOCAL_DATE)
        printTag("4. How to parse date from String", sourceDateAsString)

    }

    private fun printTag(tag: String, message: Any?) {
        print(tag)
        print(" -> ")
        println(message)
    }

}