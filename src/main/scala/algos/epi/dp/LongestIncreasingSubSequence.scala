package algos.epi.dp

/**
  * Created by geek4you on 5/4/17.
  */
/**
  * Page 334
  */
object LongestIncreasingSubSequence {

  def longestIncreasingSubSequence(input: Array[Int]): Int = {

    val maxLength = Array.fill[Int](input.length)(1)

    for (i <- 1 until maxLength.length)
      for (j <- 0 until i) {
        if (input(j) < input(i)) {
          maxLength(i) = Math.max(maxLength(i), 1 + maxLength(j))
        }
      }

    maxLength.reduce((x, y) => if (x > y) x else y)
  }

  def main(args: Array[String]): Unit = {
    val input = Array(10, 22, 9, 33, 21, 50, 41, 60, 80)
    println(longestIncreasingSubSequence(input))
  }
}
