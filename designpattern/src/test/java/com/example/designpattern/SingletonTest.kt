package com.example.designpattern

import org.junit.Assert
import org.junit.Test
import kotlin.math.sin

class SingletonTest {

    @Test
    fun helloWorld() {
//        val singleton = StudentSingleton.getInstance()
//        singleton.name = "Ratanak Pek"
//        singleton.age = 18
//
//        Assert.assertEquals(18, singleton.age)
//        Assert.assertEquals("Ratanak Pek", singleton.name)
    }

    @Test
    fun singletonWithJava() {
        val classRoom = ClassroomSingleton.getInstance()
        classRoom.name = "NUM"
        Assert.assertEquals("NUM", classRoom.name)
    }

    @Test
    fun `Object instead of class`() {
        MySingleTon.name = "baby"
        val singleton = MySingleTon.name
        Assert.assertEquals("baby", singleton)
    }

    @Test
    fun myTest() {
        println(ComputerSingleton)
        println(ComputerSingleton)
    }

    @Test
    fun helloSingleton() {
//        println(StudentSingleton.getInstance())
//        println(StudentSingleton.getInstance())

        println(StudentSingleton.instance)
        println(StudentSingleton.instance)

//        println(MySingleTon)
//        println(MySingleTon)
    }
}

object MySingleTon {
    var name: String? = null
}

class ComputerSingleton private constructor() {
    companion object {
        private var instance: ComputerSingleton? = null
        operator fun invoke(): ComputerSingleton {
            instance = synchronized(this) {
                if (instance == null) ComputerSingleton() else instance
            }
            return instance!!
        }
    }
}

//so long
//class ComputerSingleton private constructor() {
//    companion object {
//        private var instance: ComputerSingleton? = null
//        operator fun invoke(): ComputerSingleton {
//            instance = synchronized(this) {
//                if (instance == null) ComputerSingleton() else instance
//            }
//            return instance!!
//        }
//    }
//}


class StudentSingleton {
    var name: String? = null
    var age: Int = 0

    companion object HelloSingleton {
        var instance: StudentSingleton? = null
        init {
            instance = StudentSingleton()
        }


//        fun getInstance(): StudentSingleton {
//            instance= if (instance == null) synchronized(this) {
//                StudentSingleton()
//            } else instance
//            return instance!!
//        }
//
//        fun secondInstance(): StudentSingleton {
//            return StudentSingleton()
//        }
    }
}