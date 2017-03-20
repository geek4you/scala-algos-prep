package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/8/17.
  */
/**
  * 1) T(n) = O(n)
  * linear search
  * 2) T(n) = O(logn)
  * Binary search
  * @see [[http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/]]
  */
// todo: revisit
object CheckForMajorityElementInSortedArray extends App {

  def check(arr: Array[Int], key: Int): Boolean = {
    val index = binarySearchUtil(arr, key, 0, arr.length - 1)

    val finalIndex = index + (arr.length / 2)
    if (finalIndex < arr.length && arr(finalIndex) == key) {
      true
    } else
      false
  }

  /**
    * returns the first index where key appears in array
    */
  def binarySearchUtil(arr: Array[Int], key: Int, start: Int, end: Int): Int = {
    /* Check if arr[mid] is the first occurrence of x.
            arr[mid] is first occurrence if x is one of the following
            is true:
            (i) mid == 0 and arr[mid] == x
            (ii) arr[mid-1] < x and arr[mid] == x
     */
    val mid = (start + end) / 2
    if ((mid == 0 || arr(mid - 1) == key) && arr(mid) == key) {
      mid
    } else if (arr(mid) > key) {
      binarySearchUtil(arr, key, start, mid - 1)
    } else {
      binarySearchUtil(arr, key, mid + 1, end)
    }
  }

  override def main(args: Array[String]) {
    val arr = Array[Int](1, 2, 3, 3, 3, 3, 10)
    println(check(arr, 3))
  }
}
