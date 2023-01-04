package ratanak.pek.moneyexpense.experiment.solid.liskovsubstitution


open class Bird {
    open fun walk() {
        println("I expect that every bird can walk!")
    }

    open fun fly() {
        println("I expect that every bird can fly!")
    }
}

//work fine
class Dove : Bird()

class Penguin : Bird() {
    fun eatFish() {
        println("I like to eat fish!")
    }

    override fun fly() {
        println("Sorry I can't fly")
    }
}

class Demo {
    fun exampleOne() {
        var bird = Bird()
        var penguin = Penguin()
        bird = penguin
        bird.fly()
    }

    fun exampleTwo() {
        val birds = arrayListOf<Bird>()
        birds.add(Dove())
        birds.add(Penguin())
        //it is Penguin, it is asking the class type that can eat fish
        //it's against Liskov Substitution
        //if have another subtype, we will against Open Close Principle
        birds.forEach { if (it is Penguin) it.eatFish() }
    }
}

