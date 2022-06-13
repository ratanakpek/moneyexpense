package ratanak.pek.moneyexpense.datejava8

import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

/**
 *
 *
 * https://www.baeldung.com/java-8-date-time-intro
 */
class DateFormatUtilTest {

    //LocalDate	-> Represents a date (year, month, day (yyyy-MM-dd))
    @Test
    fun printLocalDate() {
        val date = LocalDate.now()
        val ldt = date.atTime(1, 5)
        val ldtAndMinus1Year = ldt.minusYears(1)
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        println(ldtAndMinus1Year.format(formatter))
    }

    //LocalTime -> Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
    @Test
    fun printLocaltime() {
        val date = LocalTime.now()
        println(date)
    }

    //LocalDateTime -> Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
    @Test
    fun printLocalDateTime() {
        val date = LocalDateTime.now()
        //date.atT(23, 59)
        // val myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

        println(date)
    }

    //DateTimeFormatter -> Formatter for displaying and parsing date-time objects
    @Test
    fun printDateTimeFormatter() {
        val myDateObj = LocalDateTime.now()
        println("Before formatting: $myDateObj")
        val myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

        val formattedDate = myDateObj.format(myFormatObj)
        println("After formatting: $formattedDate")
    }

    @Test
    fun `How to find tomorrow`() {
        val date = LocalDate.now().plusDays(1)
        println(date)
    }

    @Test
    fun `How to last month`() {
        val date = LocalDate.now().minus(1, ChronoUnit.MONTHS)
        println(date)
    }

    @Test
    fun `How to get DayOfWeek`() {
        val dayOfWeek = LocalDate.parse("2022-06-06").dayOfWeek
        println(dayOfWeek)
    }


    @Test
    fun `Print all time zone id`() {
        println(ZoneId.getAvailableZoneIds())

        val zoneId = ZoneId.of("Asia/Bangkok")

        val zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId)
        println(zonedDateTime)
    }


}