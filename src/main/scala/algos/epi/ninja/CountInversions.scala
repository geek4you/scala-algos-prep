package algos.epi.ninja

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 490
  * @see http://www.geeksforgeeks.org/counting-inversions/
  */
object CountInversions {

  def countInversions(input: Array[Int]): Int = {
    countSubArrayInversions(input, 0, input.length)
  }

  /**
    * Return the number of inversions in input.subList(start,end)
    * Same as merge sort
    */
  def countSubArrayInversions(input: Array[Int], start: Int, end: Int): Int = {
    if (end - start > 1) {
      val mid = start + (end - start) / 2
      countSubArrayInversions(input, start, mid) + countSubArrayInversions(
        input,
        mid,
        end) + mergeSortAndCountInversionsAcrossSubArrays(input,
                                                          start,
                                                          mid,
                                                          end)
    } else 0
  }

  /**
    * Merge two sorted sub lists input.sublist(start,mid) and input.sublist(mid,end) into
    * input.sublist(start,end) and return the number of inversions across input.sublist(start,mid) and input.sublist(mid,end)
    */
  def mergeSortAndCountInversionsAcrossSubArrays(input: Array[Int],
                                                 start: Int,
                                                 mid: Int,
                                                 end: Int): Int = {
    val sortedA = new ArrayBuffer[Int]()
    var leftStart = start
    var rightStart = mid
    var inversionCount = 0
    while (leftStart < mid && rightStart < end) {
      if (input(leftStart) < input(rightStart)) {
        sortedA += input(leftStart)
        leftStart += 1
      } else {
        // input.subList(leftStart, mid) are inversions of input(rightStart)
        inversionCount += mid - leftStart
        sortedA += input(rightStart)
        rightStart += 1
      }
    }

    // add remaining
    for (i <- leftStart until mid)
      sortedA += input(leftStart)

    for (i <- rightStart until  end)
      sortedA += input(rightStart)

    // updates input with sortedA
    var lStart = start
    sortedA.foreach(x => {
      input(lStart) = x
      lStart += 1
    })
    inversionCount
  }

  def main(args: Array[String]): Unit = {
    val input = Array(2, 4, 1, 3, 5, 1)
    println(countInversions(input))
  }

}
