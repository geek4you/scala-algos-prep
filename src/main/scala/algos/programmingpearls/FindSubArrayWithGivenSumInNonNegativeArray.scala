package algos.programmingpearls

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * Sub array with given sum when all the elements are positive.
  * [[http://www.geeksforgeeks.org/find-subarray-with-given-sum/]]
  *
  * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
  */
object FindSubArrayWithGivenSumInNonNegativeArray {

  def subArrayWithGivenSum(arr: Array[Int], t: Int): (Int, Int) = {
    var cumSum = 0
    var startIndex = 0
    var endIndex = 0
    var i = 0
    var done = false
    while (i < arr.length && !done) {
      while (cumSum < t) {
        cumSum += arr(i)
        i += 1
      }
      if (cumSum == t) {
        endIndex = i - 1
        done = true
      } else if (cumSum > t) {
        cumSum -= arr(startIndex)
        startIndex += 1
      }
    }
    (startIndex, endIndex)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array[Int](1, 4, 20, 3, 10, 5)
    val (start, end) = subArrayWithGivenSum(arr, 33)
    for (i <- start to end)
      print(s"${arr(i)} ")
  }
}
