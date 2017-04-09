package algos.epi.greedy

import scala.collection.mutable

/**
  * Created by geek4you on 4/7/17.
  */
/**
  * Hint: Alphabet size may be assumed as constant (256) and extra space may be used.

Solution: The idea is to count frequencies of all characters and consider the most frequent character first and place all occurrences of it as close as possible. After the most frequent character is placed, repeat the same process for remaining characters.

1) Let the given string be str and size of string be n

2) Traverse str, store all characters and their frequencies in a Max Heap MH. The value of frequency decides the order in MH, i.e., the most frequent character is at the root of MH.

3) Make all characters of str as ‘\0’.

4) Do following while MH is not empty.
…a) Extract the Most frequent character. Let the extracted character be x and its frequency be f.
…b) Find the first available position in str, i.e., find the first ‘\0’ in str.
…c) Let the first position be p. Fill x at p, p+d,.. p+(f-1)d
  * @see http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
  */
object RearrangeStringSameCharactersBecomeDDistanceAway {

  def rearrange(input: String, d: Int): String = {

    // get the frequency count
    val freq = new mutable.HashMap[Char, Int]()
    input.foreach(ch => {
      if (freq.contains(ch))
        freq(ch) += 1
      else
        freq(ch) = 1
    })

    // store in max heap with freqCount
    val maxHeap = new mutable.PriorityQueue[HeapEntry]()(HeapEntryOrder)
    freq.foreach(entry => maxHeap += HeapEntry(entry._1, entry._2))

    val result = Array.fill[Char](input.length)('\0')

    while (maxHeap.nonEmpty) {
      val head = maxHeap.dequeue()
      // find the first location to insert
      var done = false
      var writeIdx = 0
      while (writeIdx < result.length && !done) {
        if (result(writeIdx) == '\0') {
          done = true
        }
        writeIdx += 1
      }
      writeIdx -= 1
      // start from this character and set the element
      var entryFreq = head.freq
      while (writeIdx < result.length && entryFreq > 0) {
        result(writeIdx) = head.char
        entryFreq -= 1
        writeIdx += d
      }

      if (writeIdx >= result.length && entryFreq > 0) {
        // If the index goes beyond size, then string cannot
        // be rearranged.
        throw new RuntimeException("Cannot be rearranged")
      }
    }

    new String(result)
  }

  def main(args: Array[String]): Unit = {
    val input = "aabbcc"
    println(rearrange(input, 3))
    println(rearrange("abb", 2))
    println(rearrange("geeksforgeeks", 3))
  }

  case class HeapEntry(char: Char, freq: Int)

  object HeapEntryOrder extends Ordering[HeapEntry] {
    override def compare(x: HeapEntry, y: HeapEntry): Int = {
      x.freq compare y.freq
    }
  }
}
