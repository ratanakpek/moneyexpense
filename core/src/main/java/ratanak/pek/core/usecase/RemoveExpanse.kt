package ratanak.pek.core.usecase

import ratanak.pek.core.data.Expanse
import ratanak.pek.core.repository.ExpanseRepository

class RemoveExpanse(private val expanseRepository: ExpanseRepository) {
    suspend operator fun invoke(expanse: Expanse) = expanseRepository.remove(expanse)
}