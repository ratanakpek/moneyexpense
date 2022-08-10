package ratanak.pek.core.usecase.expense

import ratanak.pek.core.repository.expense.ExpenseRepository

class GetAllExpense(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke() = expenseRepository.getAll()
}