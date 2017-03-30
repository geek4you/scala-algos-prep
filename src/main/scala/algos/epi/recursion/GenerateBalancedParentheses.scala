package algos.epi.recursion

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * Created by pradeep on 3/29/17.
  */
object GenerateBalancedParentheses {

  def generateBalancedParentheses(numPairs: Int): Seq[String] = {
    val result = new ArrayBuffer[String]()
    directedGenerateBalancedParentheses(numPairs, numPairs, "", result)
    result
  }

  def directedGenerateBalancedParentheses(
      numLeftParensNeeded: Int,
      numRightParensNeeded: Int,
      validPrefix: String,
      result: ArrayBuffer[String]): Unit = {
    if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) { // check if balanced
      if (balancedParentheses(validPrefix))
        result += validPrefix
    } else {
      if (numLeftParensNeeded > 0) { // able to insert '('
        directedGenerateBalancedParentheses(numLeftParensNeeded - 1,
                                            numRightParensNeeded,
                                            validPrefix + "(",
                                            result)
      }
      if (numRightParensNeeded > 0) { // able to insert ')'
        directedGenerateBalancedParentheses(numLeftParensNeeded,
                                            numRightParensNeeded - 1,
                                            validPrefix + ")",
                                            result)
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val numPairs = 2
    val result = generateBalancedParentheses(numPairs)
    println(result.mkString("\n"))
  }

  def balancedParentheses(input: String): Boolean = {
    val stack = new util.LinkedList[Char]()

    input.toCharArray.foreach(char => {
      if (char == '(') {
        stack.push(char)
      } else {
        if (stack.isEmpty)
          return false
        else {
          val poped = stack.pop()
          if ((char == '}' && poped != '{') || (char == ')' && poped != '(') && (char == ']' && poped != '[')) {
            return false
          }
        }
      }
    })
    stack.isEmpty
  }
}
