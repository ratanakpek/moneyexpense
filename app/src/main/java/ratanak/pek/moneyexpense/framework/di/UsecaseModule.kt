package ratanak.pek.moneyexpense.framework.di

import dagger.Module
import dagger.Provides
import ratanak.pek.core.repository.ExpenseRepository
import ratanak.pek.core.usecase.*
import ratanak.pek.moneyexpense.framework.UseCases

@Module
class UsecaseModule {

    @Provides
    fun getUseCases(repository: ExpenseRepository) = UseCases(
        CreateExpense(repository),
        GetAllExpense(repository),
        GetExpense(repository),
        RemoveExpense(repository),
        GetWordCount(),
        GetExpenseOutOfDate()
    )
}