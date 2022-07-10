package ratanak.pek.moneyexpense.designpattern

import org.junit.Test
import ratanak.pek.moneyexpense.experiment.designpattern.builder.FoodOrderBuilder

class BuilderPatternTest {

    @Test
    fun initBuilderPattern() {
        val builder = FoodOrderBuilder.Builder()
        builder.bread = "Touslesous"
        builder.meat("Beef")
        builder.condiments("Olive old")
            .build()
    }
}