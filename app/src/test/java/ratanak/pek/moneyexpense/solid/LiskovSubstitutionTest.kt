package ratanak.pek.moneyexpense

import org.junit.Test
import ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution.Car
import ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution.InHouseProduct
import ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution.Product
import ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution.RacingCar

class LiskovSubstitutionTest {

    @Test
    fun `Liskov Substitution Principle --- Break the hierachy`() {
        val carA = Car()
        val carB = Car()

        val racingCar = RacingCar()
        val carList = mutableListOf(carA, carB, racingCar)

        for(car in carList){
           println(car.getInteriorWith())
        }

    }

    @Test
    fun `Liskov Substitution Principle --- Tell, Don't Ask`() {
        val productA = Product()
        val productB = Product()

        val inHouseProduct = InHouseProduct()

        val productList = mutableListOf(productA, productB, inHouseProduct)

        for (product in productList) {
            //It is asking what type, in order to calculate the discount
            // if (product is InHouseProduct) product.applyExtraDiscount()
            println("Discount rate = " + product.getProductDiscount() + "%")
        }
    }

}
