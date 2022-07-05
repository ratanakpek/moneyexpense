package ratanak.pek.core.repository

import ratanak.pek.core.data.Expanse

class ExpanseRepository(var expanseDataSource: ExpanseDataSource) {
    suspend fun addExpanse(expanse: Expanse) = expanseDataSource.createExpanse(expanse)
    suspend fun getExpanse(id: Int) = expanseDataSource.getExpanse(id)
    suspend fun getAll() = expanseDataSource.getAll()
    suspend fun remove(expanse: Expanse) = expanseDataSource.remove(expanse)
}