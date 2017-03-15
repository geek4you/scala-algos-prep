package algos.epi.heaps

import scala.collection.mutable

/**
  * Created by geek4you on 3/13/17.
  */
object OnlineMedian {

  def onlineMedian(sequence: Iterator[Int]): Unit = {
    // min-heap stores the larger half seen so far
    val minHeap = new mutable.PriorityQueue[Int]()(MinOrder)

    // max-heap stores the smaller half seen so far
    val maxHeap = new mutable.PriorityQueue[Int]()

    while (sequence.hasNext) {
      val x = sequence.next()
      if (minHeap.isEmpty) { // this is very first element
        minHeap += x
      } else {
        if (x > minHeap.head) {
          minHeap += x
        } else {
          maxHeap += x
        }
      }
      // ensure minHeap and maxHeap have equal number of elements if even number of elements is read: otherwise
      // minheap must have one more element than the max heap
      if (minHeap.size > maxHeap.size + 1) {
        maxHeap += minHeap.dequeue()
      } else if (maxHeap.size > minHeap.size) {
        minHeap += maxHeap.dequeue()
      }

      val median = if (minHeap.size == maxHeap.size) {
        0.5 * (minHeap.head + maxHeap.head)
      } else
        minHeap.head

      print(s"$median ")
    }
  }

  def main(args: Array[String]): Unit = {
    val in = Array(1,0,3,5,2,0,1)
    onlineMedian(in.iterator)
  }
}

object MinOrder extends Ordering[Int] {
  def compare(x: Int, y: Int) = y compare x
}
