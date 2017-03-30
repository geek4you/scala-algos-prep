package algos.epi.recursion

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/29/17.
  */
object PalindromicDecompositions {

  def palindromicPartitioning(input: String): Seq[Seq[String]] = {
    val result = new ArrayBuffer[ArrayBuffer[String]]()
    directedPalindromicPartitioning(input,
                                    0,
                                    new ArrayBuffer[String](),
                                    result)
    result
  }

  def directedPalindromicPartitioning(
      input: String,
      offset: Int,
      partialPartition: ArrayBuffer[String],
      result: ArrayBuffer[ArrayBuffer[String]]): Unit = {
    if (offset == input.length) {
      result += partialPartition.clone()
    } else {
      for (i <- offset + 1 to input.length) {
        val prefix = input.substring(offset, i)
        if (isPalindrome(prefix)) {
          partialPartition += prefix
          directedPalindromicPartitioning(input, i, partialPartition, result)
          partialPartition.remove(partialPartition.size - 1)
        }
      }
    }
  }

  def isPalindrome(prefix: String): Boolean = {
    var (left, right) = (0, prefix.length - 1)
    while (left < right) {
      if (prefix.charAt(left) != prefix.charAt(right))
        return false
      left += 1
      right -= 1
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val input = "0204451881"
    val result = palindromicPartitioning(input)
    println(result.mkString("\n"))
  }

}
