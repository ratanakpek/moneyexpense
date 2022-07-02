package ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution

//Object should be replaceable with their subtypes without affecting the correctness of the
//program

open class Vehicle {
    open fun getInteriorWith(): Int = 1
}


class Car : Vehicle() {

    override fun getInteriorWith(): Int {
        return 1111
    }

    fun getCabinWith(): Int {
        return 1
    }
}

class RacingCar : Vehicle() {

    override fun getInteriorWith(): Int {
        return 2222
    }

    fun getCockpitWith(): Int {
        return 10
    }
}
