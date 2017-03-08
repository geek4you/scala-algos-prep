package algos.matrix

import java.util

/**
  * Created by geek4you on 3/6/17.
  */
// todo: REVISIT
object MaximumSizeSquareSubMatrixWithAll1s extends App {

  def maxSizeSquareSubMatrixWith1s(
      matrix: util.ArrayList[util.ArrayList[Int]]): Int = {
    val sumMatrix = new util.ArrayList[util.ArrayList[Int]](matrix.size())

    // copy first row
    for (j <- 0 until matrix.size()) {
      if (Option(sumMatrix.get(0)).isEmpty) {
        sumMatrix.set(0, new util.ArrayList[Int]())
      }
      sumMatrix.get(0).set(j, matrix.get(0).get(j))
    }

    // copy first column
    for (i <- 0 until matrix.size()) {
      if (Option(sumMatrix.get(i)).isEmpty) {
        sumMatrix.set(i, new util.ArrayList[Int]())
      }
      sumMatrix.get(i).set(0, matrix.get(i).get(0))
    }

    // set other values in sumMatrix
    for (i <- 1 to matrix.size())
      for (j <- 1 to matrix.size()) {
        sumMatrix
          .get(i)
          .set(j,
               Math.min(sumMatrix.get(i - 1).get(j),
                        Math.min(sumMatrix.get(i).get(j - 1),
                                 sumMatrix.get(i - 1).get(j - 1))) + 1)
      }

    // get the max in tht sum array
    var max = 0
    for (i <- 1 to matrix.size())
      for (j <- 1 to matrix.size()) {
        max = Math.max(max, sumMatrix.get(i).get(j))
      }

    max
  }

  override def main(args: Array[String]): Unit = {}
}
