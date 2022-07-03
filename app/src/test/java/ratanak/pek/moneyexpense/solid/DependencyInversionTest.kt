package ratanak.pek.moneyexpense

import org.junit.Test
import ratanak.pek.moneyexpense.experiment.solid.dependencyinversion.ProductCatalog
import ratanak.pek.moneyexpense.experiment.solid.dependencyinversion.SqlProductionRepository

class DependencyInversionTest {

    @Test
    fun `Dependency Inversion Principle test`() {
        val sqlProductionRepository = SqlProductionRepository()
        val productCatalog = ProductCatalog(sqlProductionRepository)
        val data = productCatalog.productionRepository.getData()
        println(data)
    }

}
