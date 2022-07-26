package ratanak.pek.moneyexpense.presentation.ui.expanse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ratanak.pek.core.data.Expanse
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
    val currentExpense = MutableLiveData<Expanse?>()

    fun saveExpense(expanse: Expanse) {
        coroutineScope.launch {
            usecase.createExpanse.invoke(expanse)
            saved.postValue(true)
        }
    }

    fun getExpanse(id: Int) {
        coroutineScope.launch {
            currentExpense.postValue(usecase.getExpanse.invoke(id))
        }
    }

    fun deleteExpense(expanse: Expanse) {
        coroutineScope.launch {
            usecase.removeExpanse.invoke(expanse)
            saved.postValue(true)
        }
    }

}