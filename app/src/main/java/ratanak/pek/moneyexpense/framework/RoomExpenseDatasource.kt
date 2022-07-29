package ratanak.pek.moneyexpense.framework

import android.content.Context
import ratanak.pek.core.data.Expense
import ratanak.pek.core.repository.ExpenseDataSource
import ratanak.pek.moneyexpense.framework.db.DatabaseService
import ratanak.pek.moneyexpense.framework.db.ExpenseEntity

class RoomExpenseDatasource(context: Context): ExpenseDataSource{
    val dao = DatabaseService.getInstance(context).expenseDao()

    override suspend fun createExpense(expense: Expense) {
       dao.addExpense(ExpenseEntity.fromExpense(expense))
    }

    override suspend fun getExpense(id: Int): Expense? {
       return dao.getExpense(id)?.getExpense()
    }

    override suspend fun getAll(): List<Expense> {
        return dao.getAll().map { it.getExpense() }
    }

    override suspend fun remove(expense: Expense) {
        dao.deleteExpense(ExpenseEntity.fromExpense(expense))
    }
}