package ratanak.pek.moneyexpense.designpattern

import org.junit.Test
import ratanak.pek.moneyexpense.experiment.designpattern.builder.*

class HouseBuilderPatternTest {

    @Test
    fun initBuilderPattern() {
        val builderOne = BuilderOne()
        val builderTwo = BuilderTwo()
        val director = Director(builderOne)
        director.changeBuilder(builderTwo)
        director.make("simple")
        val result = builderOne.getResult()
    }

}