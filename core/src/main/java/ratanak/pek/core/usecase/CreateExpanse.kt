package ratanak.pek.core.usecase

import ratanak.pek.core.data.Expanse
import ratanak.pek.core.repository.ExpanseRepository

class CreateExpanse(private val expanseRepository: ExpanseRepository) {
    open suspend operator fun invoke(expanse: Expanse) = expanseRepository.addExpanse(expanse)
}