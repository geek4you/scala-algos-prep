package algos.epi.graph

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/9/17.
  */
/**
  * @see http://www.geeksforgeeks.org/find-shortest-distance-guard-bank/
  */
object ShortestDistanceFromGuardInBank {

  def findDistance(grid: Array[Array[Char]]): Array[Array[Int]] = {
    val result = Array.tabulate(grid.length, grid(0).length)((x, y) => -1)
    val queue = new ListBuffer[QueueNode]
    // finding Guards location and adding into queue
    for (i <- grid.indices)
      for (j <- grid(i).indices) {
        if (grid(i)(j) == 'G') {
          queue += QueueNode(Cell(i, j), 0)
          result(i)(j) = 0 // gaurd has zero distance from himself
        }
      }

    val shift = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))
    // do till queue is empty
    while (queue.nonEmpty) {
      // get the front cell in the queue and update
      // its adjacent cells
      val curr = queue.remove(0)

      shift.foreach(shft => {
        val next =
          QueueNode(Cell(curr.cell.row + shft(0), curr.cell.col + shft(1)),
                    curr.distance + 1)
        if (isFeasible(next.cell, grid) && isSafe(next.cell, grid, result)) {
          result(next.cell.row)(next.cell.col) = next.distance
          queue += next
        }
      })
    }
    result
  }

  /**
    * return true if current cell is an open area and its
    * distance from guard is not calculated yet
    */
  def isSafe(cell: Cell,
             grid: Array[Array[Char]],
             result: Array[Array[Int]]): Boolean = {
    grid(cell.row)(cell.col) == 'O' && result(cell.row)(cell.col) == -1
  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array('O', 'O', 'O', 'O', 'G')
    val arr2 = Array('O', 'W', 'W', 'O', 'O')
    val arr3 = Array('O', 'O', 'O', 'W', 'O')
    val arr4 = Array('G', 'W', 'W', 'W', 'O')
    val arr5 = Array('O', 'O', 'O', 'O', 'G')
    val grid = Array(arr1, arr2, arr3, arr4, arr5)
    val result = findDistance(grid)

    result.foreach(arr => println(arr.mkString("\t")))
  }

  def isFeasible(cell: Cell, grid: Array[Array[Char]]): Boolean = {
    (grid.indices contains cell.row) && (grid(cell.row).indices contains cell.col)
  }

  // row and col of a matrix cell and its distance from guard
  // respectively
  case class QueueNode(cell: Cell, distance: Int)
}
