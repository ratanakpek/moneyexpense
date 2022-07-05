package ratanak.pek.core.repository

import ratanak.pek.core.data.Expanse

interface ExpanseDataSource {
    suspend fun createExpanse(expanse: Expanse)
    suspend fun getExpanse(id: Int): Expanse?
    suspend fun getAll(): List<Expanse>
    suspend fun remove(expanse: Expanse)
}