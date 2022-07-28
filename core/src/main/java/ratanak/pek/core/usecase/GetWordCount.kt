package ratanak.pek.core.usecase

import android.util.Log
import ratanak.pek.core.data.Expanse

class GetWordCount {
    operator fun invoke(expanse: Expanse): Int {
        val count = getCount(expanse.title) + getCount(expanse.description)
        Log.e("rtk", "Hello $count")
        return count
    }

    private fun getCount(str: String): Int {
        return str.split(" ", "\n").count {
            it.contains(Regex(".*[a-zA-Z].*"))
        }
    }
}