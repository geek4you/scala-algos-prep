package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/next-greater-element/]]
  */
object NextGreaterElement {

  def nextGreaterElement(input: Array[Int]): Array[Int] = {

    val result = new Array[Int](input.length)
    val stack = new util.LinkedList[Int]()
    stack.addFirst(0)
    for (i <- 1 until input.length) {
      /* If the popped element is smaller than next, then
                a) print the pair
                b) keep popping while elements are smaller and
                stack is not empty */
      while (!stack.isEmpty && input(stack.peekFirst()) < input(i)) {
        result(stack.removeFirst()) = input(i)
      }

      stack.addFirst(i)
    }

    /* After iterating over the loop, the remaining
       elements in stack do not have the next greater
       element, so print -1 for them */
    while (!stack.isEmpty) {
      result(stack.removeFirst()) = -1
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val input = Array(11, 13, 21, 3)
    val result = nextGreaterElement(input)
    for (i <- input.indices) {
      println(s"${input(i)}  ->  ${result(i)}")
    }
  }
}
