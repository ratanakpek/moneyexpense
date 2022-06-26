package ratanak.pek.moneyexpense.cleancode

import org.junit.Assert
import org.junit.Test
import ratanak.pek.moneyexpense.cleancode.meaningfulname.Cell
import ratanak.pek.moneyexpense.cleancode.meaningfulname.IntentionRevealingName

class MeaningfulNameMain {

    @Test
    fun intentionRevealingName() {
        val containCell = Cell(
            intArrayOf(4, 1, 5)
        )
        val cellList = mutableListOf(
            Cell(intArrayOf(1, 2, 3)), Cell(intArrayOf(2, 3, 4)), containCell
        )
        val intentionRevealingName = IntentionRevealingName()
        val result = intentionRevealingName.getFlaggedCell(cellList.toTypedArray())
        Assert.assertEquals(
            true, result.contains(
                containCell
            )
        )
    }


}

