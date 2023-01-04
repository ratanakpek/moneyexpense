package ratanak.pek.moneyexpense.experiment.solid.openclose

import kotlin.random.Random

//as you can see, each time we add another bank, we will have to modify existing code
class AuditorIssue {
    fun auditAbaBank(bankInfo: ABABank): String {
        return if (bankInfo.isRegister()) {
            "Registered"
        } else "Unregister"
    }

    fun auditAceledaBank(bankInfo: ABABank): String {
        return if (bankInfo.isRegister()) {
            "Registered"
        } else "Unregister"
    }

    fun auditSathapanaBank(bankInfo: ABABank): String {
        return if (bankInfo.isRegister()) {
            "Registered"
        } else "Unregister"
    }
}

// solution
class Auditor {
    fun auditBank(bankInfo: NationalBankOfCambodia): String {
        return if (bankInfo.isRegister()) {
            "Registered"
        } else "Unregister"
    }
}

interface NationalBankOfCambodia {
    fun isRegister(): Boolean
}

class ABABank : NationalBankOfCambodia {
    override fun isRegister(): Boolean {
        return Random.nextBoolean()
    }
}

class AceledaBank : NationalBankOfCambodia {
    override fun isRegister(): Boolean {
        return Random.nextBoolean()
    }
}

class SathapanaBank : NationalBankOfCambodia {
    override fun isRegister(): Boolean {
        return Random.nextBoolean()
    }
}