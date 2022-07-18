package ratanak.pek.moneyexpense.experiment.designpattern.singleton

class Singleton private constructor(){
    var name: String? = null
    private var age: Int = 0

    companion object{
        private var instance = Singleton()
        fun getInstance() = instance
    }
}