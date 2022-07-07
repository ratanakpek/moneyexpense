package ratanak.pek.moneyexpense.framework

import android.content.Context
import ratanak.pek.core.data.Expanse
import ratanak.pek.core.repository.ExpanseDataSource
import ratanak.pek.moneyexpense.framework.db.DatabaseService
import ratanak.pek.moneyexpense.framework.db.ExpanseEntity

class RoomExpenseDatasource(context: Context): ExpanseDataSource{
    val dao = DatabaseService.getInstance(context).expenseDao()

    override suspend fun createExpanse(expanse: Expanse) {
       dao.addExpense(ExpanseEntity.fromExpanse(expanse))
    }

    override suspend fun getExpanse(id: Int): Expanse? {
       return dao.getExpense(id)?.getExpanse()
    }

    override suspend fun getAll(): List<Expanse> {
        return dao.getAll().map { it.getExpanse() }
    }

    override suspend fun remove(expanse: Expanse) {
        dao.deleteExpense(ExpanseEntity.fromExpanse(expanse))
    }
}