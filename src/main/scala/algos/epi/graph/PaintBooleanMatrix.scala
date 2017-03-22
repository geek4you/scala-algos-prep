package algos.epi.graph

import java.util

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * Page 362
  */
object PaintBooleanMatrix {

  /**
    * search all the vertices with the same color as src and reachable from src and flip the color
    */
  def flipColor(matrix: Array[Array[Int]], src: Cell): Unit = {
    val shift = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))

    val validColor = matrix(src.row)(src.col)
    val queue = new util.LinkedList[Cell]()
    // reverse the color
    reverseColor(matrix, src)
    queue.addLast(src)

    while (!queue.isEmpty) {
      val curr = queue.removeFirst()
      // process the adjacent entries
      shift.foreach(arr => {
        val currCell = Cell(curr.row + arr(0), curr.col + arr(1))
        if (isValid(matrix, currCell, validColor)) {
          // reverse the color
          reverseColor(matrix, currCell)
          // add to the queue
          queue.addLast(currCell)
        }
      })
    }
  }

  def reverseColor(matrix: Array[Array[Int]], cell: Cell): Unit = {
    if (matrix(cell.row)(cell.col) == 0) {
      matrix(cell.row)(cell.col) = 1
    } else
      matrix(cell.row)(cell.col) = 0
  }

  def isValid(matrix: Array[Array[Int]],
              cell: Cell,
              validValue: Int): Boolean = {
    if (cell.row >= 0 && cell.row < matrix.length && cell.col >= 0 && cell.col < matrix(
          0).length &&
        matrix(cell.row)(cell.col) == validValue) {
      true
    }
    false
  }

}
