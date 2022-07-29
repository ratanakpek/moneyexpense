package ratanak.pek.moneyexpense.framework.di

import android.app.Application
import dagger.Module
import dagger.Provides
import ratanak.pek.core.repository.ExpenseRepository
import ratanak.pek.moneyexpense.framework.RoomExpenseDatasource

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = ExpenseRepository(RoomExpenseDatasource(app))
}