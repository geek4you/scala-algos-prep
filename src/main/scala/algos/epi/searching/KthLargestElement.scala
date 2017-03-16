package algos.epi.searching

import scala.util.Random

/**
  * Created by geek4you on 3/15/17.
  */
object KthLargestElement {

  def kthlargest(arr: Array[Int], k: Int): Int = {
    val rand = new Random(0)

    var (left, right) = (0, arr.length - 1)

    while (left <= right) {
      val pivotIdx = rand.nextInt(right - left + 1) + left
      val newPivotIdx = partition(arr, left, right, pivotIdx)
      if (newPivotIdx == k - 1) {
        return arr(newPivotIdx)
      } else if (newPivotIdx > k - 1)
        left = newPivotIdx + 1
      else
        right = newPivotIdx - 1
    }
    -1
  }

  def partition(arr: Array[Int], left: Int, right: Int, pivotIdx: Int): Int = {
    val pivotValue = arr(pivotIdx)
    var newPivotIdx = left

    swap(arr, newPivotIdx, right)

    for {
      i <- left until right
      if arr(i) < pivotValue
    } {
      swap(arr, newPivotIdx, i)
      newPivotIdx += 1
    }

    swap(arr, newPivotIdx, right)
    newPivotIdx
  }

  def swap(arr: Array[Int], idx1: Int, idx2: Int): Unit = {
    val tmp = arr(idx1)
    arr(idx1) = arr(idx2)
    arr(idx2) = tmp
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(3, 2, 1, 5, 4)
    println(kthlargest(arr, 3))
  }

}
