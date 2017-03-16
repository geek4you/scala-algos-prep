package algos.epi.searching

/**
  * Created by geek4you on 3/15/17.
  */
/**
  * Page 198
  */
object Search2DSortedArray {

  def search(input: Array[Array[Int]], target: Int): Boolean = {
    var row = 0
    var col = input(0).length - 1

    while (row < input.length && col >= 0) {
      if (target == input(row)(col)) {
        return true
      } else if (target > input(row)(col))
        row += 1 // eliminate this row
      else
        col -= 1 // eliminate this col
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val rows = 6
    val col = 5
    val input = Array.ofDim[Int](rows, col)

  }
}
