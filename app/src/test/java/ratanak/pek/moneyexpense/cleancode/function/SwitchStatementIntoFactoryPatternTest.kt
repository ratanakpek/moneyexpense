package ratanak.pek.moneyexpense.cleancode.function

import org.junit.Assert
import org.junit.Test

class SwitchStatementIntoFactoryPatternTest {
    @Test
    fun `convert switch in function by using factory patter`() {
        val employeeFactory = EmployeeFactoryImpl()
        val employeeInfo = EmployeeRecord(SALARIED_TYPE)
        employeeInfo.name = "Ratanak"
        val employeeAlreadyCalculated = employeeFactory.makeEmployee(employeeInfo)

        //1. Company give 100 for salary
        employeeAlreadyCalculated.deliverPay(Money(SALARIED_TYPE, 100))

        //2. calculate
        employeeAlreadyCalculated.calculatePay()
        Assert.assertEquals(1100, employeeAlreadyCalculated.getTotalAmount())
    }

}

class EmployeeFactoryImpl : EmployeeFactory {
    override fun makeEmployee(r: EmployeeRecord): EmployeeAbstract {
        return when (r.type) {
            COMMISSION_TYPE -> {
                CommissionEmployee(r)
            }
            HOURLY_TYPE -> {
                HourlyEmployee(r)
            }
            SALARIED_TYPE -> {
                SalaryEmployee(r)
            }
            else -> {
                InvalidEmployeeTypeAbstract(r)
            }
        }
    }

}

class InvalidEmployeeTypeAbstract(r: EmployeeRecord) : EmployeeAbstract() {
    override fun isPayday(): Boolean {
        return false
    }

    override fun calculatePay() {
        //ignore
    }

    override fun deliverPay(pay: Money) {
        //ignore
    }

    override fun getTotalAmount(): Int {
        return 0
    }

}

class HourlyEmployee(var r: EmployeeRecord) : EmployeeAbstract() {
    private var calculateAmountToPay = 0

    //1 hour = 10$
    private var hourlyAmount = 10
    override fun isPayday(): Boolean {
        return true
    }

    override fun calculatePay() {
        calculateAmountToPay += hourlyAmount
    }

    override fun deliverPay(pay: Money) {
        calculateAmountToPay = pay.amount
    }

    override fun getTotalAmount(): Int {
        return calculateAmountToPay
    }
}

class SalaryEmployee(r: EmployeeRecord) : EmployeeAbstract() {
    private var calculateAmountToPay = 0

    //1 month = 1000$
    private var salaryAmount = 1000
    override fun isPayday(): Boolean {
        return true
    }

    override fun calculatePay() {
        calculateAmountToPay += salaryAmount
    }

    override fun deliverPay(pay: Money) {
        calculateAmountToPay = pay.amount
    }

    override fun getTotalAmount(): Int {
        return calculateAmountToPay
    }
}

class CommissionEmployee(r: EmployeeRecord) : EmployeeAbstract() {
    private var calculateAmountToPay = 0

    //1 purchase = 100$
    private var salaryAmount = 100
    override fun isPayday(): Boolean {
        return true
    }

    override fun calculatePay() {
        calculateAmountToPay += salaryAmount
    }

    override fun deliverPay(pay: Money) {
        calculateAmountToPay = pay.amount
    }

    override fun getTotalAmount(): Int {
        return calculateAmountToPay
    }
}

interface EmployeeFactory {
    @Throws(InvalidEmployeeType::class)
    fun makeEmployee(r: EmployeeRecord): EmployeeAbstract
}

abstract class EmployeeAbstract {
    abstract fun isPayday(): Boolean
    abstract fun calculatePay()
    abstract fun deliverPay(pay: Money)
    abstract fun getTotalAmount(): Int
}

class EmployeeRecord(val type: Int) {
    var name: String? = null
}

