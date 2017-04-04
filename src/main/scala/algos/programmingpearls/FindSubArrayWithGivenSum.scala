package algos.programmingpearls

import scala.collection.mutable

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * Array may contain negative values
  * [[http://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/]]
  */
object FindSubArrayWithGivenSum {

  /**
    *
    */
  def subArrayWithGivenSum(arr: Array[Int], sum: Int): SubArray = {
    val sumMap = mutable.Map[Int, Int]()

    var cum_sum = 0

    for (i <- arr.indices) {

      // update sum
      cum_sum = cum_sum + arr(i)

      // check if this is the sum
      if (cum_sum == sum)
        return SubArray(0, i)

      // check if present in map
      if (sumMap.contains(cum_sum - sum)) {
        return SubArray(sumMap(cum_sum - sum), i)
      }

      // put the cum_sum in map
      sumMap(cum_sum) = i
    }

    SubArray(-1, -1)
  }

  def main(args: Array[String]): Unit = {
    println(subArrayWithGivenSum(Array(10, 2, -2, -20, 10), -10))
  }
}
case class SubArray(startIdx: Int, endIdx: Int)
