package ratanak.pek.moneyexpense.presentation.ui.notifications.create

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ratanak.pek.moneyexpense.framework.di.ApplicationModule
import ratanak.pek.moneyexpense.framework.di.DaggerViewModelComponent

import ratanak.pek.moneyexpense.framework.notification.NotificationUseCases
import javax.inject.Inject

class CreateNotificationsViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var usecase: NotificationUseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}