package ratanak.pek.core.usecase.expense

import ratanak.pek.core.data.Expense
import ratanak.pek.core.repository.expense.ExpenseRepository

class RemoveExpense(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke(expense: Expense) = expenseRepository.remove(expense)
}