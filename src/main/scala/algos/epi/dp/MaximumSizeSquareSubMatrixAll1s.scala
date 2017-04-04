package algos.epi.dp

/**
  * Created by geek4you on 4/3/17.
  */
/**
  * @see http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
  */
object MaximumSizeSquareSubMatrixAll1s {

  def maxSizeSquareSubMatrix(grid: Array[Array[Int]]): SubMatrix = {

    val auxiliaryGrid = Array.ofDim[Int](grid.length, grid(0).length)

    // first row and col
    // row
    for (j <- grid(0).indices)
      auxiliaryGrid(0)(j) = grid(0)(j)
    //col
    for (i <- grid.indices)
      auxiliaryGrid(i)(0) = grid(i)(0)

    // remaining cells
    for (i <- 1 until grid.length)
      for (j <- 1 until grid(0).length) {
        if (grid(i)(j) == 1) {
          auxiliaryGrid(i)(j) = Math.min(
            auxiliaryGrid(i - 1)(j),
            Math.min(auxiliaryGrid(i - 1)(j - 1), auxiliaryGrid(i)(j - 1))) + 1
        }
      }

    // get the indices of the largest cell in the grid
    var maxVal = Int.MinValue
    var rowIdx = 0
    var colIdx = 0
    for (i <- auxiliaryGrid.indices)
      for (j <- auxiliaryGrid(0).indices) {
        if (auxiliaryGrid(i)(j) > maxVal) {
          maxVal = auxiliaryGrid(i)(j)
          rowIdx = i
          colIdx = j
        }
      }
    auxiliaryGrid.foreach(arr => println(arr.mkString(" ")))
    SubMatrix(rowIdx - maxVal + 1, rowIdx, colIdx - maxVal + 1, colIdx)
  }

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(0, 1, 1, 0, 1),
                     Array(1, 1, 0, 1, 0),
                     Array(0, 1, 1, 1, 0),
                     Array(1, 1, 1, 1, 0),
                     Array(1, 1, 1, 1, 1),
                     Array(0, 0, 0, 0, 0))
    println(maxSizeSquareSubMatrix(grid))
  }

  case class SubMatrix(startRow: Int, endRow: Int, startCol: Int, endCol: Int)
}
