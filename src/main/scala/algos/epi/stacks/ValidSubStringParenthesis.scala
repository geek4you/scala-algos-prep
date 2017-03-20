package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/19/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/]]
  * Input: str = "(()()"

Initialize result as 0 and stack with one item -1.

For i = 0, str[0] = '(', we push 0 in stack

For i = 1, str[1] = '(', we push 1 in stack

For i = 2, str[2] = ')', currently stack has [-1, 0, 1], we pop
from the stack and the stack now is [-1, 0] and length of current
valid substring becomes 2 (we get this 2 by subtracting stack top
from current index).
Since current length is more than current result, we update result.

For i = 3, str[3] = '(', we push again, stack is [-1, 0, 3].

For i = 4, str[4] = ')', we pop from the stack, stack becomes
[-1, 0] and length of current valid substring becomes 4 (we get
this 4 by subtracting stack top from current index).
Since current length is more than current result, we update result.
  */
object ValidSubStringParenthesis {

  def maxValidSubString(expr: String): Int = {

    val stack = new util.LinkedList[Int]()
    // Initialize result
    var result = 0

    // traverse all the elements in the array
    for (i <- 0 until expr.length) {
      // If opening bracket, push index of it
      if (expr.charAt(i) == '(') {
        stack.addFirst(i)
      } else { // If closing bracket
        // Pop the previous opening bracket's index
        stack.removeFirst()

        // Check if this length formed with base of
        // current valid substring is more than max
        // so far
        if (!stack.isEmpty) {
          result = Math.max(result, i - stack.peekFirst())
        }
        // If stack is empty. push current index as
        // base for next valid substring (if any)
        else stack.addFirst(i)

      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val expr = "()(()))))"
    println(maxValidSubString(expr))

  }
}
