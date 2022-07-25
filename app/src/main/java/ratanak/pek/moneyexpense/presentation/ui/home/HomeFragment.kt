package ratanak.pek.moneyexpense.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import ratanak.pek.moneyexpense.databinding.FragmentHomeBinding
import ratanak.pek.moneyexpense.presentation.utils.adapters.ExpenseListAdapter
import ratanak.pek.moneyexpense.presentation.utils.callback.ListAction

class HomeFragment : Fragment(), ListAction {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var _adapter: ExpenseListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding.addExpanse.setOnClickListener {
            gotoExpanseDetail()
        }
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getExpenseList()
        observeExpenseList()
        setupAdapter()
    }

    private fun setupAdapter() {
        _adapter = ExpenseListAdapter(ArrayList(), this)
        _binding.rvList.adapter = _adapter
        _binding.rvList.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeExpenseList() {
        homeViewModel.allExpense.observe(requireActivity()) {
            _adapter.add(it)
        }
    }

    private fun gotoExpanseDetail(id: Int = 0) {
        HomeFragmentDirections.gotoExpanseDetail(id).also {
            Navigation.findNavController(_binding.rvList).navigate(it)
        }
    }

    override fun onClick(id: Int) {
        Log.e("rtk", "id $id")
        gotoExpanseDetail(id)
    }
}