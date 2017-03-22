package algos.epi.graph

import java.util

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * Page 359
  * @see : [[http://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/]]
  *  Based on BFS
  */
object ShortestPathInBinaryMaze {

  def shortestPathBFS(maze: Array[Array[Int]], src: Cell, dest: Cell): Int = {
    // check source and destination cell
    // of the matrix have value 1
    if (maze(src.row)(src.col) != 1 || maze(dest.row)(dest.col) != 1) {
      -1
    } else {
      val visited = Array.ofDim[Boolean](maze.length, maze(0).length)

      // Mark the source cell as visited
      visited(src.row)(src.col) = true

      // Create a queue for BFS
      val queue = new util.LinkedList[QueueEntry]()

      // distance of source cell is 0
      // Enqueue source cell
      queue.addLast(QueueEntry(src, 0))

      // Do a BFS starting from source cell
      while (!queue.isEmpty) {
        val curr = queue.removeFirst()
        val currCell = curr.cell

        // If we have reached the destination cell,
        // we are done
        if (currCell == dest) {
          return curr.distance
        }

        // Otherwise enqueue its four adjacent cells if valid and not visited
        enqueueValidAdjacentCells(maze, visited, queue, curr)
      }
      //return -1 if destination cannot be reached
      -1
    }
  }

  /**
    * Enqueue each of the four adjacent cells to the queueEntry if valid and not visited before
    */
  def enqueueValidAdjacentCells(maze: Array[Array[Int]],
                                visited: Array[Array[Boolean]],
                                queue: util.Deque[QueueEntry],
                                queueEntry: QueueEntry): Unit = {
    val cell = queueEntry.cell
    // top
    if (isValidCell(maze, Cell(cell.row - 1, cell.col)) && !visited(
          cell.row - 1)(cell.col)) {
      // mark cell as visited and enqueue it
      visited(cell.row - 1)(cell.col) = true
      queue.addLast(
        QueueEntry(Cell(cell.row - 1, cell.col), queueEntry.distance + 1))
    }

    // bottom
    if (isValidCell(maze, Cell(cell.row + 1, cell.col)) && !visited(
          cell.row + 1)(cell.col)) {
      // mark cell as visited and enqueue it
      visited(cell.row + 1)(cell.col) = true
      queue.addLast(
        QueueEntry(Cell(cell.row + 1, cell.col), queueEntry.distance + 1))
    }

    // left
    if (isValidCell(maze, Cell(cell.row, cell.col - 1)) && !visited(cell.row)(
          cell.col - 1)) {
      // mark cell as visited and enqueue it
      visited(cell.row)(cell.col - 1) = true
      queue.addLast(
        QueueEntry(Cell(cell.row, cell.col - 1), queueEntry.distance + 1))
    }

    // right
    if (isValidCell(maze, Cell(cell.row, cell.col + 1)) && !visited(cell.row)(
          cell.col + 1)) {
      // mark cell as visited and enqueue it
      visited(cell.row)(cell.col + 1) = true
      queue.addLast(
        QueueEntry(Cell(cell.row, cell.col + 1), queueEntry.distance + 1))
    }
  }

  /**
    * check whether given cell (row, col) is a valid cell or not
    */
  def isValidCell(maze: Array[Array[Int]], cell: Cell): Boolean = {
    if (cell.row >= 0 && cell.row < maze.length && cell.col >= 0 && cell.col < maze(
          0).length && maze(cell.row)(cell.col) != 0)
      true
    else
      false
  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 0, 1, 1, 1, 1, 0, 1, 1, 1)
    val arr2 = Array(1, 0, 1, 0, 1, 1, 1, 0, 1, 1)
    val arr3 = Array(1, 1, 1, 0, 1, 1, 0, 1, 0, 1)
    val arr4 = Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 1)
    val arr5 = Array(1, 1, 1, 0, 1, 1, 1, 0, 1, 0)
    val arr6 = Array(1, 0, 1, 1, 1, 1, 0, 1, 0, 0)
    val arr7 = Array(1, 0, 0, 0, 0, 0, 0, 0, 0, 1)
    val arr8 = Array(1, 0, 1, 1, 1, 1, 0, 1, 1, 1)
    val arr9 = Array(1, 1, 0, 0, 0, 0, 1, 0, 0, 1)
    val maze = Array(arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9)

    val src = Cell(0, 0)
    val dest = Cell(3, 4)

    val dist = shortestPathBFS(maze, src, dest)

    println(dist)
  }
}

/**
  * to store matrix cell co-ordinates
  */
case class Cell(row: Int, col: Int)

/**
  * Element in the queue contains cell and distance from source
  */
case class QueueEntry(cell: Cell, distance: Int)
