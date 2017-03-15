package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
/**
  *
  */
object FindFirstOccurrenceOfK {

  def searchFirstK(input: Array[Int], target: Int): Int = {
    var (low, high) = (0, input.length - 1)
    while (low <= high) {
      val mid = low + (high - low) / 2
      if (input(mid) > target) {
        high = mid - 1
      } else if (input(mid) < target) {
        low = mid + 1
      } else {
        if (mid - 1 >= 0 && input(mid - 1) == target) {
          high = mid - 1
        } else
          return mid
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(-14, -10, 2, 108, 243, 285, 285, 285, 401)
    println(searchFirstK(arr, 285))
  }
}
