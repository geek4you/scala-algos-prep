package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/12/17.
  */
object BalancedParanthesis {

  def balancedParanthesis(input: String): Boolean = {
    val stack = new util.LinkedList[Char]()

    input.toCharArray.foreach(char => {
      if (char == '{' || char == '[' || char == '(') {
        stack.push(char)
      } else {
        if (stack.isEmpty) {
          return false
        }
        val poped = stack.pop()
        if ((char == '}' && poped != '{') || (char == ')' && poped != '(') && (char == ']' && poped != '[')) {
          return false
        }
      }
    })
    stack.isEmpty
  }

  def main(args: Array[String]): Unit = {
    val str = "[()]{}{[()()]()}"
    println(balancedParanthesis(str))
  }
}
