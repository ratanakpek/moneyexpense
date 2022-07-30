package ratanak.pek.core.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import ratanak.pek.core.data.Expense
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class GetExpenseOutOfDate {
    operator fun invoke(expense: Expense): Int {
        return getCountDays(expense.updateTime)
    }

    private fun getCountDays(milliSec: Long): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getDaysByJava8(milliSec)
        } else {
            getDaysByLegacy(milliSec)
        }
    }

    fun getDaysByLegacy(updateTime: Long): Int {
        val date = Date(updateTime)
        val now = Date()
        val remainTime = abs(date.time - now.time)
        return TimeUnit.DAYS.convert(remainTime, TimeUnit.MILLISECONDS).toInt()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getDaysByJava8(milliSec: Long): Int {
        val localDate = Instant.ofEpochMilli(milliSec)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()

        val now = LocalDateTime.now()
        val remainDays = ChronoUnit.DAYS.between(localDate, now)
        return remainDays.toInt()
    }
}