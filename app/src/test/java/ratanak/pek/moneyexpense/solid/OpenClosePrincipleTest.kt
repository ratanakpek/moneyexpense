package ratanak.pek.moneyexpense

import org.junit.Test
import ratanak.pek.moneyexpense.experiment.solid.openclose.HealthInsuranceCustomerProfile
import ratanak.pek.moneyexpense.experiment.solid.openclose.HouseInsuranceCustomerProfile
import ratanak.pek.moneyexpense.experiment.solid.openclose.InsurancePremiumDiscountCalculator
import ratanak.pek.moneyexpense.experiment.solid.openclose.VehicleInsuranceCustomerProfile

class OpenClosePrincipleTest {

    @Test
    fun `run open close test`() {
        val discountCalculator = InsurancePremiumDiscountCalculator()

        val vehicle = VehicleInsuranceCustomerProfile()
        val discountAmountVehicle = discountCalculator.calculatePremiumDiscount(vehicle)
        println("Vehicle :$discountAmountVehicle")

        val house = HouseInsuranceCustomerProfile()
        val discountAmountHouse = discountCalculator.calculatePremiumDiscount(house)
        println("House :$discountAmountHouse")


        val health = HealthInsuranceCustomerProfile()
        val discountAmountHealth = discountCalculator.calculatePremiumDiscount(health)
        println("Health :$discountAmountHealth")
    }


}
