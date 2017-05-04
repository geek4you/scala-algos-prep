package algos.epi.dp

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/6/17.
  */
/**
  * Page 327
  */
object MinWeightPathTriangle {

  def minimumPathTotal(triangle: ArrayBuffer[ArrayBuffer[Int]]): Int = {
    if (triangle.isEmpty)
      return 0

    // as we iterate, prevRow stores the minimum path sum to each entry in triangle(i-1)
    var prevRow = new ArrayBuffer[Int]()
    prevRow ++= triangle(0)
    for (i <- 1 until triangle.length) {
      // stores the min path sum to each entry in triangle(i)
      val currRow = new ArrayBuffer[Int]()
      currRow ++= triangle(i)
      // for the first element
      currRow(0) += prevRow(0)
      for (j <- 1 until currRow.size - 1) {
        currRow(j) = currRow(j) + Math.min(prevRow(j - 1), prevRow(j))
      }
      // for last element
      currRow(currRow.length - 1) += prevRow(
        prevRow.length - 1)

      prevRow = currRow
    }
    prevRow.reduceLeft((x, y) => if (x < y) x else y)
  }

  def main(args: Array[String]): Unit = {
    val triangle = new ArrayBuffer[ArrayBuffer[Int]]()
    val firstRow = new ArrayBuffer[Int]()
    firstRow += 2
    val secondRow = new ArrayBuffer[Int]()
    secondRow ++= Array(4, 4)
    val thirdRow = new ArrayBuffer[Int]()
    thirdRow ++= Array(8, 5, 6)
    val fourthRow = new ArrayBuffer[Int]()
    fourthRow ++= Array(4, 2, 6, 2)
    val fifthRow = new ArrayBuffer[Int]()
    fifthRow ++= Array(1, 5, 2, 3, 4)
    triangle += firstRow
    triangle += secondRow
    triangle += thirdRow
    triangle += fourthRow
    triangle += fifthRow

    println(minimumPathTotal(triangle))

  }
}
