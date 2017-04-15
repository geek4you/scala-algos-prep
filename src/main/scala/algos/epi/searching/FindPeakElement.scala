package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */

/**
  * @see http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
  */
object FindPeakElement {

  def peakElement(input: Array[Int]): Int = {
    peakElementUtil(input, 0, input.length - 1)
  }

  def peakElementUtil(input: Array[Int], low: Int, high: Int): Int = {

    // Find index of middle element
    val mid = low + (high - low) / 2

    // Compare middle element with its neighbours (if neighbours exist)
    if ((mid == 0 || input(mid - 1) <= input(mid)) &&
        (mid == input.length - 1 || input(mid + 1) <= input(mid))) {
      mid
    }

    // If middle element is not peak and its left neighbour is greater
    // than it, then left half must have a peak element
    else if (mid > 0 && input(mid - 1) > input(mid))
      peakElementUtil(input, low, mid - 1)

    // If middle element is not peak and its right neighbour is greater
    // than it, then right half must have a peak element
    else
      peakElementUtil(input, mid + 1, high)

  }

  def main(args: Array[String]): Unit = {
    val input = Array(1, 3, 20, 4, 1, 0)
    println(input(peakElement(input)))
    val input1 = Array(1, 2, 3, 4, 5, 6)
    println(input1(peakElement(input1)))
  }
  
}
