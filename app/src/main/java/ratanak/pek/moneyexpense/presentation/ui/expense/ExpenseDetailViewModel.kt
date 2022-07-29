package ratanak.pek.moneyexpense.presentation.ui.expense

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ratanak.pek.core.data.Expense
import ratanak.pek.moneyexpense.framework.UseCases
import ratanak.pek.moneyexpense.framework.di.ApplicationModule
import ratanak.pek.moneyexpense.framework.di.DaggerViewModelComponent
import javax.inject.Inject

class ExpenseDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    @Inject
    lateinit var usecase: UseCases

    val saved = MutableLiveData<Boolean>()
    val currentExpense = MutableLiveData<Expense?>()

    fun saveExpense(expense: Expense) {
        coroutineScope.launch {
            usecase.createExpense.invoke(expense)
            saved.postValue(true)
        }
    }

    fun getExpense(id: Int) {
        coroutineScope.launch {
            currentExpense.postValue(usecase.getExpense.invoke(id))
        }
    }

    fun deleteExpense(expense: Expense) {
        coroutineScope.launch {
            usecase.removeExpense.invoke(expense)
            saved.postValue(true)
        }
    }

}