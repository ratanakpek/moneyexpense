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
class LocalTimeJava8Test {

    @Before
    fun `before`() {
        println("============ Start of Coding ==============")
    }

    @After
    fun `After`() {
        println("============ End of Coding ===============")
    }

    @Test
    fun `How to get zone id`() {
        printTag("ZoneId.systemDefault()", ZoneId.systemDefault())
        val localeDate = LocalTime.now(ZoneId.of("Asia/Phnom_Penh"))
        printTag("LocalDate.now(ZoneId.of(\"Asia/Phnom_Penh\"))", localeDate)
        println()
    }

    private fun printTag(tag: String, message: Any?) {
        print(tag)
        print(" -> ")
        println(message)
    }

}