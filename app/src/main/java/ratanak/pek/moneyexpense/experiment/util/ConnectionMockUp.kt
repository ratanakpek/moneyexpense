package ratanak.pek.moneyexpense.experiment.util

import ratanak.pek.moneyexpense.experiment.solid.singleresponsibility.Crush

class ConnectionMockUp {
    fun save(data: Crush) {
        openConnection()

        println("Do sql statement...")

        val sqlStatement = SqlExecutor(data.getCrushSqlStatement())
        sqlStatement.start()

        closeConnection()

        println("Successfully...")
    }

    fun openConnection() {
        println("Open...")
    }

    fun closeConnection() {
        println("Close...")
    }

}

class SqlExecutor(var sqlStatement: String = "") {
    fun start() {
        println("Execute: $sqlStatement")
    }
}