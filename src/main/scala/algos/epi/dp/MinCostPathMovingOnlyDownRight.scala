package algos.epi.dp

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * going from (0,0) to (m,n)
  * first pos to last position
  * You can only move right or down of current position.
  *
  * @see [[https://www.youtube.com/watch?v=lBRtnuxg-gU]]
  */
object MinCostPathMovingOnlyDownRight {

  def minCost(matrix: Array[Array[Int]]): Result = {
    // declare sam size matrix
    val pathCosts = Array.ofDim[Int](matrix.length, matrix(0).length)

    // fill the first row and col
    pathCosts(0)(0) = matrix(0)(0)
    for (j <- 1 until matrix(0).length) {
      pathCosts(0)(j) = pathCosts(0)(j - 1) + matrix(0)(j)
    }

    for (i <- 1 until matrix.length) {
      pathCosts(i)(0) = pathCosts(i - 1)(0) + matrix(i)(0)
    }

    // fill the remaining entries
    for (i <- 1 until matrix.length)
      for (j <- 1 until matrix(0).length) {
        pathCosts(i)(j) = Math.min(pathCosts(i - 1)(j), pathCosts(i)(j - 1)) + matrix(
          i)(j)
      }

    // finding actual path
    var i = pathCosts.length - 1
    var j = pathCosts(0).length - 1
    var path = new ListBuffer[Cell]()
    path += Cell(i, j)
    while (i != 0 || j != 0) {
      if (i > 0 && j > 0) {
        if (pathCosts(i - 1)(j) < pathCosts(i)(j - 1)) {
          path += Cell(i - 1, j)
          i = i - 1
        } else {
          path += Cell(i, j - 1)
          j = j - 1
        }
      } else if (i > 0) {
        path += Cell(i - 1, j)
        i = i - 1
      } else if(j > 0){
        path += Cell(i, j - 1)
        j = j - 1
      }
    }
    path = path.reverse

    val minCost = pathCosts(pathCosts.length - 1)(pathCosts(0).length - 1)
    Result(minCost, path)
  }

  def main(args: Array[String]): Unit = {
    val matrix = Array(Array(1, 2, 3), Array(4, 8, 2), Array(1, 5, 3))
    println(minCost(matrix))
  }
}

case class Cell(i: Int, j: Int)

case class Result(minCost: Int, path: ListBuffer[Cell])
