package ratanak.pek.moneyexpense.experiment.solid.singleresponsibility

import ratanak.pek.moneyexpense.experiment.util.ConnectionMockUp

//Reason to change
//1. Change crush attribute
//2. Change Database connection

//So it's conflict with single responsibility rule
class Crush {
    //This might match to serialize key for request\response with server
    //Not allow other to touch it
    //1. reason to change -> Change crush attribute
    private var id: Int = 0
    private var name: String? = ""
    private var age: Int = 0


    //Not relate to crush class -> Not recommended
    //This class not relate to use
    //2. reason to change -> Use Another connection
    fun save() {
        val connectionMockUp = ConnectionMockUp()
        connectionMockUp.save(this)
    }

    fun getCrushSqlStatement(): String {
        val prepareSqlStatement = PrepareSqlStatement()
        return prepareSqlStatement.getSqlStatement(this)
    }


    fun isSheCanBusiness(): Boolean = age > 18

    //public can see it & use it
    var formattedId: Int
        get() = if (id > 0) id else -1
        set(value) {
            id = if (value > 0) value else throw IllegalArgumentException("Id must greater than 0")
        }


    var validName: String = name.orEmpty()
        set(value) {
            field =
                if (value.isNotEmpty() && value.length > 3 && value.length < 12) value else throw IllegalArgumentException(
                    "Name not follow our format"
                )
        }

    var validAge: Int = age
        set(value) {
            field =
                if (value in 16..26) value else throw IllegalArgumentException(
                    "She is too young or old, I don't accept it!"
                )
        }

}

class PrepareSqlStatement {
    fun getSqlStatement(crush: Crush): String {
        crush.apply {
            return "INSERT INTO crush_table (id, name, age)\n" +
                    "VALUES ($formattedId, $validName, $validAge);"
        }
    }
}