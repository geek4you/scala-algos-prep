package hashtable

import scala.collection.mutable

/**
  * Created by geek4you on 3/15/17.
  */

/**
 * Page 214
 */
object CheckPalindromicPermutation {

  def checkPalindromicPermutation(input: String): Boolean = {

    val charFreqMap = mutable.Map[Char, Int]()

    for (i <- 0 until input.length) {

      val ch = input.charAt(i)

      if (!charFreqMap.contains(ch)) {
        charFreqMap(ch) = 1
      } else {
        charFreqMap(ch) += 1
      }
    }

    // A string can be permuted as a palindrome if and ony if the number of chars whose frequencies is odd is at most 1
    var oddCount = 0

    val iter = charFreqMap.iterator

    while (iter.hasNext) {
      val entry = iter.next()
      if (entry._2 % 2 != 0) {
        oddCount += 1
      }
      if (oddCount > 1)
        return false
    }

    true
  }

  def main(args: Array[String]): Unit = {
    val input = "edified"
    println(checkPalindromicPermutation(input))
  }

}
