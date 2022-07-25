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

//https://www.baeldung.com/solid-principles
class Windows98Machine {
    //Keyboard & monitor are interface = abstraction -> so it is not depend on concrete class anymore
    private val keyboard: IKeyboard
    private val monitor: IMonitor

    init {
        //Monitor & StandardKeyboard are concrete class
        monitor = Monitor()
        keyboard = StandardKeyboard()
    }
}

interface IKeyboard
class StandardKeyboard : IKeyboard

interface IMonitor
class Monitor : IMonitor