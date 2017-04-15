package algos.epi.heaps

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/13/17.
  */
/**
  * Page 178
  */
object MergeKLists {

  def merge(arraysSorted: ArrayBuffer[ArrayBuffer[Int]]): Seq[Int] = {

    val iters = new ArrayBuffer[Iterator[Int]]()
    for (i <- arraysSorted.indices) {
      iters += arraysSorted(i).iterator
    }

    // min heap
    val minHeap = new mutable.PriorityQueue[ArrayEntry]()(
      Ordering.by[ArrayEntry, Int](_.value).reverse)

    // push one from each array
    for (i <- 0 until iters.size) {
      if (iters(i).hasNext) {
        minHeap += ArrayEntry(iters(i).next(), i)
      }
    }

    val result = new ArrayBuffer[Int]()
    while (minHeap.nonEmpty) {
      val headEntry = minHeap.dequeue()
      result += (headEntry.value)
      if (iters(headEntry.arrayId).hasNext) {
        minHeap +=
          ArrayEntry(iters(headEntry.arrayId).next(), headEntry.arrayId)
      }
    }

    result
  }
}

case class ArrayEntry(value: Int, arrayId: Int)
