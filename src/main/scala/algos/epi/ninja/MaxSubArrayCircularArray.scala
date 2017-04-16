package algos.epi.ninja

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/16/17.
  */
/**
  * Page 497
  */
object MaxSubArrayCircularArray {

  def findMaxSubArray(input: Array[Int]): Int = {
    var maximumTill = 0
    var maximum = 0
    input.foreach(elem => {
      maximumTill = Math.max(elem, elem + maximumTill)
      maximum = Math.max(maximum, maximumTill)
    })
    maximum
  }

  def findCircularMaxSubArray(input: Array[Int]): Int = {
    // Max subArray sum starts at index 0 and ends at or before index i
    val maximumBegin = new ArrayBuffer[Int]()
    var sum = input(0)
    maximumBegin += sum
    for (i <- 1 until input.length) {
      sum += input(i)
      maximumBegin += Math.max(maximumBegin.last, sum)
    }

    // Max subArray sum start at index i+1 and ends at last elements
    val maximumEnd = ArrayBuffer.fill(input.size)(0)
    sum = 0
    for (i <- input.size - 2 to 0 by -1) {
      sum += input(i + 1)
      maximumEnd(i) = Math.max(sum, maximumEnd(i + 1))
    }

    // calculates maximum sub-array which is cicular
    var circularMax = 0
    for (i <- input.indices) {
      circularMax = Math.max(circularMax, maximumBegin(i) + maximumEnd(i))
    }
    circularMax
  }
}
