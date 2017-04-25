package algos.epi.graph

/**
  * Created by geek4you on 4/10/17.
  */
/**
  * This is a variation of counting number of connected components in a undirected graph
  *
  * @see http://www.geeksforgeeks.org/find-number-of-islands/
  *      T(n) = O(nm)
  *      Space = O(nm) // for visited array
  *      For less space, consider leet code solution (https://discuss.leetcode.com/topic/13248/very-concise-java-ac-solution)
  * @see https://leetcode.com/problems/number-of-islands/#/description
  */
object FindNumberOfIslands {

  def numberOfIslands(grid: Array[Array[Int]]): Int = {
    // Make a bool array to mark visited cells.
    // Initially all cells are unvisited
    val visited = Array.ofDim[Array[Boolean]](grid.length)
    for (i <- grid.indices) {
      visited(i) = new Array[Boolean](grid(i).length)
      for (j <- visited(i).indices)
        visited(i)(j) = false
    }

    // Initialize count as 0 and traverse through the all cells of
    // given matrix
    var count = 0
    for (i <- grid.indices)
      for (j <- grid(i).indices) {
        if (grid(i)(j) == 1 && !visited(i)(j)) { // If a cell with value 1 is not
          // visited yet, then new island found
          dfs(grid, i, j, visited) // Visit all cells in this island.
          count += 1 // and increment island count
        }
      }

    count
  }

  // A utility function to do DFS for a 2D boolean matrix. It only considers
  // the 8 neighbours as adjacent vertices
  def dfs(grid: Array[Array[Int]],
          row: Int,
          col: Int,
          visited: Array[Array[Boolean]]): Unit = {
    // These arrays are used to get row and column numbers of 8 neighbours
    // of a given cell
    val shift = Array(Array(-1, -1),
                      Array(-1, 0),
                      Array(-1, 1),
                      Array(0, -1),
                      Array(0, 1),
                      Array(1, -1),
                      Array(1, 0),
                      Array(1, 0),
                      Array(1, 1))

    // Mark this cell as visited
    visited(row)(col) = true

    // recur all the adjacent cells
    shift.foreach(shft => {
      if (isSafe(grid, row + shft(0), col + shft(1), visited))
        dfs(grid, row + shft(0), col + shft(1), visited)
    })
  }

  def isSafe(grid: Array[Array[Int]],
             row: Int,
             col: Int,
             visited: Array[Array[Boolean]]): Boolean = {
    (grid.indices contains row) && (grid(row).indices contains col) && grid(
      row)(col) == 1 && !visited(row)(col)
  }

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(1, 1, 0, 0, 0),
                     Array(0, 1, 0, 0, 1),
                     Array(1, 0, 0, 1, 1),
                     Array(0, 0, 0, 0, 0),
                     Array(1, 0, 1, 0, 1))

    println(s"Number of islands is : ${numberOfIslands(grid)}")
  }

}
