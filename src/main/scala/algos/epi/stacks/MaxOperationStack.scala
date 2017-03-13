package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/12/17.
  */
object MaxOperationStack {

  val stack = new util.ArrayDeque[Int]()
  val maxStack = new util.ArrayDeque[Int]()

  def add(key: Int): Unit = {
    stack.push(key)
    maxStack.push(Math.max(maxStack.peek(), key))
  }

  def pop(): Int = {
    if (isEmpty)
      throw new RuntimeException(" Stack is empty !!")
    maxStack.pop()
    stack.pop()
  }

  def max(): Int = {
    if (isEmpty)
      throw new RuntimeException(" Stack is empty !!")
    maxStack.peek()
  }

  def isEmpty: Boolean = stack.isEmpty
}
