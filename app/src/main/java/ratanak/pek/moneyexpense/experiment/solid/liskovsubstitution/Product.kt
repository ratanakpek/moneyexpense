package ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution

//Object should be replaceable with their subtypes without affecting the correctness of the
//program
open class Product {
    protected var discount = 20.0

    open fun getProductDiscount() = discount
}

class InHouseProduct : Product() {
    override fun getProductDiscount(): Double {
        //Let calculate it first, so we can remove asking type in the loop
        applyExtraDiscount()
        return super.getProductDiscount()
    }
    fun applyExtraDiscount() {
        discount *= 1.5
    }
}