package algos.epi.arrays

import scala.collection.mutable

/**
  * Created by geek4you on 4/1/17.
  */
object SudokuChecker {

  def validateSudoku(grid: Array[Array[Int]]): Boolean = {

    // check row constraints
    for (row <- grid.indices)
      if (!validateSubGrid(grid, row, row + 1, 0, grid.length))
        return false

    // check col constraints
    for (col <- grid.indices)
      if (!validateSubGrid(grid, 0, grid.length, col, col + 1)) {
        return false
      }

    // check sub-grids
    val regionSize = Math.sqrt(grid.length).asInstanceOf[Int]
    for (i <- 0 until regionSize)
      for (j <- 0 until regionSize) {
        if (!validateSubGrid(grid,
                             regionSize * i,
                             (i + 1) * regionSize,
                             regionSize * j,
                             (j + 1) * regionSize))
          return false
      }

    true
  }

  def validateSubGrid(grid: Array[Array[Int]],
                      startRow: Int,
                      endRow: Int,
                      startCol: Int,
                      endCol: Int): Boolean = {

    val set = mutable.HashSet[Int]()
    for (i <- startRow until endRow)
      for (j <- startCol until endCol) {
        if (grid(i)(j) != 0 && set.contains(grid(i)(j)))
          return false
        else
          set += grid(i)(j)
      }
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

    println(validateSudoku(grid))

  }
}
