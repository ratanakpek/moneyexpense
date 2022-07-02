package ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution

//Object should be replaceable with their subtypes without affecting the correctness of the
//program
open class Car {

    open fun getCabinWith(): Int {
        return 1
    }
}

class RacingCar : Car() {
    override fun getCabinWith(): Int {
        //Racing doesn't have the cabin, it cockpit
        //so we should do this, let find another generic for extending
        return super.getCabinWith()
    }

    fun getCockpitWith(): Int {
        return 10
    }
}
