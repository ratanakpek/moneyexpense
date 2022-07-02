package ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution

//Object should be replaceable with their subtypes without affecting the correctness of the
//program
open class Product {
    protected var discount = 20.0

    fun getProductDiscount() = discount
}

class InHouseProduct : Product() {
    fun applyExtraDiscount() {
        discount *= 1.5
    }
}