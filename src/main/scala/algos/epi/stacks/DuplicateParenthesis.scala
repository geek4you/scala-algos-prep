package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/19/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/]]
  */
object DuplicateParenthesis {

  def findDuplicateParenthesis(expr: String): Boolean = {

    val stack = new util.LinkedList[Int]()

    // Iterate through the given expression
    for (i <- 0 until expr.length) {
      if (expr.charAt(i) == ')') {
        // pop character from the stack
        var top = stack.removeFirst()
        // if immediate pop is a open parenthesis '(',
        // we have found duplicate
        if (top == '(') {
          return true
        }
        // else we continue popping characters from the
        // stack till open parenthesis '(' is encountered
        else {
          while (top != '(') {
            top = stack.removeFirst()
          }
        }
      } else
        stack.push(expr(i))
    }

    // no duplicates found
    false
  }

  def main(args: Array[String]): Unit = {
    val expr = "(((a+(b))+(c+d)))"
    println(findDuplicateParenthesis(expr))
  }

}
