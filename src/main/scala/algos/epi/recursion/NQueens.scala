package algos.epi.recursion

/**
  * Created by geek4you on 3/29/17.
  */
/**
  * Return any one placement of n-queens.
  * any placement of queens which do not attack each other
  * Solution is based on this video:
  * @see https://www.youtube.com/watch?v=xouin83ebxE
  */
object NQueens {

  def nQueens(n: Int): Array[Position] = {
    val positions = new Array[Position](n)
    val hasSolution = solveNQueens(n, 0, positions)
    if (hasSolution)
      positions
    else
      new Array[Position](0)
  }

  def solveNQueens(n: Int, row: Int, positions: Array[Position]): Boolean = {

    if (row == n) {
      true
    } else {
      for (col <- 0 until n) {
        var foundSafe = true

        // check if this row and col is not under attack from any previous queen.
        var queen = 0
        while (queen < row && foundSafe) {
          if (positions(queen).col == col || positions(queen).row - positions(
                queen).col == row - col || positions(queen).row + positions(
                queen).col == row + col) {
            foundSafe = false
          }
          queen += 1
        }

        if (foundSafe) {
          positions(row) = Position(row, col)
          if (solveNQueens(n, row + 1, positions))
            return true
        }
      }
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 4
    val result = nQueens(n)
    println(result.mkString("\n"))
  }
}

case class Position(row: Int, col: Int)
