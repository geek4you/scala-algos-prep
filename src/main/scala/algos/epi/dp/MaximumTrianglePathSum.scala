package algos.epi.dp

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/maximum-path-sum-triangle/]]
  * twitter interview question
  */
object MaximumTrianglePathSum {

  def maxPathSum(triangle: Array[Array[Int]]): Int = {
    // loop for bottom-up calculation
    for (i <- triangle.length - 1 to 0 by -1) {
      for (j <- 0 to i) {
        // for each element, check both
        // elements just below the number
        // and below right to the number
        // add the maximum of them to it
        if (i + 1 < triangle.length - 1 && j + 1 < triangle(0).length - 1 && triangle(
              i + 1)(j) > triangle(i + 1)(j + 1)) {
          triangle(i)(j) = triangle(i + 1)(j)
        } else if (i + 1 < triangle.length - 1 && j + 1 < triangle(0).length - 1) {
          triangle(i)(j) += triangle(i + 1)(j + 1)
        }
      }
    }
    // return the top element
    // which stores the maximum sum
    triangle(0)(0)

  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 0, 0)
    val arr2 = Array(4, 8, 0)
    val arr3 = Array(1, 5, 3)
    val triangle = Array(arr1, arr2, arr3)
    println(maxPathSum(triangle))
  }

}
