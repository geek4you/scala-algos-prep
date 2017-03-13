package algos.epi.matrix

import java.util

/**
  * Created by aashii on 3/5/17.
  */
object PrintMatrixSpiralForm {

  /**
    * Works for both square and rectangle matrix
    */
  def printMatrixSpiral(
      matrix: java.util.ArrayList[java.util.ArrayList[Int]]): Unit = {
    var rows = matrix.size
    var columns = matrix.get(0).size()
    var i = 0
    var j = 0
    var numOfElemsToBeProcessed = matrix.size * matrix.get(0).size

    while (numOfElemsToBeProcessed > 0) {

      // print top row
      while (j < columns && numOfElemsToBeProcessed > 0) {
        print(s"${matrix.get(i).get(j)} ")
        j += 1
        numOfElemsToBeProcessed -= 1
      }
      println()
      j -= 1
      i += 1

      // print right column
      while (i < rows && numOfElemsToBeProcessed > 0) {
        print(s"${matrix.get(i).get(j)} ")
        i += 1
        numOfElemsToBeProcessed -= 1
      }
      println()
      i -= 1
      j -= 1

      // print bottom row
      while (j >= matrix.get(0).size() - columns && numOfElemsToBeProcessed > 0) {
        print(s"${matrix.get(i).get(j)} ")
        j -= 1
        numOfElemsToBeProcessed -= 1
      }
      println()
      j += 1
      i -= 1

      // print left column
      while (i > matrix.size()- rows && numOfElemsToBeProcessed > 0) {
        print(s"${matrix.get(i).get(j)} ")
        i -= 1
        numOfElemsToBeProcessed -= 1
      }
      println()
      i += 1
      j += 1

      rows -= 1
      columns -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    val arr1 =
      new util.ArrayList(util.Arrays.asList(Array(1, 2, 3, 4, 5, 6): _*))
    val arr2 = new util.ArrayList(
      java.util.Arrays.asList(Array(7, 8, 9, 10, 11, 12): _*))
    val arr3 = new util.ArrayList(
      java.util.Arrays.asList(Array(13, 14, 15, 16, 17, 18): _*))
    val matrix = new util.ArrayList[util.ArrayList[Int]]()
    matrix.add(arr1)
    matrix.add(arr2)
    matrix.add(arr3)
    printMatrixSpiral(matrix)
  }

}
