package algos.leetcode.arrays

import java.util

/**
  * Created by geek4you on 3/10/17.
  */
/**
  * @see : http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
  * Anagram Substring Search (Or Search for all permutations)
  * <p>
  * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all
  * occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m.
  * Expected time complexity is O(n)
  * <p>
  * Examples:
  * <p>
  * 1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
  * Output:   Found at Index 0
  * Found at Index 5
  * Found at Index 6
  * 2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
  * Output:   Found at Index 0
  * Found at Index 1
  * Found at Index 4
  * <p>
  * We can achieve O(n) time complexity under the assumption that alphabet size is fixed which is typically true as we have
  * maximum 256 possible characters in ASCII. The idea is to use two count arrays:
  * <p>
  * 1) The first count array store frequencies of characters in pattern.
  * 2) The second count array stores frequencies of characters in current window of text.
  * <p>
  * The important thing to note is, time complexity to compare two count arrays is O(1) as the number of elements in them
  * are fixed (independent of pattern and text sizes). Following are steps of this algorithm.
  * 1) Store counts of frequencies of pattern in first count array countP[]. Also store counts of frequencies of characters
  * in first window of text in array countTW[].
  * <p>
  * 2) Now run a loop from i = M to N-1. Do following in loop.
  * …..a) If the two count arrays are identical, we found an occurrence.
  * …..b) Increment count of current character of text in countTW[]
  * …..c) Decrement count of first character in previous window in countWT[]
  * <p>
  * 3) The last window is not checked by above loop, so explicitly check it.
  */
// todo: REVIEW
object AnagramSearch extends App {

  def anagramSearch(txt: Array[Char], pat: Array[Char]): Array[AnyRef] = {
    val output = new util.ArrayList[Int]()

    // counts arrays
    // countP[]:  Store count of all characters of pattern
    // countT[]: Store count of current window of text
    val countP = new Array[Int](256)
    val countT = new Array[Int](256)

    //1st window
    for (i <- pat.indices) {
      countT(pat(i)) += 1
      countP(txt(i)) += 1
    }

    for (i <- pat.length until txt.length) {

      if (isSame(countP, countT)) {
        output.add(i - pat.length)
      }
      // update the window
      // remove the count from the start of the countT array.
      countT(txt(i - pat.length)) -= 1
      // add the present to the window
      countT(txt(i)) += 1
    }

    // check for the last window
    if (isSame(countP, countT))
      output.add(txt.length - pat.length)

    output.toArray

  }

  def isSame(arr1: Array[Int], arr2: Array[Int]): Boolean = {
    if (arr1.length != arr2.length)
      false
    else {
      for (i <- arr1.indices) {
        if (arr1(i) != arr2(i)) {
          return false
        }
      }
      true
    }
  }

  override def main(args: Array[String]): Unit = {
    val txt =
      Array[Char]('B', 'A', 'C', 'D', 'G', 'A', 'B', 'C', 'D', 'A', 'B')
    val pat = Array[Char]('A', 'B', 'C', 'D')
    println(anagramSearch(txt, pat).mkString(" "))
  }

}
