package algos.epi.dp

import scala.collection.mutable

/**
  * Created by geek4you on 4/4/17.
  */
object SearchForSequenceIn2DArray {

  def isPatternContainedInGrid(grid: Array[Array[Int]],
                               pattern: Array[Int]): Boolean = {
    // each entry in the previous attempts is a point in the grid and suffix of pattern
    // (identified by its offset). Presence of previous entries indicates that the suffix is not
    // contained in the grid starting from that point.
    val previousAttempts = mutable.HashSet[Attempt]()
    for (i <- grid.indices)
      for (j <- grid(i).indices) {
        if (isPatternSuffixContainedStartingAtXY(grid,
                                                 i,
                                                 j,
                                                 pattern,
                                                 0,
                                                 previousAttempts))
          return true
      }
    false
  }

  def isPatternSuffixContainedStartingAtXY(
      grid: Array[Array[Int]],
      x: Int,
      y: Int,
      pattern: Array[Int],
      offset: Int,
      previousAttempts: mutable.HashSet[Attempt]): Boolean = {
    if (offset == pattern.length)
      // Nothing left to complete.
      return true

    // Check if (x, y) lies outside the grid.
    if (x < 0 || x > grid.length - 1 || y < 0 || y > grid(x).length - 1 || previousAttempts
          .contains(Attempt(x, y, offset)))
      return false

    if (grid(x)(y).equals(pattern(offset)) &&
        (isPatternSuffixContainedStartingAtXY(
          grid,
          x - 1,
          y,
          pattern,
          offset + 1,
          previousAttempts) || isPatternSuffixContainedStartingAtXY(
          grid,
          x + 1,
          y,
          pattern,
          offset + 1,
          previousAttempts) || isPatternSuffixContainedStartingAtXY(
          grid,
          x,
          y - 1,
          pattern,
          offset + 1,
          previousAttempts) || isPatternSuffixContainedStartingAtXY(
          grid,
          x,
          y + 1,
          pattern,
          offset + 1,
          previousAttempts))) {
      return true
    }
    previousAttempts += Attempt(x, y, offset)
    false
  }

  case class Attempt(x: Int, y: Int, offset: Int)

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(1, 2, 3), Array(3, 4, 5), Array(5, 6, 7))
    val pattern = Array(1, 3, 4, 6)
    println(isPatternContainedInGrid(grid, pattern))
  }
}
