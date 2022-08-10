package ratanak.pek.moneyexpense.framework.di

import android.app.Application
import dagger.Module
import dagger.Provides
import ratanak.pek.core.repository.expense.ExpenseRepository
import ratanak.pek.core.repository.notification.NotificationRepository
import ratanak.pek.moneyexpense.framework.expense.RoomExpenseDatasource
import ratanak.pek.moneyexpense.framework.notification.RoomNotificationDatasource

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = ExpenseRepository(RoomExpenseDatasource(app))

    @Provides
    fun provideNotificationRepository(app: Application) = NotificationRepository(RoomNotificationDatasource(app))
}