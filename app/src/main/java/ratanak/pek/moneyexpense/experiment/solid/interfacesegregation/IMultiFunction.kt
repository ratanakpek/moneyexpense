package ratanak.pek.moneyexpense.experiment.solid.interfacesegregation

interface IMultiFunction {
    fun print()
    fun getPrintPoolDetail()
    fun scan()
    fun scanPhoto()
    fun fax()
    fun internetFax()
}

class FaxMachine : IMultiFunction {
    override fun print() {
        //ignore
    }

    override fun getPrintPoolDetail() {
        //ignore
    }

    override fun scan() {
        //ignore
    }

    override fun scanPhoto() {
        //ignore
    }

    override fun fax() {
        TODO("Not yet implemented")
    }

    override fun internetFax() {
        TODO("Not yet implemented")
    }

}

class ScanMachine : IMultiFunction {
    override fun print() {
        //ignore
    }

    override fun getPrintPoolDetail() {
        //ignore
    }

    override fun scan() {
        TODO("Not yet implemented")
    }

    override fun scanPhoto() {
        TODO("Not yet implemented")
    }

    override fun fax() {
        //ignore
    }

    override fun internetFax() {
        //ignore
    }

}

class SuperPrinter : IMultiFunction {
    override fun print() {
        TODO("Not yet implemented")
    }

    override fun getPrintPoolDetail() {
        TODO("Not yet implemented")
    }

    override fun scan() {
        TODO("Not yet implemented")
    }

    override fun scanPhoto() {
        TODO("Not yet implemented")
    }

    override fun fax() {
        TODO("Not yet implemented")
    }

    override fun internetFax() {
        TODO("Not yet implemented")
    }
}