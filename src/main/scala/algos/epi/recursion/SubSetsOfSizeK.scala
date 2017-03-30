package algos.epi.recursion

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/29/17.
  */
/**
  * Page 296
  */
object SubSetsOfSizeK {
  def combinations(n: Int, k: Int): Seq[Seq[Int]] = {
    val result = new ArrayBuffer[ArrayBuffer[Int]]()
    directedCombinations(n, k, 1, new ArrayBuffer[Int](), result)
    result
  }

  def directedCombinations(n: Int,
                           k: Int,
                           offSet: Int,
                           partialCombination: ArrayBuffer[Int],
                           result: ArrayBuffer[ArrayBuffer[Int]]): Unit = {
    if (partialCombination.size == k) {
      result += partialCombination.clone()
    } else {
      // generate remaining combinations over {offset,....,n-1} of size numRemaining
      val numRemaining = k - partialCombination.size
      var i = offSet
      while (i <= n && numRemaining <= n - i + 1) {
        partialCombination += i
        directedCombinations(n, k, i + 1, partialCombination, result)
        partialCombination.remove(partialCombination.size - 1)
        i += 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 5
    val k = 2
    val result = combinations(n, k)
    println(result.mkString("\n"))
  }
}
