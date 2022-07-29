package ratanak.pek.core.repository

import ratanak.pek.core.data.Expense

class ExpenseRepository(var expenseDataSource: ExpenseDataSource) {
    suspend fun addExpense(expense: Expense) = expenseDataSource.createExpense(expense)
    suspend fun getExpense(id: Int) = expenseDataSource.getExpense(id)
    suspend fun getAll() = expenseDataSource.getAll()
    suspend fun remove(expense: Expense) = expenseDataSource.remove(expense)
}