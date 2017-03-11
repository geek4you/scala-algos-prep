package algos.leetcode.arrays

/**
  * Created by geek4you on 3/10/17.
  */
/**
  * @see : http://www.geeksforgeeks.org/print-all-combinations-of-given-length/
  *
  * Print all possible strings of length k that can be formed from a set of n characters
Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from
the given set.

Examples:

Input:
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb


Input:
set[] = {'a', 'b', 'c', 'd'}, k = 1
Output:
a
b
c
d
For a given set of size n, there will be n^k possible strings of length k. The idea is to start from an empty output string (we call it prefix in following code). One by one add all characters to prefix. For every character added, print all possible strings with current prefix by recursively calling for k equals to k-1.
Following is Java implementation for same.
  */
object PrintAllPossibleStringsOfLengthKFromNChars extends App {

  def printAllPossibilities(input: Array[Char], k: Int): Unit = {
    val output = new Array[Char](k)

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
    val arr = Array[Char]('a', 'b')
    printAllPossibilities(arr, 3)
  }
}
