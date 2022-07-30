package ratanak.pek.moneyexpense.presentation.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ratanak.pek.core.data.Expense
import ratanak.pek.moneyexpense.databinding.ItemExpenseViewBinding
import ratanak.pek.moneyexpense.presentation.utils.callback.ListAction
import java.text.SimpleDateFormat
import java.util.*

class ExpenseListAdapter(
    private val expenseList: ArrayList<Expense>,
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

    fun add(newExpense: List<Expense>) {
        expenseList.clear()
        expenseList.addAll(newExpense)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        with(expenseList[position]) {
            holder.binding.tvTittle.text = this.title.plus(showDays(this.daysCount))
            holder.binding.tvContent.text = this.description
            val sdf = SimpleDateFormat("MMM dd, HH:mm:ss")
            val resultDate = Date(this.updateTime)
            holder.binding.tvLastUpdate.text = "Last updated: ${sdf.format(resultDate)}"
            holder.binding.root.rootView.setOnClickListener {
                callback.onClick(this.id)
            }
            holder.binding.tvPrice.text = "${this.amount} $"
            holder.binding.tvCount.text = "Words: ${this.wordCount}"
        }
    }

    private fun showDays(day: Int): String {
        return if (day >= 1) day.toString().plus(dayFormat(day)) else ""
    }

    private fun dayFormat(day: Int) = if (day > 1) " days" else " day"

    override fun getItemCount(): Int {
        return expenseList.size
    }
}