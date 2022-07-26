package ratanak.pek.moneyexpense.framework.di

import dagger.Module
import dagger.Provides
import ratanak.pek.core.repository.ExpanseRepository
import ratanak.pek.core.usecase.CreateExpanse
import ratanak.pek.core.usecase.GetAllExpanse
import ratanak.pek.core.usecase.GetExpanse
import ratanak.pek.core.usecase.RemoveExpanse
import ratanak.pek.moneyexpense.framework.UseCases

@Module
class UsecaseModule {

    @Provides
    fun getUseCases(repository: ExpanseRepository) = UseCases(
        CreateExpanse(repository),
        GetAllExpanse(repository),
        GetExpanse(repository),
        RemoveExpanse(repository)
    )
}