package algos.epi.heaps

import java.util

import scala.collection.mutable

/**
  * Created by geek4you on 3/13/17.
  */
/**
  * Page 178
  */
object MergeKLists {

  def merge(arraysSorted: java.util.ArrayList[java.util.ArrayList[Int]])
    : java.util.List[Int] = {

    val iters = new util.ArrayList[util.Iterator[Int]](arraysSorted.size())
    for (i <- 0 until arraysSorted.size()) {
      iters.add(arraysSorted.get(i).iterator())
    }

    // min heap
    val minHeap = new mutable.PriorityQueue[ArrayEntry]()(
      Ordering.by[ArrayEntry, Int](_.value).reverse)

    // push one from each array
    for (i <- 0 until iters.size()) {
      if (iters.get(i).hasNext) {
        minHeap += ArrayEntry(iters.get(i).next(), i)
      }
    }

    val result = new util.ArrayList[Int]()
    while (minHeap.nonEmpty) {
      val headEntry = minHeap.dequeue()
      result.add(headEntry.value)
      if (iters.get(headEntry.arrayId).hasNext) {
        minHeap +=
          ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId)
      }
    }

    result
  }
}

case class ArrayEntry(value: Int, arrayId: Int)
