package ratanak.pek.moneyexpense.experiment.solid.dependencyinversion

class ProductCatalog {
    //ProductCatalog is depending to other SqlProductionRepository
    private var sqlProductionRepository = SqlProductionRepository()
}

class SqlProductionRepository {

}