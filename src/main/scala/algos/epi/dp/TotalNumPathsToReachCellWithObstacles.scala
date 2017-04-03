package algos.epi.dp

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * Hacker rank Gayle Laakmann video
  *[[https://www.youtube.com/watch?v=P8Xa2BitN3I]]
  * Can only move right or down
  */
object TotalNumPathsToReachCellWithObstacles {

  def countPath(grid: Array[Array[Char]]): Int = {
    val result = Array.ofDim[Int](grid.length, grid(0).length)
    directedCountPaths(grid, 0, 0, result)
    result(0)(0)
  }

  def directedCountPaths(grid: Array[Array[Char]],
                         row: Int,
                         col: Int,
                         paths: Array[Array[Int]]): Int = {
    if (!isValid(grid, row, col)) return 0
    if (isEnd(grid, row, col)) return 1
    if (paths(row)(col) == 0) {
      paths(row)(col) =
        (if (row+1 < grid.length) {
           directedCountPaths(grid, row + 1, col, paths)
         } else 0) + (if (col+1 < grid(0).length) {
                        directedCountPaths(grid, row, col + 1, paths)
                      } else 0)
    }
    paths(row)(col)
  }
  def isValid(grid: Array[Array[Char]], row: Int, col: Int): Boolean = {
    if (grid(row)(col) == '#')
      false
    else
      true
  }

  def isEnd(grid: Array[Array[Char]], row: Int, col: Int): Boolean = {
    if (row == grid.length - 1 && col == grid(0).length - 1)
      true
    else false
  }

  def main(args: Array[String]): Unit = {
    val grid =
      Array(Array('1', '#', '3'), Array('4', '8', '7'), Array('#', '5', '3'))
    println(countPath(grid))
  }

}
