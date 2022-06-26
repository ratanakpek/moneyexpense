package ratanak.pek.moneyexpense.cleancode.function

import org.junit.Assert
import org.junit.Test

class FunctionMainTest {
    //function
    // 1. should be very small
    // 2. do only one thing
    // 3. Reading code from top to bottom

    @Test
    fun `function that use switch it show that function do many things, should replace with factory pattern`() {
        Assert.assertEquals(100, calculatePay(Employee(COMMISSION_TYPE)).amount)
        Assert.assertEquals(1000, calculatePay(Employee(SALARIED_TYPE)).amount)
        Assert.assertEquals(10, calculatePay(Employee(HOURLY_TYPE)).amount)
        //Assert.assertEquals(10, calculatePay(Employee(INVALID_TYPE)).amount)
    }

    @Throws(InvalidEmployeeType::class)
    fun calculatePay(employee: Employee): Money {
        return when (employee.type) {
            COMMISSION_TYPE -> {
                calculateCommissionPay(employee)
            }
            HOURLY_TYPE -> {
                calculateHourlyPay(employee)
            }
            SALARIED_TYPE -> {
                calculateSalaryPay(employee)
            }
            else -> {
                throw InvalidEmployeeType(employee.type)
            }
        }
    }

    private fun calculateSalaryPay(employee: Employee): Money {
        return Money(employee.type, 1000)
    }

    private fun calculateHourlyPay(employee: Employee): Money {
        return Money(employee.type, 10)
    }

    private fun calculateCommissionPay(employee: Employee): Money {
        return Money(employee.type, 100)
    }

}

class InvalidEmployeeType(type: Int) : Throwable()

const val COMMISSION_TYPE = 0
const val HOURLY_TYPE = 1
const val SALARIED_TYPE = 2
const val INVALID_TYPE = -1

class Money(val type: Int, var amount: Int)

class Employee(val type: Int)
