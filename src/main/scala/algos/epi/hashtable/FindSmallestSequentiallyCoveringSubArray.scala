package algos.epi.hashtable

import java.util

import scala.collection.mutable

/**
  * Created by geek4you on 3/23/17.
  */
/**
  * Page 226
  */
object FindSmallestSequentiallyCoveringSubArray {

  def smallestSeqSubArray(paragraph: Array[String],
                          keyWords: Array[String]): SubArray = {

    // map each keyword to its index in the keywords array
    val keyWordToIdx = mutable.Map[String, Int]()

    // since keywords are uniquely identified by their indices in keywords array,
    // we can use those indices as keys to look-up in vector
    val latestOccurrence = new util.ArrayList[Int](keyWords.length)

    // For each keyword (identified by its index in keywords array), stores the length
    // of the shortest subarray ending at the most recent occurrence of that keyword that
    // sequentially cover all keywords up to that keyword.
    val shortestSubArrayLength = new util.ArrayList[Int]()

    // initializes latestOccurrence, shortestSubArrayLength and  keyWordToIdx
    for (i <- keyWords.indices) {
      latestOccurrence.add(-1)
      shortestSubArrayLength.add(Int.MaxValue)
      keyWordToIdx(keyWords(i)) = i
    }

    var shortestDistance = Int.MaxValue
    val result = SubArray(-1, -1)

    for (i <- paragraph.indices) {
      val keyWordIdxOption = keyWordToIdx.get(paragraph(i))
      if (keyWordIdxOption.isDefined) {
        val keyWordIdx = keyWordIdxOption.get
        if (keyWordIdx == 0) { // first keyword
          shortestSubArrayLength.set(0, 1)
        } else if (shortestSubArrayLength.get(keyWordIdx - 1) != Int.MaxValue) { // check if the sequential previous keyword already appeared
          // get the distance of this keyword idx to the its previous keyword latest occurrence idx
          val distanceToPreviousKeyWord = i - latestOccurrence.get(
            keyWordIdx - 1)

          // update the shortest sub array ending here
          shortestSubArrayLength.set(
            keyWordIdx,
            shortestSubArrayLength
              .get(keyWordIdx - 1) + distanceToPreviousKeyWord)
        }
        latestOccurrence.set(keyWordIdx, i)

        // last keyword, look for improved sub array
        if (keyWordIdx == keyWordToIdx.size - 1 && shortestSubArrayLength.get(
              keyWordIdx) < shortestDistance) {
          shortestDistance = shortestSubArrayLength.get(keyWordIdx)
          result.start = i - shortestSubArrayLength.get(keyWordIdx) + 1
          result.end = i
        }
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val paragraph = Array("apple", "banana", "cat", "apple")
    val keywords = Array("banana", "apple")
    println(smallestSeqSubArray(paragraph, keywords))
  }
}
