package ratanak.pek.moneyexpense.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ratanak.pek.moneyexpense.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.addExpanse.setOnClickListener {
            gotoExpanseDetail()
        }

        return root
    }

    fun gotoExpanseDetail(id: Int = 0) {
        val action = HomeFragmentDirections.gotoExpanseDetail(id)
        Navigation.findNavController(binding.rvList).navigate(action)
    }
}