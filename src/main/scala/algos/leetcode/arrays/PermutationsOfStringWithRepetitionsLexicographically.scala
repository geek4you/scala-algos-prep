package algos.leetcode.arrays

/**
  * Created by geek4you on 3/10/17.
  */

/**
  * @see : http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
  *
  * Print all permutations with repetition of characters
Given a string of length n, print all permutation of the given string. Repetition of characters is allowed.
Print these permutations in lexicographically sorted order
Examples:

Input: AB
Ouput: All permutations of AB with repetition are:
AA
AB
BA
BB

Input: ABC
Output: All permutations of ABC with repetition are:
AAA
AAB
AAC
ABA
...
...
CCB
CCC
For an input string of size n, there will be n^n permutations with repetition allowed. The idea is to fix the first
character at first index and recursively call for other subsequent indexes. Once all permutations starting with the
first character are printed, fix the second character at first index. Continue these steps till last character.
  */
object PermutationsOfStringWithRepetitionsLexicographically extends App{

  def allLexicographic(input: Array[Char]): Unit = {
    val output = new Array[Char](input.length)

    input.sortBy(x => x)

    for (i <- input.indices) {
      printUtil(input, 0, i, output)
    }
  }

  def printUtil(input: Array[Char],
    level: Int,
    pos: Int,
    output: Array[Char]): Unit = {

    // add elem to array
    output(level) = input(pos)

    // print if last entry
    if (level == output.length - 1) {
      println(output.mkString(" "))
    } else {
      for (i <- input.indices) {
        printUtil(input, level + 1, i, output)
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val str = Array[Char]('A','B','C')
    allLexicographic(str)
  }

}
