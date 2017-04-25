package algos.epi.graph

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/9/17.
  */
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 Given
An array of strings where "L" indicates land and "W" indicates water, and a coordinate marking a starting point in the middle of the ocean
The Challenge:
Find and mark the ocean in the map by changing appropriate W's to O's. An ocean coordinate is defined to be any coordinate directly adjacent to any other ocean coordinate.
Input:
LLLLLLLLLLLLLLLLLLLL
LLLLLLLLLLLLLLWLLLLL
LLWWLLLLLLLLLLLLLLLL
LLWWLLLLLLLLLLLLLLLL
LLLLLLLLLLLLLLLLLLLL
LLLLLLLWWLLLLLLLLLLL
LLLLLLLLWWLLLLLLLLLL
LLLLLLLLLWWWLLLLLLLL
LLLLLLLLLLWWWWWWLLLL
LLLLLLLLLLWWWWWWLLLL
LLLLLLLLLLWWWWWWLLLL
LLLLWWLLLLWWWWWWLLLL
LLLLWWWLLLWWWWWWWWWW
LLLLLWWWWWWWWWWWLLLL
LLLLLLLLLLLLLLWWWWLL
LLLLLLLLLLLLLLWLLLLL
LLLLWLLLLLLLLLLLLWLL
LLLLLLLLLLLLLLLLLLWL

Ocean Coordinate:
row = 10
col = 12
Expected Output:
LLLLLLLLLLLLLLLLLLLL
LLLLLLLLLLLLLLWLLLLL
LLWWLLLLLLLLLLLLLLLL
LLWWLLLLLLLLLLLLLLLL
LLLLLLLLLLLLLLLLLLLL
LLLLLLLOOLLLLLLLLLLL
LLLLLLLLOOLLLLLLLLLL
LLLLLLLLLOOOLLLLLLLL
LLLLLLLLLLOOOOOOLLLL
LLLLLLLLLLOOOOOOLLLL
LLLLLLLLLLOOOOOOLLLL
LLLLOOLLLLOOOOOOLLLL
LLLLOOOLLLOOOOOOOOOO
LLLLLOOOOOOOOOOOLLLL
LLLLLLLLLLLLLLOOOOLL
LLLLLLLLLLLLLLOLLLLL
LLLLWLLLLLLLLLLLLWLL
LLLLLLLLLLLLLLLLLLWL
 */
/**
  * I think solution is very similar to [[PaintBooleanMatrix]]
  * Get all the coordinates with 'W' that are reachable from Ocean coordinate
  */
object MarkOceanInMap {

  def markOcean(grid: Array[Array[Char]], oceanCoordinate: Coordinate): Unit = {
    val queue = new ListBuffer[Coordinate]()
    // mark initial ocean coordinate
    grid(oceanCoordinate.row)(oceanCoordinate.col) = 'O'
    // add to the queue
    queue += oceanCoordinate

    val shift = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))
    while (queue.nonEmpty) {
      val curr = queue.head
      shift.foreach(shft => {
        val curCoordinate = Coordinate(curr.row + shft(0), curr.col + shft(1))
        if (isFeasible(grid, curCoordinate)) {
          // mark as ocean candidate and enqueue
          grid(curCoordinate.row)(curCoordinate.col) = 'O'
          queue += curCoordinate
        }
      })
      queue.remove(0)
    }
  }

  def isFeasible(grid: Array[Array[Char]], coordinate: Coordinate): Boolean = {
    if ((grid.indices contains coordinate.row) && (grid(coordinate.row).indices contains coordinate.col) && grid(
          coordinate.row)(coordinate.col) == 'W') {
      true
    } else false
  }

  case class Coordinate(row: Int, col: Int)

  def main(args: Array[String]): Unit = {
    val arr1 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    var arr2 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'W', 'L', 'L', 'L', 'L', 'L')
    val arr3 = Array('L', 'L', 'W', 'W', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    val arr4 = Array('L', 'L', 'W', 'W', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    val arr5 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    val arr6 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'W', 'W', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    val arr7 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'W', 'W', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    val arr8 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'W', 'W',
      'W', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L')
    val arr9 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'W',
      'W', 'W', 'W', 'W', 'W', 'L', 'L', 'L', 'L')
    val arr10 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'W',
      'W', 'W', 'W', 'W', 'W', 'L', 'L', 'L', 'L')
    val arr11 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'W',
      'W', 'W', 'W', 'W', 'W', 'L', 'L', 'L', 'L')
    val arr12 = Array('L', 'L', 'L', 'L', 'W', 'W', 'L', 'L', 'L', 'L', 'W',
      'W', 'W', 'W', 'W', 'W', 'L', 'L', 'L', 'L')
    val arr13 = Array('L', 'L', 'L', 'L', 'W', 'W', 'W', 'L', 'L', 'L', 'W',
      'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W')
    val arr14 = Array('L', 'L', 'L', 'L', 'L', 'W', 'W', 'W', 'W', 'W', 'W',
      'W', 'W', 'W', 'W', 'W', 'L', 'L', 'L', 'L')
    val arr15 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'W', 'W', 'W', 'W', 'L', 'L')
    val arr16 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'W', 'L', 'L', 'L', 'L', 'L')
    val arr17 = Array('L', 'L', 'L', 'L', 'W', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'W', 'L', 'L')
    val arr18 = Array('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L',
      'L', 'L', 'L', 'L', 'L', 'L', 'L', 'W', 'L')
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
                     arr12,
                     arr13,
                     arr14,
                     arr15,
                     arr16,
                     arr17,
                     arr18)
    val oceanCoordinates = Coordinate(10, 12)
    markOcean(grid, oceanCoordinates)
    grid.foreach(x => println(x.mkString("")))
  }

}
