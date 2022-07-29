package ratanak.pek.core.usecase

import ratanak.pek.core.repository.ExpenseRepository

class GetAllExpense(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke() = expenseRepository.getAll()
}