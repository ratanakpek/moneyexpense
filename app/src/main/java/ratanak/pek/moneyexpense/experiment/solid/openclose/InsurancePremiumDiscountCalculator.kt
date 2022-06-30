package ratanak.pek.moneyexpense.experiment.solid.openclose

class InsurancePremiumDiscountCalculator {
    fun calculatePremiumDiscount(profile: HealthInsuranceCustomerProfile): Int {
        return if (profile.isLocalCustomer()) {
            1
        } else {
            -1
        }
    }

    fun calculatePremiumDiscount(profile: HouseInsuranceCustomerProfile): Int {
        return if (profile.isLocalCustomer()) {
            2
        } else {
            -1
        }
    }
}

class HouseInsuranceCustomerProfile {
    fun isLocalCustomer(): Boolean {
        return true
    }
}

class HealthInsuranceCustomerProfile {
    fun isLocalCustomer(): Boolean {
        return true
    }
}
