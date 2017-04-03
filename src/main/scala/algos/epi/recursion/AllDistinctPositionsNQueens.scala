package algos.epi.recursion

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/29/17.
  */
/**
  * All placement combinations of queens which do not attack each other
  * For any one placement see [[NQueens]]
  *
  */
object AllDistinctPositionsNQueens {

  def nQueens(n: Int): ArrayBuffer[ArrayBuffer[Position]] = {
    val result = new ArrayBuffer[ArrayBuffer[Position]]()
    solveNQueens(n, 0, new ArrayBuffer[Position](), result)
    result
  }

  def solveNQueens(n: Int,
                   row: Int,
                   colPlacements: ArrayBuffer[Position],
                   result: ArrayBuffer[ArrayBuffer[Position]]): Unit = {
    if (row == n) {
      result += colPlacements.clone()
    } else {
      for (col <- 0 until n) {
        colPlacements += Position(row, col)
        if (isValid(colPlacements)) {
          solveNQueens(n, row + 1, colPlacements, result)
        }
        colPlacements -= colPlacements(colPlacements.size - 1)
      }
    }
  }

  /**
    * Check if newly placed queen will conflict any earlier queens placed before
    */
  def isValid(colPlacements: ArrayBuffer[Position]): Boolean = {
    val rowId = colPlacements(colPlacements.size - 1).row
    val colId = colPlacements(colPlacements.size - 1).col
    for (i <- 0 until rowId) {
      if (colPlacements(i).col == colId || colPlacements(i).row - colPlacements(
            i).col == rowId - colId || colPlacements(i).row + colPlacements(i).col == rowId + colId) {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val n = 4
    val result = nQueens(n)
    println(result.mkString("\n"))
  }
}
