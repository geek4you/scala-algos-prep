package algos.epi.heaps

import scala.collection.mutable

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Page 187
  */
class ImplementStackWithHeap {

  var order: Int = 0
  var maxHeap = new mutable.PriorityQueue[StackHeapEntry]()(StackHeapOrder)

  def push(x: Int): Unit = {
    maxHeap += StackHeapEntry(x, order)
    order += 1
  }

  def pop(): Int = {
    val x = maxHeap.dequeue()
    x.value
  }

  def peek(): Int = {
    maxHeap.head.value
  }

}

case class StackHeapEntry(value: Int, order: Int)

object StackHeapOrder extends Ordering[StackHeapEntry] {
  override def compare(x: StackHeapEntry, y: StackHeapEntry): Int = {
    x.order compare y.order
  }
}
