package algos.epi.dp

/**
  * Created by geekforyou on 3/21/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/]]
  */
object MinCostPathRightDownDiagnol {

  def minCost(matrix: Array[Array[Int]]): Int = {
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
        pathCosts(i)(j) = Math.min(
          pathCosts(i - 1)(j - 1),
          Math.min(pathCosts(i - 1)(j), pathCosts(i)(j - 1))) + matrix(i)(j)
      }

    pathCosts(pathCosts.length - 1)(pathCosts(0).length - 1)
  }

  def main(args: Array[String]): Unit = {
    val matrix = Array(Array(1, 2, 3), Array(4, 8, 2), Array(1, 5, 3))
    println(minCost(matrix))
  }
}
