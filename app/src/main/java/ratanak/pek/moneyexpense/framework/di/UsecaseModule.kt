package ratanak.pek.moneyexpense.framework.di

import dagger.Module
import dagger.Provides
import ratanak.pek.core.repository.expense.ExpenseRepository
import ratanak.pek.core.repository.notification.NotificationRepository
import ratanak.pek.core.usecase.expense.*
import ratanak.pek.moneyexpense.framework.expense.UseCases
import ratanak.pek.moneyexpense.framework.notification.NotificationUseCases

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

    @Provides
    fun getNotificationUseCase(repository: NotificationRepository) = NotificationUseCases(repository)
}