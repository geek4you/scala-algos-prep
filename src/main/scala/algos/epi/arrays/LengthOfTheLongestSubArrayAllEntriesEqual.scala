package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/5/17.
  */
/**
  * Page 71
  */
object LengthOfTheLongestSubArrayAllEntriesEqual {
  def longestLen(arr: util.ArrayList[Int]): Int = {
    var maxLength = 1
    var startIndex = 0
    for (i <- 1 until arr.size()) {
      if (arr.get(i) != arr.get(startIndex)) {
        maxLength = Math.max(maxLength, i - startIndex )
        startIndex = i
      }
    }
    maxLength
  }

  def main(args: Array[String]): Unit = {
    val arr = new util.ArrayList[Int]()
    arr.add(10)
    arr.add(11)
    arr.add(2)
    arr.add(2)
    arr.add(2)
    arr.add(2)
    arr.add(4)
    arr.add(4)
    arr.add(5)
    print(longestLen(arr))
  }
}
