package ratanak.pek.moneyexpense.presentation.ui.expanse


import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ratanak.pek.core.data.Expanse
import ratanak.pek.moneyexpense.databinding.FragmentExpanseDetailBinding

class ExpanseDetailFragment : Fragment() {
    private lateinit var viewModel: ExpenseDetailViewModel
    private var currentExpense = Expanse(0, "", 10.0, "", 0, 0)

    private lateinit var _binding: FragmentExpanseDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpanseDetailBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewModel = ViewModelProviders.of(this).get(ExpenseDetailViewModel::class.java)
        viewModel = ViewModelProvider(this)[ExpenseDetailViewModel::class.java]
        _binding.btnSave.setOnClickListener {
            if (isAllEditNotEmpty()) {
                currentExpense.title = _binding.edtTitle.text.toString()
                currentExpense.amount = _binding.edtAmount.text.toString().toDouble()
                currentExpense.description = _binding.edtDesc.text.toString()

                val time = System.currentTimeMillis()
                currentExpense.updateTime = time
                if (currentExpense.id == 0) {
                    currentExpense.createdDate = time
                }

                viewModel.saveExpense(currentExpense)
            } else {
                Navigation.findNavController(_binding.btnSave).popBackStack()
            }
        }
        observeViewModel()
    }

    private fun isAllEditNotEmpty() =
        _binding.edtTitle.text.isNotEmpty()
                || _binding.edtAmount.text.isNotEmpty()
                || _binding.edtDesc.text.isNotEmpty()

    private fun observeViewModel() {
        viewModel.saved.observe(requireActivity(), Observer {
            if (it) {
                Toast.makeText(_binding.btnSave.context, "Done!", Toast.LENGTH_SHORT).show()
                hideKeyboard()
                Navigation.findNavController(_binding.btnSave).popBackStack()
            } else {
                Toast.makeText(requireContext(), "Something went wrong!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun hideKeyboard() {
        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(_binding.btnSave.windowToken, 0)
    }
}