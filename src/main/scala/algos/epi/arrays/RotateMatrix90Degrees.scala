package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/6/17.
  */
/**
  * Page 91
  * @see [[http://www.algoqueue.com/algoqueue/default/view/5898240/rotation-of-a-matrix]]
  * A square matrix (N×NN×N) can be broken into concentric square rings. The rotation of the outer ring is independent of the rotation of the inner ring. So we can start rotating the matrix by rotating the outer ring followed by the inner ones until we get to the middle. To rotate a ring we should move right along the top edge of the square, move down along the right edge, move left along the bottom edge and move up along the left edge. At each step we swap the four values around using a temporary variable.
  */
object RotateMatrix90Degrees extends App {

  def rotate90Degree(matrix: util.ArrayList[util.ArrayList[Int]]): Unit = {
    // Number of rings
    for (i <- 0 to matrix.size() / 2) {
      for (j <- i until matrix.size() - 1 - i) {

        val temp1 = matrix.get(i).get(j)
        val temp2 = matrix.get(j).get(matrix.size() - 1 - i)
        val temp3 =
          matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j)
        val temp4 = matrix.get(matrix.size() - 1 - j).get(i)

        matrix.get(j).set(matrix.size() - 1 - i, temp1)
        matrix.get(matrix.size() - 1 - i).set(matrix.size() - 1 - j, temp2)
        matrix.get(matrix.size() - 1 - j).set(i, temp3)
        matrix.get(i).set(j, temp4)
      }
    }
  }

  def printMatrix(matrix: util.ArrayList[util.ArrayList[Int]]): Unit = {
    for (i <- 0 until matrix.size()) {
      for (j <- 0 until matrix.get(0).size()) {
        print(matrix.get(i).get(j) + " ")
      }
      println()
    }
  }

  override def main(args: Array[String]): Unit = {
    val arr1 =
      new util.ArrayList(util.Arrays.asList(Array(1, 2, 3, 4): _*))
    val arr2 =
      new util.ArrayList(java.util.Arrays.asList(Array(5, 6, 7, 8): _*))
    val arr3 =
      new util.ArrayList(java.util.Arrays.asList(Array(9, 10, 11, 12): _*))
    val arr4 =
      new util.ArrayList(java.util.Arrays.asList(Array(13, 14, 15, 16): _*))
    val matrix = new util.ArrayList[util.ArrayList[Int]]()
    matrix.add(arr1)
    matrix.add(arr2)
    matrix.add(arr3)
    matrix.add(arr4)
    println(s"Original Matrix \n ${printMatrix(matrix)}")
    rotate90Degree(matrix)
    println(s"Rotated Matrix \n ${printMatrix(matrix)}")

  }
}
