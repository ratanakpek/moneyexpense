package ratanak.pek.core.usecase

import ratanak.pek.core.data.Expanse

class GetWordCount {
    operator fun invoke(expanse: Expanse): Int {
        return getCount(expanse.title) + getCount(expanse.description)
    }

    private fun getCount(str: String): Int {
        return str.split(" ", "\n").count {
            it.contains(Regex(".*[a-zA-Z].*"))
        }
    }
}