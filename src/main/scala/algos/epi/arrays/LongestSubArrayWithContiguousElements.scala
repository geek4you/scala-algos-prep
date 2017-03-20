package algos.epi.arrays

/**
  * Created by geek4you on 3/5/17.
  */
/**
  * [[http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/]]
  *
  * Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5

 The important thing to note in question is, it is given that all elements are distinct. If all elements are distinct, then a subarray has contiguous elements if and only if the difference between maximum and minimum elements in subarray is equal to the difference between last and first indexes of subarray. So the idea is to keep track of minimum and maximum element in every subarray.

 T(n) = O(n^2)

 What if duplicates are present?
 check : @see [[http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/]]
  */
// todo: what if duplicates present  [[http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/]]
object LongestSubArrayWithContiguousElements {

  def longestContiguousElemSubArray(arr: Array[Int]): Int = {
    var maxLen = 1
    for (i <- arr.indices) {
      var maxInSubArray = arr(i)
      var minInSubArray = arr(i)
      for (j <- i + 1 until arr.length) {
        maxInSubArray = Math.max(maxInSubArray, arr(j))
        minInSubArray = Math.min(minInSubArray, arr(j))

        if (maxInSubArray - minInSubArray == j - i) {
          maxLen = Math.max(maxLen, j - i + 1)
        }

      }
    }
    maxLen
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 56, 58, 57, 90, 92, 94, 93, 91, 45)
    print(longestContiguousElemSubArray(arr))
  }
}
