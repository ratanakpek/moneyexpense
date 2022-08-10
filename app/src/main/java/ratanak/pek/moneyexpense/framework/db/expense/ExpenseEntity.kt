package ratanak.pek.moneyexpense.framework.db.expense

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ratanak.pek.core.data.Expense

@Entity(tableName = "Expense")
data class ExpenseEntity(
    val title: String,
    val desc: String,
    val amount: Double,

    @ColumnInfo(name = "create_time")
    val createTime: Long,

    @ColumnInfo(name = "update_time")
    val updateTime: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
    companion object {
        fun fromExpense(expense: Expense) = ExpenseEntity(
            expense.title,
            expense.description,
            expense.amount,
            expense.createdDate,
            expense.updateTime,
            expense.id
        )
    }

    fun getExpense() = Expense(id, title, amount, desc, createTime, updateTime)
}