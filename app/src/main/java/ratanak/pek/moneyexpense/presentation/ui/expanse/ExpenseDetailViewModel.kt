package ratanak.pek.moneyexpense.presentation.ui.expanse

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ratanak.pek.core.data.Expanse
import ratanak.pek.core.repository.ExpanseRepository
import ratanak.pek.core.usecase.CreateExpanse
import ratanak.pek.core.usecase.GetAllExpanse
import ratanak.pek.core.usecase.GetExpanse
import ratanak.pek.core.usecase.RemoveExpanse
import ratanak.pek.moneyexpense.framework.RoomExpenseDatasource
import ratanak.pek.moneyexpense.framework.UseCases

class ExpenseDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val repository = ExpanseRepository(RoomExpenseDatasource(application))

    private val usecase = UseCases(
        CreateExpanse(repository),
        GetAllExpanse(repository),
        GetExpanse(repository),
        RemoveExpanse(repository)
    )

    val saved = MutableLiveData<Boolean>()
    val currentExpense = MutableLiveData<Expanse?>()

    fun saveExpense(expanse: Expanse) {
        coroutineScope.launch {
            usecase.createExpanse.invoke(expanse)
            saved.postValue(true)
        }
    }

    fun getExpanse(id: Int){
        coroutineScope.launch {
            currentExpense.postValue(usecase.getExpanse.invoke(id))
        }
    }

}