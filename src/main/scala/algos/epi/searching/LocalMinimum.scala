package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Page 193
  */
/**
  * Given an array of unique integers whose first two numbers are decreasing and last two numbers are increasing, find a
  * number in the array which is local minima. A number in the array is called local minima if it is smaller than both
  * its left and right numbers. For example in the array 9,7,2,8,5,6,3,4
  * 2 is a local minima as it is smaller than its left and right number 7 and 8. Similarly 5 is another local minima as it
  * is between 8 and 6, both larger than 5. You need to find any one of the local minima.
  *
  *
  * We will solve this problem in O(log n) time by divide and conquer method. We will first check the mid index of the
  * array. If it is smaller than its left and right, then it is the answer. If it is bigger than the left number then
  * from start to left we have a subproblem, and as we proved already that starting with decreasing and ending with
  * increasing sequence array will have to have a local minima, we can safely go to the left subarray. Otherwise if mid
  * is bigger than its right, then we go to the right subarray. This way we guarantee a O(log n) algorithm to find any
  * of the local minima present in the array.
  */
object LocalMinimum {

  def findLocalMinima(input: Array[Int], low: Int, high: Int): Int = {
    val mid = low + (high - low) / 2
    if (mid - 2 < 0 && mid + 1 > input.length - 1)
      -1
    else if (input(mid - 2) > input(mid - 1) && input(mid - 1) < input(mid)) {
      mid - 1
    } else if (input(mid - 1) > input(mid - 2)) {
      findLocalMinima(input, low, mid)
    } else
      findLocalMinima(input, mid, high)
  }

  def lMin(input: Array[Int], low: Int, high: Int): Int = {
    val mid = low + (high - low) / 2
    if (mid > 0 && mid < input.length - 1 && input(mid - 1) > input(mid) && input(
          mid) < input(mid + 1)) {
      mid
    } else if (mid > 0 && input(mid) > input(mid - 1)) {
      lMin(input, low, mid - 1)
    } else {
      lMin(input, mid + 1, high)
    }
  }

  def main(args: Array[String]): Unit = {
    val input = Array(64, 14, 52, 27, 71, 19, 63, 1, 16, 57)
    println(lMin(input, 0, input.length))
  }
}
