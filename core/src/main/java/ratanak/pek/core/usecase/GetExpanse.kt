package ratanak.pek.core.usecase

import ratanak.pek.core.data.Expanse
import ratanak.pek.core.repository.ExpanseRepository

class GetExpanse(private val expanseRepository: ExpanseRepository) {
    suspend operator fun invoke(id: Int) = expanseRepository.getExpanse(id)
}