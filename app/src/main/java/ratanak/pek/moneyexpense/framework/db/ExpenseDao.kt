package ratanak.pek.moneyexpense.framework.db

import androidx.room.*

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExpense(expenseEntity: ExpanseEntity)

    @Query("select * from Expanse where id=:expenseId")
    suspend fun getExpense(expenseId: Int): ExpanseEntity?

    @Query("select * from Expanse ORDER BY update_time DESC")
    suspend fun getAll(): List<ExpanseEntity>

    @Delete
    suspend fun deleteExpense(expenseEntity: ExpanseEntity)
}