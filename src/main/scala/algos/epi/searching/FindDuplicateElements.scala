package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Problem Statement: Given a sorted array with possible duplicate elements. Find number of occurrences of input
  * key’ in log N time.
  *
  * Find first occurrence and find last occurrence
  *
  */
object FindDuplicateElements {

  /**
    * Returns pos of the last occurrence of key in arr
    */
  def lastOccurrenceInArray(arr: Array[Int], key: Int): Int = {
    var (low, high) = (0, arr.length - 1)
    while (low <= high) {
      val mid = low + (high - low) / 2
      if (arr(mid) < key) {
        low = mid + 1
      } else if (arr(mid) > key) {
        high = mid - 1
      } else {
        if (mid != arr.length - 1 && arr(mid + 1) == key) {
          low = mid + 1
        } else
          return mid
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(10, 20, 30, 30, 30, 30, 30, 40, 40, 50)
    val firstOccurrence = FindFirstOccurrenceOfK.searchFirstK(arr, 30)
    val lastOccurrence = lastOccurrenceInArray(arr, 30)
    println(s" First Occurrence : $firstOccurrence")
    println(s" Last Occurrence : $lastOccurrence")
    println(lastOccurrence - firstOccurrence + 1)
  }

}
