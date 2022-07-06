package ratanak.pek.moneyexpense.framework.db

import androidx.room.*

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExpense(expenseEntity: ExpanseEntity)

    @Query("select * from Expanse where id=:id")
    suspend fun getExpense(id: Int): ExpanseEntity?

    @Query("select * from Expanse")
    suspend fun getAll(): List<ExpanseEntity>

    @Delete
    suspend fun deleteExpense(expenseEntity: ExpanseEntity)
}