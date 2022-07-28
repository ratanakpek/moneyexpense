package ratanak.pek.moneyexpense.framework

import ratanak.pek.core.usecase.*

data class UseCases(
    var createExpanse: CreateExpanse,
    val getAllExpanse: GetAllExpanse,
    val getExpanse: GetExpanse,
    val removeExpanse: RemoveExpanse,
    val getWordCount: GetWordCount
)