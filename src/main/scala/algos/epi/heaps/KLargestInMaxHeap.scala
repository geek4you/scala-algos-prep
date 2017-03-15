package algos.epi.heaps

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Page 186
  */
object KLargestInMaxHeap {

  def kLargestInMaxHeap(input: List[Int], k: Int): mutable.ListBuffer[Int] = {
    val maxHeap = new mutable.PriorityQueue[HeapEntry]()(HeapEntryOrder)
    val result = new ListBuffer[Int]()

    maxHeap += HeapEntry(input.head, 0)
    for (i <- 0 until k) {
      val heapEntry = maxHeap.dequeue()
      result += heapEntry.value
      val parent = heapEntry.index

      val leftChild = 2 * parent + 1
      if (leftChild < input.size) {
        maxHeap += HeapEntry(input(leftChild), leftChild)
      }

      val rightChild = 2 * parent + 2
      if (rightChild < input.size) {
        maxHeap += HeapEntry(input(rightChild), rightChild)
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val input = List(561, 314, 401, 28, 156, 359, 271, 11, 3)
    println(kLargestInMaxHeap(input, 4).mkString(","))
  }
}

case class HeapEntry(value: Int, index: Int)

object HeapEntryOrder extends Ordering[HeapEntry] {
  override def compare(x: HeapEntry, y: HeapEntry): Int = {
    x.value compare y.value
  }
}
