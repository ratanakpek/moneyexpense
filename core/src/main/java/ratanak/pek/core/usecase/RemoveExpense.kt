package ratanak.pek.core.usecase

import ratanak.pek.core.data.Expense
import ratanak.pek.core.repository.ExpenseRepository

class RemoveExpense(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke(expense: Expense) = expenseRepository.remove(expense)
}