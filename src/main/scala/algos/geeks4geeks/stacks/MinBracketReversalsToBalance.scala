package algos.geeks4geeks.stacks

import java.util

/**
  * Created by geek4you on 3/19/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/]]
  * Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced.
  * Find minimum number of bracket reversals to make the expression balanced.
  * Examples:
         Input:  exp = "}{"
         Output: 2
         We need to change '}' to '{' and '{' to
         '}' so that the expression becomes balanced,
         the balanced expression is '{}'

        Input:  exp = "{{{"
        Output: Can't be made balanced using reversals

        Input:  exp = "{{{{"
        Output: 2

        Input:  exp = "{{{{}}"
        Output: 1

        Input:  exp = "}{{}}{{{"
        Output: 3


  */
object MinBracketReversalsToBalance {

  /**
    * Returns count of minimum reversals for making expr balanced.
    * Returns -1 if expr cannot be balanced.
    */
  def minReversals(expr: String): Int = {

    // length of expression must be even to make
    // it balanced by using reversals.
    if (expr.length % 2 != 0) {
      -1
    } else {
      val stack = new util.LinkedList[Char]()
      // After this loop, stack contains unbalanced
      // part of expression, i.e., expression of the
      // form "}}..}{{..{"
      for (i <- 0 until expr.length) {
        if (expr.charAt(i) == '}' && !stack.isEmpty) {

          if (stack.peekFirst() == '{')
            stack.removeFirst()
          else
            stack.push(expr.charAt(i))
        } else {
          stack.push(expr.charAt(i))
        }
      }

      //Let m be the total number of closing brackets and n be the number of opening brackets. We need ⌈m/2⌉ + ⌈n/2⌉ reversals.
      // For example }}}}{{ requires 2+1 reversals.
      // Length of the reduced expression
      // red_len = (m+n)
      val reducedLen = stack.size()

      // count opening brackets at the end of stack
      var openBracesCount = 0
      while (!stack.isEmpty && stack.peekFirst() == '{') {
        stack.removeFirst()
        openBracesCount += 1
      }

      // return ceil(m/2) + ceil(n/2) which is
      // actually equal to (m+n)/2 + n%2 when
      // m+n is even.
      reducedLen / 2 + openBracesCount % 2
    }
  }

  def main(args: Array[String]): Unit = {
    val expr = "}{{}}{{{"
    println(minReversals(expr))
  }

}
