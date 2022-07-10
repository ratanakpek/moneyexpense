package ratanak.pek.moneyexpense.experiment.designpattern.builder

class WifeBehaviour private constructor() {
    //This field is so sensitive, we don't want outside to touch it
    private var name: String? = null
    private var age: Int = 0
    private var isPolite = false
    private var isStandardHeight = false

    fun isSuitableToGetMarried(): Boolean {
        return isPolite && isStandardHeight
    }

    //Builder that provide access to out side world
    class Builder {
        private var wifeBuilder: WifeBehaviour=WifeBehaviour()

        fun setName(name: String): Builder {
            wifeBuilder.name = name
            return this
        }

        fun setAge(age: Int): Builder {
            wifeBuilder.age = age
            return this
        }

        fun setIsPolite(isPolite: Boolean) = apply {
            wifeBuilder.isPolite = isPolite
        }

        fun setIsStandardHeight(isStandardHeight: Boolean) = apply {
            wifeBuilder.isStandardHeight = isStandardHeight
        }

        fun create() = wifeBuilder
    }
}