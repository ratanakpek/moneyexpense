package ratanak.pek.moneyexpense.experiment.solid.interfacesegregation

//interface IMultiFunction {
//    fun print()
//    fun getPrintPoolDetail()
//    fun scan()
//    fun scanPhoto()
//    fun fax()
//    fun internetFax()
//}

interface IPrintable {
    fun print()
    fun getPrintPoolDetail()
}

interface IScannable {
    fun scan()
    fun scanPhoto()
}

interface IFaxable {
    fun fax()
    fun internetFax()
}

class FaxMachine : IFaxable {

    override fun fax() {
        TODO("Not yet implemented")
    }

    override fun internetFax() {
        TODO("Not yet implemented")
    }

}

class ScanMachine : IScannable {

    override fun scan() {
        TODO("Not yet implemented")
    }

    override fun scanPhoto() {
        TODO("Not yet implemented")
    }


}

class SuperPrinter : IPrintable, IScannable, IFaxable {
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