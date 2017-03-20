package algos.previousinterview

/**
  * Created by geek4you on 2/15/17.
  */
/**
  * For getting the median of input array { 12, 11, 15, 10, 20 }, first sort the array. We get { 10, 11, 12, 15, 20 }
  * after sorting. Median is the middle element of the sorted array which is 12.
  *
  * There are different conventions to take median of an array with even number of elements, one can take the mean of the two
  * middle values, or first middle value, or second middle value.
  *
  * Let us see different methods to get the median of two sorted arrays of size n each.
  * Since size of the set for which we are looking for median is even (2n), we are taking average of middle two numbers.
  *
  * [[http://www.geeksforgeeks.org/median-of-two-sorted-arrays/]]
  *
  * 2 procedures :
  * 1) O(n)
  * 2) O(logn)
  * Median of two sorted arrays
  * Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array
  * obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
  * <p>
  * For getting the median of input array { 12, 11, 15, 10, 20 }, first sort the array. We get { 10, 11, 12, 15, 20 }
  * after sorting. Median is the middle element of the sorted array which is 12.
  * <p>
  * Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays.
  * If count becomes n(For 2n elements), we have reached the median. Take the average of the elements at indexes n-1
  * and n in the merged array.
  */
// todo: revisit
object MedianOfTwoSortedArrays extends App {

  private def median(arr1: Array[Int], arr2: Array[Int]): Int = {
    if (arr1.length != arr2.length)
      throw new RuntimeException("Invalid Input!!")
    if (arr1.length <= 0)
      -1
    else if (arr1.length == 1)
      (arr1(0) + arr2(0)) / 2
    else
      median(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1)
  }

  private def median(arr1: Array[Int],
                     low1: Int,
                     high1: Int,
                     arr2: Array[Int],
                     low2: Int,
                     high2: Int): Int = {
    if (high1 - low1 + 1 == 2) {
      (Math.min(arr1(high1), arr2(high2)) + Math.max(arr1(low1), arr2(low2))) / 2
    } else {
      val arr1Median = medianOfSingleArray(arr1, low1, high1)
      val arr2Median = medianOfSingleArray(arr2, low2, high2)
      if (arr1Median == arr2Median)
        arr1Median
      else if (arr1Median < arr2Median) {
        median(arr1, (high1 + low1) / 2, high1, arr2, low2, (high2 + low2) / 2)
      } else {
        median(arr1, low1, (high1 + low1) / 2, arr2, (high2 + low2) / 2, high2)
      }
    }
  }

  private def medianOfSingleArray(arr: Array[Int], low: Int, high: Int): Int = {
    val len = (high - low) + 1
    if (len == 1) // only one element in the array i.e high = low
      arr(low)
    else if (len % 2 == 0)
      (arr(low + len / 2 - 1) + arr(low + len / 2)) / 2
    else
      arr(low + len / 2)
  }

  override def main(args: Array[String]): Unit = {
    val arr1 = Array[Int](1, 12, 15, 26, 38)
    val arr2 = Array[Int](2, 13, 17, 30, 45)
    println(s"Median : ${median(arr1, arr2)}")
  }

}
