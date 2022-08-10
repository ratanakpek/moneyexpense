package ratanak.pek.moneyexpense.framework.expense

import ratanak.pek.core.usecase.expense.*

data class UseCases(
    var createExpense: CreateExpense,
    val getAllExpense: GetAllExpense,
    val getExpense: GetExpense,
    val removeExpense: RemoveExpense,
    val getWordCount: GetWordCount,
    val getExpenseOutOfDate: GetExpenseOutOfDate
)