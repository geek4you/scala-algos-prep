package algos.geeks4geeks.stacks

import java.util

/**
  * Created by geek4you on 3/18/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/largest-rectangle-under-histogram/]]
  * @see [[http://www.geeksforgeeks.org/largest-rectangle-under-histogram/]]
  * @see [[https://www.youtube.com/watch?v=VNbkzsnllsU&t=317s]]
  */
object MaxRectangleInHistogram {

  // find the maximum rectangular area under given
  // histogram with n bars
  def getMaxArea(hist: Array[Int]): Int = {
    // Create an empty stack. The stack holds indexes of hist[] array
    // The bars stored in stack are always in increasing order of their
    // heights.
    val stack = new util.LinkedList[Int]()
    var maxArea = 0
    var areaWithTop = 0 // To store area with top bar as the smallest bar

    // Run through all bars of given histogram
    var i = 0
    while (i < hist.length) {
      // If this bar is higher than the bar on top stack, push it to stack
      if (stack.isEmpty || hist(stack.peekFirst()) <= hist(i)) {
        stack.addFirst(i)
        i += 1
      } else {
        // If this bar is lower than top of stack, then calculate area of rectangle
        // with stack top as the smallest (or minimum height) bar. 'i' is
        // 'right index' for the top and element before top in stack is 'left index'
        val topOfStack = stack.removeFirst() // pop the top

        // Calculate the area with hist[topOfStack] stack as smallest bar
        if (stack.isEmpty) {
          areaWithTop = hist(topOfStack) * i
        } else {
          areaWithTop = hist(topOfStack) * (i - stack.peekFirst() - 1)
        }

        // update max area, if needed
        maxArea = Math.max(maxArea, areaWithTop)
      }
    }

    // Now pop the remaining bars from stack and calculate area with every
    // popped bar as the smallest bar
    while (stack.isEmpty) {
      val topOfStack = stack.removeFirst()
      if (stack.isEmpty) {
        areaWithTop = hist(topOfStack) * i
      } else {
        areaWithTop = hist(topOfStack) * (i - stack.peekFirst() - 1)
      }
      maxArea = Math.max(maxArea, areaWithTop)
    }

    maxArea
  }

  def main(args: Array[String]): Unit = {
    val hist = Array(6, 2, 5, 4, 5, 1, 6)
    println(getMaxArea(hist))
  }
}
