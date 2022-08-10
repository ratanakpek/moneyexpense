package ratanak.pek.moneyexpense.presentation.ui.notifications.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ratanak.pek.moneyexpense.databinding.FragmentNotificationsBinding

class CreateNotificationsFragment : Fragment() {

    private lateinit var _binding: FragmentNotificationsBinding
    private lateinit var viewModel: CreateNotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[CreateNotificationsViewModel::class.java]
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return _binding.root
    }
}