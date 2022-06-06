package ratanak.pek.moneyexpense

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

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

        printTag("5. LocalDate for Tomorrow is ", LocalDate.now().plusDays(1))
        printTag("6. LocalDate for Yesterday is ", LocalDate.now().plusDays(-1))
        printTag("6. LocalDate for Yesterday is ", LocalDate.now().minusDays(1))
        printTag("7. LocalDate for Next week is ", LocalDate.now().plusWeeks(1))
        printTag("8.",  LocalDate.now().withDayOfYear(5))

        val previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS)
        printTag("9. previousMonthSameDay ",  previousMonthSameDay)

        printTag("10. Get day of week", LocalDate.parse("2022-06-09").dayOfWeek)
        printTag("11. Get day of month", LocalDate.parse("2022-06-09").dayOfMonth)

        val isBefore = LocalDate.parse("2016-06-12")
            .isBefore(LocalDate.parse("2016-06-11"))
        printTag("12. ", isBefore)

        val isAfter = LocalDate.parse("2016-06-12")
            .isAfter(LocalDate.parse("2016-06-11"))
        printTag("13. ", isAfter)


        val beginningOfDay: LocalDateTime = LocalDate.parse("2016-06-12").atStartOfDay()
            printTag("14. ", beginningOfDay)

        val firstDayOfMonth = LocalDate.parse("2016-06-12")
            .with(TemporalAdjusters.firstDayOfMonth())
        printTag("15. ", firstDayOfMonth)

    }

    private fun printTag(tag: String, message: Any?) {
        print(tag)
        print(" -> ")
        println(message)
    }

}