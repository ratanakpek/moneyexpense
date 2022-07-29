package ratanak.pek.core.usecase

import ratanak.pek.core.repository.ExpenseRepository

class GetExpense(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke(id: Int) = expenseRepository.getExpense(id)
}