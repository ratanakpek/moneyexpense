package ratanak.pek.moneyexpense.experiment.designpattern.builder

interface Builder {
    fun reset()
    fun buildStepA()
    fun buildStepB()
    fun buildStepZ()
}

class BuilderOne : Builder {
    override fun reset() {
        println("reset 1")
    }

    override fun buildStepA() {
        println("buildStepA 1")
    }

    override fun buildStepB() {
        println("buildStepB 1")
    }

    override fun buildStepZ() {
        println("buildStepZ 1")
    }

    fun getResult() = ProductOne()
}

class BuilderTwo : Builder {
    override fun reset() {
        println("reset 2")
    }

    override fun buildStepA() {
        println("buildStepA 2")
    }

    override fun buildStepB() {
        println("buildStepB 2")
    }

    override fun buildStepZ() {
        println("buildStepZ 2")
    }

    fun getResult() = ProductTwo()
}

class ProductOne
class ProductTwo

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