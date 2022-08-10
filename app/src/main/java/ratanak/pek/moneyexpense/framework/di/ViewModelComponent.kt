package ratanak.pek.moneyexpense.framework.di

import dagger.Component
import ratanak.pek.moneyexpense.presentation.ui.expense.ExpenseDetailViewModel
import ratanak.pek.moneyexpense.presentation.ui.home.HomeViewModel
import ratanak.pek.moneyexpense.presentation.ui.notifications.NotificationsViewModel

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UsecaseModule::class])
interface ViewModelComponent {

    fun inject(homeViewModel: HomeViewModel)

    fun inject(expenseViewModel: ExpenseDetailViewModel)

    fun inject(notificationsViewModel: NotificationsViewModel)
}