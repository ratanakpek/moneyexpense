package ratanak.pek.core.usecase.expense

import ratanak.pek.core.data.Expense

class GetWordCount {
    operator fun invoke(expense: Expense): Int {
        return getCount(expense.title) + getCount(expense.description)
    }

    private fun getCount(str: String): Int {
        return str.split(" ", "\n").count {
            it.contains(Regex(".*[a-zA-Z].*"))
        }
    }
}