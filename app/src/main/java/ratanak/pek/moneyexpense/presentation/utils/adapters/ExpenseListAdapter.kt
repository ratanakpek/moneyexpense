package ratanak.pek.moneyexpense.presentation.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ratanak.pek.core.data.Expanse
import ratanak.pek.moneyexpense.databinding.ItemExpenseViewBinding
import ratanak.pek.moneyexpense.presentation.utils.callback.ListAction
import java.text.SimpleDateFormat
import java.util.*

class ExpenseListAdapter(
    private val expenseList: ArrayList<Expanse>,
    private val callback: ListAction
) :
    RecyclerView.Adapter<ExpenseListAdapter.ExpenseViewHolder>() {
    inner class ExpenseViewHolder(val binding: ItemExpenseViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding =
            ItemExpenseViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    fun add(newExpense: List<Expanse>) {
        expenseList.clear()
        expenseList.addAll(newExpense)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        with(expenseList[position]) {
            holder.binding.tvTittle.text = this.title
            holder.binding.tvContent.text = this.description
            val sdf = SimpleDateFormat("MMM dd, HH:mm:ss")
            val resultDate = Date(this.updateTime)
            holder.binding.tvLastUpdate.text = "Last updated: ${sdf.format(resultDate)}"
            holder.binding.root.rootView.setOnClickListener {
                callback.onClick(this.id)
            }
            holder.binding.tvPrice.text = "${this.amount} $"
        }
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }
}