package algos.programmingpearls

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * Maximum Sum of the contiguous sub array in the array
  * Page 77
  * Divide and Conquer - T(n) = O(nlogn)
  * Scanning Algorithm - T(n) = O(n)
  */
object MaxSumContiguousSubArray {

  def maxSumContiguousSubArray(arr: Array[Int]): Int = {
    var maxSumSoFar = 0
    var maxSumEndingHere = 0

    for (i <- arr.indices) {
      maxSumEndingHere = Math.max(maxSumEndingHere + arr(i), arr(i))
      maxSumSoFar = Math.max(maxSumSoFar, maxSumEndingHere)
    }
    maxSumSoFar
  }

  def main(args: Array[String]): Unit = {
    val arr = Array[Int](-2, -3, 4, -1, -2, 1, 5, -3)
    println(maxSumContiguousSubArray(arr))
  }
}
