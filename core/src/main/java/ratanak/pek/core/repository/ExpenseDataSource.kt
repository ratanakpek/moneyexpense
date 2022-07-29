package ratanak.pek.core.repository

import ratanak.pek.core.data.Expense

interface ExpenseDataSource {
    suspend fun createExpense(expense: Expense)
    suspend fun getExpense(id: Int): Expense?
    suspend fun getAll(): List<Expense>
    suspend fun remove(expense: Expense)
}