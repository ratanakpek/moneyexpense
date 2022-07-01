package ratanak.pek.moneyexpense.experiment.solid.openclose

import kotlin.random.Random

class InsurancePremiumDiscountCalculator {
    fun calculatePremiumDiscount(profile: CustomerProfile): Int {
        return if (profile.isLocalCustomer()) {
            1
        } else {
            -1
        }
    }
}

class HouseInsuranceCustomerProfile : CustomerProfile {
    override fun isLocalCustomer(): Boolean {
        return Random.nextBoolean()
    }
}

class HealthInsuranceCustomerProfile : CustomerProfile {
    override fun isLocalCustomer(): Boolean {
        return Random.nextBoolean()
    }
}

class VehicleInsuranceCustomerProfile : CustomerProfile {
    override fun isLocalCustomer(): Boolean {
        return Random.nextBoolean()
    }
}
