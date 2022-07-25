package ratanak.pek.moneyexpense.presentation.ui.home

import android.app.Application
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

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val repository = ExpanseRepository(RoomExpenseDatasource(application))

    private val usecase = UseCases(
        CreateExpanse(repository),
        GetAllExpanse(repository),
        GetExpanse(repository),
        RemoveExpanse(repository)
    )

    val allExpense = MutableLiveData<List<Expanse>>()

    fun getExpenseList() {
        coroutineScope.launch {
            allExpense.postValue(usecase.getAllExpanse.invoke())
        }
    }
}