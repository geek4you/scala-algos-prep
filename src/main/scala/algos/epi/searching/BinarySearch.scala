package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
object BinarySearch {

  def binarySearchIterative(arr: Array[Int], target: Int): Int = {
    var (low, high) = (0, arr.length - 1)

    while (low <= high) {
      val mid = low + (high - low) / 2
      if (arr(mid) == target) {
        return mid
      } else if (arr(mid) > target) {
        high = mid - 1
      } else {
        low = mid + 1
      }
    }
    -1
  }

  def binarySearchRecursive(arr: Array[Int],
                            low: Int,
                            high: Int,
                            target: Int): Int = {
    if (low <= high) {
      val mid = low + (high - low) / 2
      if (arr(mid) == target) {
        mid
      } else if (arr(mid) > target)
        binarySearchRecursive(arr, low, mid - 1, target)
      else
        binarySearchRecursive(arr, mid + 1, high, target)
    } else -1
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(-14, -10, 2, 108, 345, 778)
    println(s"Iterative: ${binarySearchIterative(arr, 778)}")
    println(
      s"Recursive: ${binarySearchRecursive(arr, 0, arr.length - 1, 778)}")
  }

}
