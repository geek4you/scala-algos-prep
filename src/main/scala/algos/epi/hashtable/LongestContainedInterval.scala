package algos.epi.hashtable

import scala.collection.mutable

/**
  * Created by geek4you on 4/23/17.
  */
object LongestContainedInterval {

  def longestContainedRange(input: Array[Int]): Int = {
    // unprocessed records the existence of each entry in input
    val unprocessedEntries = new mutable.HashSet[Int]()
    unprocessedEntries ++= input


    var maxIntervalSize = 0
    while (unprocessedEntries.nonEmpty) {

      var a = unprocessedEntries.iterator.next()
      unprocessedEntries.remove(a)

      // finds the lower bound of largest range containing a
      var lowerBound = a - 1
      while (unprocessedEntries.contains(lowerBound)) {
        unprocessedEntries.remove(lowerBound)
        lowerBound -= 1
      }

      // Finds the upper bound of the largest range containing a
      var upperBound = a + 1
      while (unprocessedEntries.contains(upperBound)) {
        unprocessedEntries.remove(upperBound)
        upperBound += 1
      }

      maxIntervalSize = Math.max(upperBound - lowerBound - 1, maxIntervalSize)
    }
    maxIntervalSize
  }
}
