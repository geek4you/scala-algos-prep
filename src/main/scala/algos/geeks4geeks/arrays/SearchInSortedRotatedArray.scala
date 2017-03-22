package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/20/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/]]
  */
object SearchInSortedRotatedArray {

  /**
    * Returns the position of the smallest element in the sorted array
    * eg: for [3,4,5,1,2] => returns position of 1
    * Also returns the correct position of the smallest
    * element if the sorted array is not rotated. So its always 0
    *
    * taken from [[algos.epi.searching.CyclicallySortedArray]]
    */
  def findPivot(arr: Array[Int]): Int = {
    var (left, right) = (0, arr.length - 1)

    while (left < right) {
      val mid = left + (right - left) / 2
      if (arr(mid) > arr(right)) {
        left = mid + 1
      } else if (arr(mid) < arr(right))
        right = mid
    }
    left
  }

  /**
    * Binary search returns -1 if the key is not found
    */
  def binarySearch(arr: Array[Int], low: Int, high: Int, key: Int): Int = {
    var (l, h) = (low, high)
    while (l <= h) {
      val mid = l + (h - l) / 2
      if (arr(mid) == key)
        return mid
      else if (arr(mid) < key) {
        l = mid + 1
      } else {
        h = mid - 1
      }
    }
    -1
  }

  def search(arr: Array[Int], key: Int): Int = {
    val pivot = findPivot(arr)

    if (pivot == 0) { // arr is not rotated
      binarySearch(arr, 0, arr.length - 1, key)
    } else if (key > arr(arr.length - 1)) {
      binarySearch(arr, 0, pivot - 1, key)
    } else {
      binarySearch(arr, pivot, arr.length - 1, key)
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(30, 40, 50, 10, 20)
    println(search(arr, 50))
  }
}
