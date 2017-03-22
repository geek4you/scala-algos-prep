package algos.epi.heaps

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/13/17.
  */
class MergeSortedArrays {

  case class HeapNode(arrayId: Int, elem: Int, arrayOffset: Int)

  def mergeSortedArrays(sortedArrays: Array[Array[Int]]): ArrayBuffer[Int] = {
    val minHeap = scala.collection.mutable
      .PriorityQueue[HeapNode]()(Ordering.by[HeapNode, Int](_.elem).reverse)

    val resultBuffer = ArrayBuffer[Int]()

    // put in 1st elements of each array
    for (i <- sortedArrays.indices if sortedArrays(i).length > 0)
      minHeap += HeapNode(i, sortedArrays(i)(0), 0)

    while (minHeap.nonEmpty) {
      val heapNode = minHeap.dequeue()
      resultBuffer += heapNode.elem
      val nextOffset = heapNode.arrayOffset + 1
      if (nextOffset < sortedArrays(heapNode.arrayId).length) {
        minHeap += HeapNode(heapNode.arrayId,
                            sortedArrays(heapNode.arrayId)(nextOffset),
                            nextOffset)
      }
    }
    resultBuffer
  }

}

object MergeSortedArraysTest extends App {

  val in = Array(
    Array(1, 5, 10),
    Array(2, 3, 100),
    Array(2, 12, Integer.MAX_VALUE)
  )

  println(new MergeSortedArrays().mergeSortedArrays(in).mkString(", "))

}
