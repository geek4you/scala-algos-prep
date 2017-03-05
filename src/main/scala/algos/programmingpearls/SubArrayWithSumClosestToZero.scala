package algos.programmingpearls

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * Page 85 Q 10
  * Solution - Page 217
  */
object SubArrayWithSumClosestToZero {

  /**
    * returns sum of the contiguous array which is closest to zero
    */
  // todo: to get array indexs for sub array [[https://lefttree.gitbooks.io/leetcode/highFreq/subarraySumClosest.html]]
  def subArrayWithSumClosestToZero(arr: Array[Int]): Int = {

    val cumulativeSum = new Array[Int](arr.length)
    cumulativeSum(0) = arr(0)
    for (i <- 1 until arr.length)
      cumulativeSum(i) = cumulativeSum(i - 1) + arr(i)

    // sort cum sums array
    scala.util.Sorting.quickSort(cumulativeSum)

    var minDiff = Integer.MAX_VALUE
    for (i <- 0 to cumulativeSum.length - 2) {
      minDiff = Math.min(cumulativeSum(i + 1) - cumulativeSum(i), minDiff)
    }
    minDiff
  }

  def main(args: Array[String]): Unit = {
    val arr = Array[Int](-2, -3, 4, -1, -2, 1, 5, -3)
    val minSumClosestToZero = subArrayWithSumClosestToZero(arr)
    print(s"$minSumClosestToZero ")
  }
}
