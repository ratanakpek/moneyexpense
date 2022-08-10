package ratanak.pek.core.usecase.expense

import ratanak.pek.core.data.Expense
import ratanak.pek.core.repository.expense.ExpenseRepository

class CreateExpense(private val expenseRepository: ExpenseRepository) {
    open suspend operator fun invoke(expense: Expense) = expenseRepository.addExpense(expense)
}