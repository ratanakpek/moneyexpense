package ratanak.pek.moneyexpense.presentation.ui.expanse


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import ratanak.pek.core.data.Expanse
import ratanak.pek.moneyexpense.databinding.FragmentExpanseDetailBinding

class ExpanseDetailFragment : Fragment() {
    private lateinit var viewModel: ExpenseDetailViewModel
    private var currentExpense = Expanse(0, "", 10.0, "", 0, 0)

    private var _binding: FragmentExpanseDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExpanseDetailBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity()).get(ExpenseDetailViewModel::class.java)

        _binding?.let { binding ->
            binding.btnSave.setOnClickListener {
                if (binding.edtTitle.text.toString() != ""
                    || binding.edtAmount.text.toString() != ""
                    || binding.edtDesc.text.toString() != ""
                ) {
                    val time = System.currentTimeMillis()
                    currentExpense.title = binding.edtTitle.text.toString()
                    currentExpense.amount = binding.edtAmount.text.toString().toDouble()
                    currentExpense.description = binding.edtDesc.text.toString()
                    currentExpense.updateTime = time
                    if (currentExpense.id == 0) {
                        currentExpense.createdDate = time
                    }

                    viewModel.saveExpense(currentExpense)
                    observeViewModel()

                } else {
                    Navigation.findNavController(binding.btnSave).popBackStack()
                }

            }
        }


    }

    private fun observeViewModel() {
        viewModel.saved.observe(requireActivity(), Observer {
            Log.e("rtk", "Thread name " + Thread().name)
            if (it) {
                //TODO
                this@ExpanseDetailFragment._binding?.let {view ->
                    Toast.makeText(view.edtTitle.context, "Done!", Toast.LENGTH_LONG).show()
                  //  Navigation.findNavController(view.edtTitle).popBackStack()
                }

            } else {
                Toast.makeText(requireContext(), "Something went wrong!", Toast.LENGTH_LONG).show()
            }
        })
    }


}