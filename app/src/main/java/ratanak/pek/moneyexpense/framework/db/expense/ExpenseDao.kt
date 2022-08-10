package ratanak.pek.moneyexpense.framework.db.expense

import androidx.room.*

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExpense(expenseEntity: ExpenseEntity)

    @Query("select * from Expense where id=:expenseId")
    suspend fun getExpense(expenseId: Int): ExpenseEntity?

    @Query("select * from Expense ORDER BY update_time DESC")
    suspend fun getAll(): List<ExpenseEntity>

    @Delete
    suspend fun deleteExpense(expenseEntity: ExpenseEntity)
}