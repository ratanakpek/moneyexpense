package ratanak.pek.core.usecase.expense

import ratanak.pek.core.repository.expense.ExpenseRepository

class GetExpense(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke(id: Int) = expenseRepository.getExpense(id)
}