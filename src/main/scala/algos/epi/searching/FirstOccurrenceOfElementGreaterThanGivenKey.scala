package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
object FirstOccurrenceOfElementGreaterThanGivenKey {

  def firstOccurrenceElemGreaterThanGivenKey(input: Array[Int],
                                            target: Int): Int = {
    var (low, high) = (0, input.length - 1)
    while (low <= high) {
      val mid = low + (high - low) / 2
      if (input(mid) <= target) {
        if (mid + 1 < input.length && input(mid + 1) > target)
          return mid + 1
        else
          low = mid + 1
      } else if (input(mid) > target) {
        if (mid - 1 > 0 && input(mid - 1) < target)
          return mid
        else
          high = mid - 1
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val input = Array(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401)
    println(firstOccurrenceElemGreaterThanGivenKey(input, 285))
  }
}
