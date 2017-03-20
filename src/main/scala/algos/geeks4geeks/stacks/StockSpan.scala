package algos.geeks4geeks.stacks

import java.util

/**
  * Created by geek4you on 3/19/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/the-stock-span-problem/]]
  */
object StockSpan {

  def stockSpans(price: Array[Int]): Array[Int] = {
    val spans = new Array[Int](price.length)

    // Create a stack and push index of first element to it
    val stack = new util.LinkedList[Int]()
    stack.addFirst(0)

    // Span value of first element is always 1
    spans(0) = 1

    // Calculate span values for rest of the elements
    for (i <- 1 until price.length) {
      // Pop elements from stack while stack is not empty and top of
      // stack is smaller than price[i]
      while (!stack.isEmpty && price(stack.peek()) < price(i)) {
        stack.removeFirst()
      }

      // If stack becomes empty, then price[i] is greater than all elements
      // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
      // is greater than elements after top of stack
      if (stack.isEmpty) {
        spans(i) = i + 1
      } else {
        spans(i) = i - stack.peekFirst()
      }

      // push the element into the stack
      stack.addFirst(i)
    }

    spans
  }

  def main(args: Array[String]): Unit = {
    val price = Array(10, 4, 5, 90, 120, 80)
    println(stockSpans(price).mkString(","))
  }

}
