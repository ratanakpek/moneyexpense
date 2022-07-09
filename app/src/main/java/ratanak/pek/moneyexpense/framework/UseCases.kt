package ratanak.pek.moneyexpense.framework

import ratanak.pek.core.usecase.CreateExpanse
import ratanak.pek.core.usecase.GetAllExpanse
import ratanak.pek.core.usecase.GetExpanse
import ratanak.pek.core.usecase.RemoveExpanse

data class UseCases(
    var createExpanse: CreateExpanse,
    val getAllExpanse: GetAllExpanse,
    val getExpanse: GetExpanse,
    val removeExpanse: RemoveExpanse
)