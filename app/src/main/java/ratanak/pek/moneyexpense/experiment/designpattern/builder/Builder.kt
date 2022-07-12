package ratanak.pek.moneyexpense.experiment.designpattern.builder

interface Builder {
    fun reset()
    fun buildStepA()
    fun buildStepB()
    fun buildStepZ()
}

class BuilderOne : Builder {
    private var product = ProductOne()
    override fun reset() {
        println("reset 1")
        product.isReset = true
    }

    override fun buildStepA() {
        println("buildStepA 1")
        product.stepState = "buildStepA 1"
    }

    override fun buildStepB() {
        println("buildStepB 1")
        product.stepState = "buildStepB 1"
    }

    override fun buildStepZ() {
        println("buildStepZ 1")
        product.stepState = "buildStepZ 1"
    }

    fun getResult() = product
}

class BuilderTwo : Builder {
    private var product = ProductTwo()
    override fun reset() {
        println("reset 2")
        product.isReset = true
    }

    override fun buildStepA() {
        println("buildStepA 2")
        product.stepState = "buildStepA 2"
    }

    override fun buildStepB() {
        println("buildStepB 2")
        product.stepState = "buildStepB 2"
    }

    override fun buildStepZ() {
        println("buildStepZ 2")
        product.stepState = "buildStepZ 2"
    }

    fun getResult() = product
}

class ProductOne {
    var isReset = false
    var stepState = ""
}

class ProductTwo {
    var isReset = false
    var stepState = ""
}

class Director(private var builder: Builder) {

    fun changeBuilder(newBuilder: Builder) {
        builder = newBuilder
    }

    fun make(type: String) {
        builder.reset()
        if (type == "simple") {
            builder.buildStepA()
        } else {
            builder.buildStepB()
            builder.buildStepZ()
        }
    }
}