package algos.epi.graph

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/9/17.
  */
/**
  * Page 360
  * 1 -> white cell
  * 0 -> black cell
  */
object FindPathInMaze {

  /**
    * DFS
    */
  def searchMaze(maze: Array[Array[Int]],
                 start: Coordinate,
                 end: Coordinate): ArrayBuffer[Coordinate] = {
    val path = new ArrayBuffer[Coordinate]()
    maze(start.x)(start.y) = 1
    path += start
    if (!isSearchMazeHelper(maze, start, end, path))
      path.remove(path.length - 1)
    path // empty means no path from start to end
  }

  def isSearchMazeHelper(maze: Array[Array[Int]],
                         curr: Coordinate,
                         end: Coordinate,
                         path: ArrayBuffer[Coordinate]): Boolean = {
    if (curr == end)
      true
    else {
      val shift = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))
      shift.foreach(shft => {
        val next = Coordinate(curr.x + shft(0), curr.y + shft(1))
        if (isFeasible(next, maze)) {
          maze(next.x)(next.y) = 1
          path += next
          if (isSearchMazeHelper(maze, next, end, path))
            return true
          path.remove(path.length - 1)
        }
      })
      false
    }
  }

  def isFeasible(cur: Coordinate, maze: Array[Array[Int]]): Boolean = {
    if (cur.x >= 0 && cur.x < maze.length && cur.y >= 0 && cur.y < maze(cur.x).length && maze(
          cur.x)(cur.y) == 0) {
      true
    } else false
  }
  case class Coordinate(x: Int, y: Int)

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

    val src = Coordinate(0, 0)
    val dest = Coordinate(3, 4)

    val path = searchMaze(maze, src, dest)
    println(path.mkString(" -> "))

  }
}
