package algos.leetcode.arrays

import java.util

/**
  * Created by geek4you on 3/10/17.
  */
/**
  * /**
  *  @see : http://www.geeksforgeeks.org/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/
  * Recursively print all sentences that can be formed from list of word lists
 Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion?

 Example:

 Input: {{"you", "we"},
 {"have", "are"},
 {"sleep", "eat", "drink"}}

 Output:
 you have sleep
 you have eat
 you have drink
 you are sleep
 you are eat
 you are drink
 we have sleep
 we have eat
 we have drink
 we are sleep
 we are eat
 we are drink
  */
  */
object RecursivelyPrintAllSentences extends App {

  def print(input: util.ArrayList[util.ArrayList[String]]): Unit = {

    val output = new Array[String](input.size())

    // Consider all words for first row as starting points and
    // print all sentences
    for (i <- 0 until input.get(0).size()) {
      if (input.get(0).get(i) != "") {
        printUtil(input, 0, i, output)
      }
    }
  }

  def printUtil(input: util.ArrayList[util.ArrayList[String]],
                level: Int,
                pos: Int,
                output: Array[String]): Unit = {

    // add the word to the output
    output(level) = input.get(level).get(pos)

    // print if this is the last level
    if (level == input.size() - 1) {
     println(output.mkString(" "))
    } else {
      // go down to the next level
      for (i <- 0 until input.get(level + 1).size()) {
        if (input.get(level + 1).get(i) != "") {
          printUtil(input, level + 1, i, output)
        }
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val arr1 = new util.ArrayList[String]()

    arr1.add("you")
    arr1.add("we")

    val arr2 = new util.ArrayList[String]()
    arr2.add("have")
    arr2.add("are")

    val arr3 = new util.ArrayList[String]()
    arr3.add("sleep")
    arr3.add("eat")
    arr3.add("drink")

    val input = new util.ArrayList[util.ArrayList[String]]
    input.add(arr1)
    input.add(arr2)
    input.add(arr3)

    print(input)
  }
}
