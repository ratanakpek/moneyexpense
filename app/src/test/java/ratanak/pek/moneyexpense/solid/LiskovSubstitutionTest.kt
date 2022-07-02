package ratanak.pek.moneyexpense

import org.junit.Test
import ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution.InHouseProduct
import ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution.Product

class LiskovSubstitutionTest {

    @Test
    fun `Liskov Substitution Principle`() {
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
