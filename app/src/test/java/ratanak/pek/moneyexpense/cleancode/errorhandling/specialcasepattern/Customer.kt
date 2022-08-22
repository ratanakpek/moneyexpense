package ratanak.pek.moneyexpense.cleancode.errorhandling.specialcasepattern

open class Customer {
    var id = 0
    var name =""

    fun getCustomerInfo(): Customer? {
        return if (id == 0) null else Customer().apply {
            id = 1
            name = "Ratanak Pek"
        }
    }

    fun getCustomerInfoNonNull(): Customer {
        return if (id == 0) NullCustomer() else Customer().apply {
            id = 1
            name = "Ratanak Pek"
        }
    }
}

class NullCustomer: Customer()