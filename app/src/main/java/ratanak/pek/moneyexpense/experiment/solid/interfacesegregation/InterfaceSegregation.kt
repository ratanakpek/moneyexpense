package ratanak.pek.moneyexpense.experiment.solid.interfacesegregation


interface ISmartHomePrinciple {
    // security
    fun lockKey()
    fun unlock()
}

interface ICookPrinciple {
    // cooking
    fun cookRice()
}

interface IFridgePrinciple {
    // fridge equipment
    fun coolingFood()
    fun freezeRawMeat()
}


interface ISmartHome {
    // fridge equipment
    fun coolingFood()
    fun freezeRawMeat()

    // cooking
    fun cookRice()

    // security
    fun lockKey()
    fun unlock()
}

class Fridge : ISmartHome {
    override fun coolingFood() {
        println("I can cool the food!")
    }

    override fun freezeRawMeat() {
        println("I can freeze the meet!")
    }

    override fun cookRice() {
        TODO("Not yet implemented")
    }

    override fun lockKey() {
        TODO("Not yet implemented")
    }

    override fun unlock() {
        TODO("Not yet implemented")
    }

}

class RiceCooker : ISmartHome {
    override fun coolingFood() {
        TODO("Not yet implemented")
    }

    override fun freezeRawMeat() {
        TODO("Not yet implemented")
    }

    override fun cookRice() {
        println("I can only cook!")
    }

    override fun lockKey() {
        TODO("Not yet implemented")
    }

    override fun unlock() {
        TODO("Not yet implemented")
    }

}

class ModernHome : ISmartHome {
    override fun coolingFood() {
        TODO("Not yet implemented")
    }

    override fun freezeRawMeat() {
        TODO("Not yet implemented")
    }

    override fun cookRice() {
        TODO("Not yet implemented")
    }

    override fun lockKey() {
        TODO("Not yet implemented")
    }

    override fun unlock() {
        TODO("Not yet implemented")
    }

}