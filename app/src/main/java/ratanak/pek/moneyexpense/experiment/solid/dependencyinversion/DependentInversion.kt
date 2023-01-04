package ratanak.pek.moneyexpense.experiment.solid.dependencyinversion


//High Level
class JuniorDeveloper {
    fun implementNewFeature() {
        //depend on Level
        val factoryAbstraction = FeatureFactory.create()
        factoryAbstraction.doTheFeature()

        println("I do it with senior developer guidance!")
    }
}



//should use abstraction here
interface IMakeFeature {
    fun doTheFeature(): List<String>
}

object FeatureFactory {
    fun create(): IMakeFeature {
        return MakeFeature()
    }
}

class MakeFeature : IMakeFeature {
    override fun doTheFeature() = listOf("Schedule Payment", "Payment", "Transfer")
}


//Low Level
class SeniorDeveloper {
    fun implementNewFeature() {
        //depend on Level
        val factoryAbstraction = FeatureFactory.create()
        factoryAbstraction.doTheFeature()

        println("I am senior, and expert do the feature!")
    }
}
