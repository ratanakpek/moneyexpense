package ratanak.pek.moneyexpense.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ratanak.pek.moneyexpense.databinding.FragmentHomeBinding
import ratanak.pek.moneyexpense.service.ACTION_START
import ratanak.pek.moneyexpense.service.EXTRA_PENDING_INTENT
import ratanak.pek.moneyexpense.service.SampleService

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.pendingIntentService
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        textView.setOnClickListener {
            createPendingIntentService(ACTION_START)
        }

        binding.stopService.setOnClickListener {
            // startService(ACTION_STOP)
        }
        return root
    }

    private fun createPendingIntentService(actionType: String) {
        val pendingResult = requireActivity().createPendingResult(
            REQUEST_SERVICE_CODE, Intent(), 0
        )

        val intent = Intent(actionType).also {
            it.setClass(requireContext(), SampleService::class.java)
        }.also {
            it.putExtra(EXTRA_PENDING_INTENT, pendingResult)
        }
        requireContext().apply {
            startService(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val REQUEST_SERVICE_CODE = 111
    }
}