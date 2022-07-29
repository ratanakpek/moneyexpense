package ratanak.pek.moneyexpense.framework

import ratanak.pek.core.usecase.*

data class UseCases(
    var createExpense: CreateExpense,
    val getAllExpense: GetAllExpense,
    val getExpense: GetExpense,
    val removeExpense: RemoveExpense,
    val getWordCount: GetWordCount
)