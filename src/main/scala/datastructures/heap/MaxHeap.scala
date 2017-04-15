package datastructures.heap

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/11/17.
  */
class MaxHeap[E <: Ordered[E]] {
  val heapArray = new ArrayBuffer[E]()

  def add(key: E): Unit = {
    heapArray += key
    moveUp(heapArray.length - 1)
  }

  def add(keys: Array[E]): Unit = {}

  private def moveUp(pos: Int): Unit = {
    var parent = -1
    var child = pos
    var done = false
    while (child > 0 && !done) {
      parent = (child - 1) / 2
      // check if child is less than parent
      val c = heapArray(child)
      if ((heapArray(child) compare heapArray(parent)) < 0) {
        done
      } else {
        swap(heapArray, parent, child)
        child = parent
      }
    }
  }

  private def remove(): E = {
    var returnVal: E = null.asInstanceOf[E]
    if (heapArray.nonEmpty) {
      returnVal = heapArray(0)
      swap(heapArray, 0, heapArray.length - 1)
      heapArray.remove(heapArray.length - 1)
      moveDown(0)
    }
    returnVal
  }

  private def moveDown(pos: Int): Unit = {
    var parent = pos
    var done = false

    while (parent < (heapArray.length / 2) - 1 && !done) {
      var child = 2 * parent + 1 // left child
      if (child <= heapArray.length - 1 && (heapArray(child).compare(
            heapArray(parent)) < 0)) {
        child += 1 // move to right child
      }

      if (child >= heapArray.length)
        done = true
      else {
        if (heapArray(child).compare(heapArray(parent)) > 0) {
          swap(heapArray, parent, child)
          parent = child
        }
      }
    }
  }

  def swap[E](seq: ArrayBuffer[E], index1: Int, index2: Int): Unit = {
    val tmp = seq(index1)
    seq(index1) = seq(index2)
    seq(index2) = tmp
  }
}
