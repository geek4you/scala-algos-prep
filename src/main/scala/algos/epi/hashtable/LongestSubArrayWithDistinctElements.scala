package algos.epi.hashtable

import scala.collection.mutable

/**
  * Created by geek4you on 3/23/17.
  */
/**
  * Page 227
  */
object LongestSubArrayWithDistinctElements {

  def longestSubArrayWithDistinctEntries(input: Array[Char]): Int = {
    // records the most recent occurrence of each entry
    val mostRecentOccurrece = mutable.Map[Char, Int]()
    var longestDupFreeSubArrayStartIdx = 0
    var result = 0
    for (i <- input.indices) {
      val dupIdxOption = mostRecentOccurrece.get(input(i))
      mostRecentOccurrece(input(i)) = i
      // input(i) appeared before. Did it appear in the longest current subarray?
      if (dupIdxOption.isDefined) {
        val dupIdx = dupIdxOption.get
        if (dupIdx >= longestDupFreeSubArrayStartIdx) {
          result = Math.max(result, i - longestDupFreeSubArrayStartIdx)
          longestDupFreeSubArrayStartIdx = dupIdx + 1
        }
      }
    }

    result = Math.max(result, input.size - longestDupFreeSubArrayStartIdx)
    result
  }

  def main(args: Array[String]): Unit = {
    val input = Array('f', 's', 'f', 'e', 't', 'w', 'e', 'n', 'w', 'e')
    println(longestSubArrayWithDistinctEntries(input))
  }
}
