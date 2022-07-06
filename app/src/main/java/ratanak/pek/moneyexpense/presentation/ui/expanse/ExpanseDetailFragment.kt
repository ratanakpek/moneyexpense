package ratanak.pek.moneyexpense.presentation.ui.expanse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ratanak.pek.moneyexpense.databinding.FragmentExpanseDetailBinding

class ExpanseDetailFragment : Fragment() {
    private var _binding: FragmentExpanseDetailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExpanseDetailBinding.inflate(inflater, container, false)
        _binding?.btnSave?.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
        return _binding?.root
    }


}