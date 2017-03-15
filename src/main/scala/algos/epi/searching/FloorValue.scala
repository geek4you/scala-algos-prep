package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Problem Statement: Given an array of N distinct integers, find floor value of input ‘key’.
  * Say, A = {-1, 2, 3, 5, 6, 8, 9, 10} and key = 7, we should return 6 as outcome.
  *
  * Check for edge cases where floor can be first or last element
  */
object FloorValue {

  def floor(input: Array[Int], target: Int): Int = {
    var (low, high) = (0, input.length - 1)

    while (low <= high) {
      val mid = low + (high - low) / 2
      if (input(mid) == target)
        return mid
      else {
        if (input(mid) < target) {
          if (mid + 1 < input.length && input(mid + 1) > target)
            return mid
          else if (mid + 1 >= input.length)
            return mid
          else {
            low = mid + 1
          }
        } else { // input(mid) > target
          if (mid - 1 >= 0 && input(mid - 1) < target)
            return mid - 1
          else if (mid - 1 < 0)
            return -1
          else
            high = mid - 1
        }
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(-1, 2, 3, 5, 6, 8, 9, 10)
    println(arr(floor(arr, 1)))
  }
}
