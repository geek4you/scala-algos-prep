package algos.epi.matrix

/**
  * Created by geeks4geeks on 3/7/17.
  */
/**
  * [[http://www.geeksforgeeks.org/a-boolean-matrix-question/]]
  */
object RooksPositions extends App{

  def rookPositions(matrix: Array[Array[Int]]): Unit = {

    var firstRow = false
    for (j <- matrix.indices) {
      if (matrix(0)(j) == 0) {
        firstRow = true
      }
    }

    var firstColumn = false
    for (i <- matrix.indices) {
      if (matrix(i)(0) == 1) {
        firstColumn = true
      }
    }

    for (i <- matrix.indices)
      for (j <- matrix.indices) {
        if (matrix(i)(j) == 0) {
          matrix(0)(j) = 0
          matrix(i)(0) = 0
        }
      }

    // now fill
    for (i <- matrix.indices)
      for (j <- matrix.indices) {
        if (matrix(0)(j) == 0 || matrix(i)(0) == 0) {
          matrix(i)(j) = 0
        }
      }

    // do it for first and last column
    if (firstRow)
      for (j <- matrix.indices)
        matrix(0)(j) = 0

    if (firstColumn)
      for (i <- matrix.indices)
        matrix(i)(0) = 0
  }

  override def main(args: Array[String]): Unit = {

  }
}
