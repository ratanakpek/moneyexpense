package ratanak.pek.moneyexpense.cleancode

import org.junit.Assert
import org.junit.Test

class MeaningfulNameChapter2 {
    //Why it exists, what it does, how it used
    // d -> reveal nothing

    // elapsedTimeInDay
    // daysSinceCreation;
    // daysSinceModification;
    // fileAgeInDays

    @Test
    fun mainFun() {
        val containCell = Cell(
            intArrayOf(4, 1, 5)
        )
        val cellList = mutableListOf(
            Cell(intArrayOf(1, 2, 3)), Cell(intArrayOf(2, 3, 4)), containCell
        )
        val result = getFlaggedCell(cellList.toTypedArray())
        Assert.assertEquals(
            true, result.contains(
                containCell
            )
        )
    }

    fun getFlaggedCell(gameBoards: Array<Cell>): MutableList<Cell> {
        val flaggedCell = mutableListOf<Cell>()
        for (cell in gameBoards) {
            if (cell.isFlagged()) flaggedCell.add(cell)
        }
        return flaggedCell
    }

    val FLAG = 4

    fun getFlaggedCells(gameBoards: Array<List<Int>>): MutableList<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for ((indexCell, value) in gameBoards.withIndex()) {
            if (value[indexCell] == FLAG) result.add(value)
        }
        return result
    }

    fun getThem(arr: Array<Int>): List<Int> {
        val result = mutableListOf<Int>()
        for (item in arr) {
            if (item == 4) result.add(item)
        }
        return result
    }
}

class Cell(private var intArrayOf: IntArray) {
    fun isFlagged(): Boolean {
        return intArrayOf[STATUS_VALUE] == FLAG
    }

    companion object {
        const val FLAG = 4
        const val STATUS_VALUE = 0
    }
}