package algos.epi.recursion

import scala.collection.mutable

/**
  * Created by geek4you on 3/29/17.
  */
/**
  * Combination of Characters in String (All subsets of characters)
  * Without duplicates same as [[PowerSet]]. With duplicates here is the solution.
  * @see https://www.youtube.com/watch?v=xTNFs5KRV_g
  */
object CombinationsOfStringWithDuplicates {

  def combination(input: Array[Char]): Unit = {
    val countMap = mutable.TreeMap[Char, Int]()

    input.foreach(ch => {
      if (countMap.contains(ch)) {
        countMap(ch) += 1
      } else countMap += (ch -> 1)
    })

    val mapIter = countMap.iterator
    val countArray = new Array[Int](countMap.size)
    val charArray = new Array[Char](countMap.size)

    var i = 0
    countMap.foreach(entry => {
      charArray(i) = entry._1
      countArray(i) = entry._2
      i += 1
    })

    val output = new Array[Char](input.length)
    combinationUtil(charArray, countArray, 0, output, 0)
  }

  def combinationUtil(chArray: Array[Char],
                      countArray: Array[Int],
                      pos: Int,
                      output: Array[Char],
                      len: Int): Unit = {
    printOutput(output, len)
    for (i <- pos until chArray.length) {
      if (countArray(i) != 0) {
        output(len) = chArray(i)
        countArray(i) -= 1
        combinationUtil(chArray, countArray, i, output, len + 1)
        countArray(i) += 1
      }
    }
  }

  def printOutput(output: Array[Char], len: Int): Unit = {
    val buffer = new mutable.StringBuilder()
    for (i <- 0 until len) {
      buffer += output(i)
    }
    println(buffer.toString())
  }

  def main(args: Array[String]): Unit = {
    val chArray = Array[Char]('A', 'A', 'B', 'C')
    combination(chArray)
  }

}
