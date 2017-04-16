package algos.epi.queues

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/15/17.
  */
class QueueWithMax[T <: Ordered[T]] {

  val entries = new ListBuffer[T]()
  val candidatesForMax = new ListBuffer[T]()

  def enqueue(x: T): Unit = {
    entries += x
    var done = false
    while (candidatesForMax.nonEmpty && !done) {
      // eliminate dominated candidates in the candidatesForMax
      if (candidatesForMax.last < x)
        candidatesForMax.remove(candidatesForMax.length - 1)
      else
        done = true
    }
    candidatesForMax += x
  }

  def deQueue(): T = {
    if (entries.nonEmpty) {
      val returnVal = entries.remove(0)
      if (candidatesForMax.head == returnVal)
        candidatesForMax.remove(0)
      returnVal
    } else
      throw new NoSuchElementException("Called dequeue() on empty queue !!")
  }

  def isEmpty(): Boolean = entries.isEmpty

  def max(): T = {
    if (entries.nonEmpty) {
      candidatesForMax.head
    } else throw new NoSuchElementException("Called max() on empty queue !!")
  }

  def peek(): T = {
    if (entries.nonEmpty)
      entries.head
    else throw new NoSuchElementException("Called peek() on empty queue !!")
  }
}
