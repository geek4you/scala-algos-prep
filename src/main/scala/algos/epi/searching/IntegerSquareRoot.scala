package algos.epi.searching

/**
  * Created by geek4you on 3/15/17.
  */
/**
  * Page 196
  */
object IntegerSquareRoot {

  def squareRoot(k: Int): Int = {
    var (low, high) = (0, k)

    while (low <= high) {
      val mid = low + (high - low) / 2

      val midSquared = mid * mid
      if (midSquared <= k)
        low = mid + 1
      else
        high = mid - 1
    }
    low - 1
  }

  def main(args: Array[String]): Unit = {
    val input = 16
    println(squareRoot(input))
  }
}
