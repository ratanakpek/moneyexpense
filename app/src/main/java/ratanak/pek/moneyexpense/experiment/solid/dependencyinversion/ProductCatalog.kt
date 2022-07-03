package ratanak.pek.moneyexpense.experiment.solid.dependencyinversion

class ProductCatalog(var productionRepository: ProductionRepository) {
}

object ProductFactory {
    fun create() = SqlProductionRepository()
}


interface ProductionRepository {
    fun getData(): String
}

class SqlProductionRepository : ProductionRepository {
    override fun getData(): String {
        return "Banana, wine, book"
    }

}