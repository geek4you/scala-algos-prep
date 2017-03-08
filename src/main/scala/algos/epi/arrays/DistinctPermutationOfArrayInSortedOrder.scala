package algos.epi.arrays

import scala.collection.mutable

/**
  * Created by geek4you on 3/6/17.
  */
/**
  * This solution handles the case where input contains duplicates and also the output is in
  * lexicographically sorted
  *
  * Wonderfully explained : https://www.youtube.com/watch?v=nYFd7VHKyWQ
  */
object DistinctPermutationOfArrayInSortedOrder extends App {

  def lexicographicalDistinctPermutations(arr: Array[Char]): Unit = {

    val countMap = new mutable.TreeMap[Char, Int]()
    arr.foreach(ch => {
      if (countMap.contains(ch)) {
        countMap(ch) = countMap(ch) + 1
      } else {
        countMap(ch) = 1
      }
    })

    val chArry = new Array[Char](countMap.size)
    val countArry = new Array[Int](countMap.size)
    var i = 0

    countMap.foreach(entry => {
      chArry(i) = entry._1
      countArry(i) = entry._2
      i += 1
    })

    val result = new Array[Char](arr.length)
    permutateUtil(chArry, countArry, result, 0)
  }

  def permutateUtil(chArry: Array[Char],
                    countArry: Array[Int],
                    resultArry: Array[Char],
                    level: Int): Unit = {
    // if level is the deepest level print
    if (level == resultArry.length) {
      println(resultArry.mkString(" "))
    }

    for (i <- chArry.indices) {
      // look for the first elem from left with count > 0
      if (countArry(i) != 0) {
        resultArry(level) = chArry(i)
        countArry(i) -= 1
        permutateUtil(chArry, countArry, resultArry, level + 1)
        countArry(i) += 1 // back track
      }
    }

    /**
      * Normal permutation !!
      * Cannot handle duplicates.
      */
    def permutate(chArry: Array[Char]): Unit = {
      normalPermutateUtil(chArry, 0, chArry.length - 1)
    }

    def normalPermutateUtil(arr: Array[Char], start: Int, end: Int): Unit = {
      if (start == end)
        println(arr.mkString(" "))
      else {
        for (i <- arr.indices) {
          swap(arr, i, start)
          normalPermutateUtil(arr, start + 1, end)
          swap(arr, start, i) // backtrack
        }

      }
    }

    def swap(arr: Array[Char], index1: Int, index2: Int): Unit = {
      val tmp = arr(index1)
      arr(index1) = arr(index2)
      arr(index2) = tmp
    }
  }

  override def main(args: Array[String]): Unit = {
    val chArry = Array[Char]('a', 'b', 'c', 'a')
    lexicographicalDistinctPermutations(chArry)
  }
}
