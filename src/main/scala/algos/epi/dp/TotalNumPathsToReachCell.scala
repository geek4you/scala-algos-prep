package algos.epi.dp

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/]]
  *
  * You can only move right or down
  */
object TotalNumPathsToReachCell {

  def totalPaths(matrix: Array[Array[Int]], dest: Cell): Int = {

    // a 2d array to memorize the computed paths
    val counts = Array.ofDim[Int](matrix.length, matrix(0).length)

    // counts for 1st row
    for (j <- matrix(0).indices)
      counts(0)(j) = 1

    // counts for 2nd row
    for (i <- matrix.indices)
      counts(i)(0) = 1

    for (i <- 1 until matrix.length)
      for (j <- 1 until matrix(0).length) {
        counts(i)(j) = counts(i - 1)(j) + counts(i)(j - 1)
      }

    counts(dest.i)(dest.j)
  }

  def main(args: Array[String]): Unit = {
    val matrix = Array.ofDim[Int](3,3)
    println(totalPaths(matrix, Cell(2,2)))
  }

}
