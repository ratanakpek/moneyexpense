package ratanak.pek.moneyexpense.presentation.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ratanak.pek.moneyexpense.databinding.FragmentNotificationsBinding
import ratanak.pek.moneyexpense.presentation.ui.home.HomeFragmentDirections
import ratanak.pek.moneyexpense.presentation.ui.home.HomeViewModel

class NotificationsFragment : Fragment() {

    private lateinit var _binding: FragmentNotificationsBinding
    private lateinit var viewModel: NotificationsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[NotificationsViewModel::class.java]
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.add.setOnClickListener {
            gotoExpenseDetail()
        }
    }

    private fun gotoExpenseDetail(id: Int = 0) {
        NotificationsFragmentDirections.gotoCreateNotification().also {
            Navigation.findNavController(_binding.rvList).navigate(it)
        }
    }

}