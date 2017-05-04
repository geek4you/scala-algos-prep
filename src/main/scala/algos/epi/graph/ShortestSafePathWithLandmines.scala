package algos.epi.graph

/**
  * Created by geek4you on 4/9/17.
  */
/**
  * @see http://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/
  */
object ShortestSafePathWithLandmines {

  /**
    * Returns the minimum distance
    * Returns -1 if the path is not possible
    */
  def findShortestPath(grid: Array[Array[Int]]): Int = {
    // stores minimum cost of shortest path so far
    val minDistance = MinDistanceHolder(Int.MaxValue)

    // create a boolean matrix to store info about
    // cells already visited in current route
    val visited = Array.ofDim[Array[Boolean]](grid.length)
    for (i <- grid.indices) {
      visited(i) = new Array[Boolean](grid(i).length)
      for (j <- grid(i).indices) {
        visited(i)(j) = false
      }
    }

    // mark adjacent cells of landmines as unsafe
    markUnsafeCells(grid)

    // start from first column and take minimum
    var i = 0
    var minDistFound = false
    while (i < grid.length && !minDistFound) {
      // if path is safe from current cell
      if (grid(i)(0) == 1) {
        // find shortest route from (i, 0) to any
        // cell of last column (x, C - 1) where
        // 0 <= x < R
        findShortestPathHelper(grid, visited, i, 0, minDistance, 0)
        if (minDistance.minDist == grid(0).length)
          minDistFound = true
      }
      i += 1
    }

    if (minDistance.minDist != Int.MaxValue)
      minDistance.minDist
    else -1
  }

  /**
    * Function to find shortest safe Route in the
    * grid with landmines
    * grid[][] - binary input matrix with safe cells marked as 1
    * visited[][] - store info about cells already visited in current route
    * (row, col) are coordinates of the current cell
    * minDistance --> stores minimum cost of shortest path so far
    * currDistance --> stores current path cost
    */
  def findShortestPathHelper(grid: Array[Array[Int]],
                             visited: Array[Array[Boolean]],
                             row: Int,
                             col: Int,
                             minDistance: MinDistanceHolder,
                             currDistance: Int): Unit = {
    // if destination is reached
    if (col == grid(0).length) {
      // update shortest path found so far
      minDistance.minDist = Math.min(minDistance.minDist, currDistance)
    } else {
      // if current path cost exceeds minimum so far
      if (currDistance > minDistance.minDist)
        return

      // include (i, j) in current path
      visited(row)(col) = true

      // Recurse for all safe adjacent neighbours
      Shift.foreach(shft => {
        val cell = Cell(row + shft(0), col + shft(1))
        if (isFeasible(cell, grid) && isSafe(cell, grid, visited)) {
          findShortestPathHelper(grid,
                                 visited,
                                 cell.row,
                                 cell.col,
                                 minDistance,
                                 currDistance + 1)
        }
      })
    }
  }

  val Shift = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))

  /**
    * Marks the cell adjacent to landmine as unsafe
    */
  def markUnsafeCells(grid: Array[Array[Int]]): Unit = {
    for (i <- grid.indices)
      for (j <- grid(i).indices) {
        // if a landmines is found
        if (grid(i)(j) == 0) {
          // mark all adjacent cells
          Shift.foreach(shft => {
            if (isFeasible(Cell(i + shft(0), j + shft(1)), grid)) {
              grid(i + shft(0))(j + shft(1)) = -1
            }
          })
        }
      }

    // mark all found adjacent cells as unsafe
    for (i <- grid.indices)
      for (j <- grid(i).indices)
        if (grid(i)(j) == -1)
          grid(i)(j) = 0
  }

  /**
    * returns true if not marked as unsafe (i.e not marked as 0) and is not visited
    */
  def isSafe(cell: Cell,
             grid: Array[Array[Int]],
             visited: Array[Array[Boolean]]): Boolean = {
    if (grid(cell.row)(cell.col) != 0 && !visited(cell.row)(cell.col))
      true
    else
      false
  }

  /**
    * Checks the boundaries of the cell
    */
  def isFeasible(cell: Cell, grid: Array[Array[Int]]): Boolean = {
    if (cell.row >= 0 && cell.row < grid.length && cell.col >= 0 && cell.col < grid(
          cell.row).length) {
      true
    } else false
  }

  case class MinDistanceHolder(var minDist: Int)

  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val arr2 = Array(1, 0, 1, 1, 1, 1, 1, 1, 1, 1)
    val arr3 = Array(1, 1, 1, 0, 1, 1, 1, 1, 1, 1)
    val arr4 = Array(1, 1, 1, 1, 0, 1, 1, 1, 1, 1)
    val arr5 = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val arr6 = Array(1, 1, 1, 1, 1, 0, 1, 1, 1, 1)
    val arr7 = Array(1, 0, 1, 1, 1, 1, 1, 1, 0, 1)
    val arr8 = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val arr9 = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val arr10 = Array(0, 1, 1, 1, 1, 0, 1, 1, 1, 1)
    val arr11 = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val arr12 = Array(1, 1, 1, 0, 1, 1, 1, 1, 1, 1)
    val grid = Array(arr1,
                     arr2,
                     arr3,
                     arr4,
                     arr5,
                     arr6,
                     arr7,
                     arr8,
                     arr9,
                     arr10,
                     arr11,
                     arr12)
    println(findShortestPath(grid))
  }
}
