package algos.epi.recursion

/**
  * Created by geek4you on 4/1/17.
  */
object SudokuSolver {

  private val EmptyEntry = 0
  def solveSudoku(partialAssignment: Array[Array[Int]]): Boolean = {
    solvePartialSudoku(partialAssignment, 0, 0)
  }

  private def solvePartialSudoku(partialAssignment: Array[Array[Int]],
                                 row: Int,
                                 col: Int): Boolean = {

    var i = row
    var j = col
    if (i == partialAssignment.length) {
      i = 0 // Starts a new row.
      j += 1
      if (j == partialAssignment(col).length) {
        return true; // Entire matrix has been filled without conflict.
      }
    }

    // Skips nonempty entries.
    if (partialAssignment(i)(j) != EmptyEntry) {
      return solvePartialSudoku(partialAssignment, i + 1, j)
    }

    for (entryVal <- 1 to partialAssignment.length) {
      // It's substantially quicker to check if entry val conflicts
      // with any of the constraints if we add it at (i,j) before
      // adding it, rather than adding it and then checking all constraints.
      // The reason is that we are starting with a valid configuration,
      // and the only entry which can cause a problem is entryval at (i,j).
      if (validToAddVal(partialAssignment, i, j, entryVal)) {
        partialAssignment(i)(j) = entryVal
        if (solvePartialSudoku(partialAssignment, i + 1, j))
          return true
      }
    }
    // remove the entry
    partialAssignment(i)(j) = 0
    false
  }

  def validToAddVal(partialAssignment: Array[Array[Int]],
                    row: Int,
                    col: Int,
                    entryVal: Int): Boolean = {
    // check row constraints
    for (j <- partialAssignment.indices)
      if (entryVal == partialAssignment(row)(j))
        return false

    // check col constraints
    for (i <- partialAssignment.indices)
      if (entryVal == partialAssignment(i)(col))
        return false

    // check region constraints
    val regionSize = Math.sqrt(partialAssignment.length).asInstanceOf[Int]
    val i = row / regionSize
    val j = col / regionSize
    for (a <- 0 until regionSize)
      for (b <- 0 until regionSize)
        if (partialAssignment(i * regionSize + a)(j * regionSize + b) == entryVal)
          return false

    true
  }

  def main(args: Array[String]): Unit = {
    val grid = Array(
      Array(0, 2, 6, 0, 0, 0, 8, 1, 0),
      Array(3, 0, 0, 7, 0, 8, 0, 0, 6),
      Array(4, 0, 0, 0, 5, 0, 0, 0, 7),
      Array(0, 5, 0, 1, 0, 7, 0, 9, 0),
      Array(0, 0, 3, 9, 0, 5, 1, 0, 0),
      Array(0, 4, 0, 3, 0, 2, 0, 5, 0),
      Array(1, 0, 0, 0, 3, 0, 0, 0, 2),
      Array(5, 0, 0, 2, 0, 4, 0, 0, 9),
      Array(0, 3, 8, 0, 0, 0, 4, 6, 0)
    )
    println(solveSudoku(grid))
    grid.foreach(arr => println(arr.mkString(" ")))
  }
}
