package ratanak.pek.moneyexpense.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ratanak.pek.core.data.Expanse

@Entity(tableName = "Expanse")
data class ExpanseEntity(
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
        fun fromExpanse(expense: Expanse) = ExpanseEntity(
            expense.title,
            expense.description,
            expense.amount,
            expense.createdDate,
            expense.updateTime
        )
    }

    fun getExpanse() = Expanse(id, title, amount, desc, createTime, updateTime)
}