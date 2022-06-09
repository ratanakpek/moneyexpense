package ratanak.pek.moneyexpense

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
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
class LocalDateJava8Test {

    @Before
    fun `before`() {
        println("============ Start of Coding ==============")
    }

    @After
    fun `After`() {
        println("============ End of Coding ===============")
    }

    @Test
    fun `1 How to get zone id`() {
        printTag("ZoneId.systemDefault()", ZoneId.systemDefault())
        val localeDate = LocalDate.now(ZoneId.of("Asia/Phnom_Penh"))
        printTag("LocalDate.now(ZoneId.of(\"Asia/Phnom_Penh\"))", localeDate)
        println()
    }

    @Test
    fun `2 of method from LocalDate`() {
        val sourceDateAsInt = LocalDate.of(1999, 1, 29)
        printTag("LocalDate.of(1999, 1, 29)", sourceDateAsInt)
        println()
    }

    @Test
    fun `3 Date time formatter with ISO Local date`() {
        val sourceDateAsString = LocalDate.parse("2022-07-08", DateTimeFormatter.ISO_LOCAL_DATE)
        printTag(
            "LocalDate.parse(\"2022-07-08\", DateTimeFormatter.ISO_LOCAL_DATE)",
            sourceDateAsString
        )
        println()
    }

    @Test
    fun `4 plus & minus day, month, year`() {
        printTag("LocalDate for Tomorrow is ", LocalDate.now().plusDays(1))
        printTag("LocalDate for Yesterday is ", LocalDate.now().plusDays(-1))
        printTag("LocalDate for Yesterday is ", LocalDate.now().minusDays(1))
        printTag("LocalDate for Next week is ", LocalDate.now().plusWeeks(1))

        //Create LocalDate.now() but change day to 5
        printTag("LocalDate.now().withDayOfYear(5)", LocalDate.now().withDayOfYear(5))

        //minus 1 month
        val previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS)
        printTag("PreviousMonthSameDay ", previousMonthSameDay)
    }

    @Test
    fun `How extract day, month, year from string`() {
        printTag("Get day of week", LocalDate.parse("2022-06-09").dayOfWeek)
        printTag("Get day of month", LocalDate.parse("2022-06-09").dayOfMonth)
    }

    @Test
    fun `isBefore() and isAfter()`() {
        val isBefore = LocalDate.parse("2016-06-12")
            .isBefore(LocalDate.parse("2016-06-11"))
        printTag("isBefore ", isBefore)

        val isAfter = LocalDate.parse("2016-06-12")
            .isAfter(LocalDate.parse("2016-06-11"))
        printTag("isAfter", isAfter)
    }

    @Test
    fun `Parse string into LocalDateTime with atStartOfDay() method`() {
        val beginningOfDay: LocalDateTime = LocalDate.parse("2016-06-12").atStartOfDay()
        printTag("beginningOfDay", beginningOfDay)

        //it should be day 12 but we call firstDayOfMonth() to get LocalDateTime
        val firstDayOfMonth = LocalDate.parse("2016-06-12")
            .with(TemporalAdjusters.firstDayOfMonth())
        printTag("firstDayOfMonth", firstDayOfMonth)
    }

    @Test
    fun `Working with LocalTime`() {
        println(LocalTime.now())
    }

    private fun printTag(tag: String, message: Any?) {
        print(tag)
        print(" -> ")
        println(message)
    }
}