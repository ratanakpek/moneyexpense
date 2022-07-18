package ratanak.pek.moneyexpense.designpattern.builder

import org.junit.Assert
import org.junit.Test
import ratanak.pek.moneyexpense.experiment.designpattern.builder.FoodOrderBuilder
import ratanak.pek.moneyexpense.experiment.designpattern.builder.WifeBehaviour

class BuilderPatternTest {

    @Test
    fun initBuilderPattern() {
        val builder = FoodOrderBuilder.Builder()
        builder.bread = "Touslesous"
        builder.meat("Beef")
        builder.condiments("Olive old")
            .build()
    }

    @Test
    fun demoMyCuteBuilderPattern() {
        val builder = WifeBehaviour.Builder()
        val wifeBehaviour =
            builder
                .setName("Hello World")
                .setAge(22)
                .setIsPolite(true)
                .setIsStandardHeight(true)
                .create()

        Assert.assertEquals(true, wifeBehaviour.isSuitableToGetMarried())
    }
}