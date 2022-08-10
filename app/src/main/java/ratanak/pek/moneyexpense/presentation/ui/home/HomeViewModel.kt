package ratanak.pek.moneyexpense.presentation.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ratanak.pek.core.data.Expense
import ratanak.pek.moneyexpense.framework.expense.UseCases
import ratanak.pek.moneyexpense.framework.di.ApplicationModule
import ratanak.pek.moneyexpense.framework.di.DaggerViewModelComponent
import javax.inject.Inject

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var usecase: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val allExpense = MutableLiveData<List<Expense>>()

    fun getExpenseList() {
        coroutineScope.launch {
            val expenseList = usecase.getAllExpense.invoke()
            expenseList.forEach {
                it.wordCount = usecase.getWordCount.invoke(it)
                it.daysCount = usecase.getExpenseOutOfDate.invoke(it)
            }
            allExpense.postValue(expenseList)
        }
    }

}