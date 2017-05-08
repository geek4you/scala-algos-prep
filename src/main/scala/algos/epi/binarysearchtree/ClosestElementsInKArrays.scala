package algos.epi.binarysearchtree

import scala.collection.mutable

/**
  * Created by geek4you on 5/7/17.
  */
/**
  * Page 269
  */
object ClosestElementsInKArrays {

  def finaMinSortedArrays(sortedArrays: Array[Array[Int]]): Int = {
    // indices into each of the arrays
    val heads = Array.fill[Int](sortedArrays.length)(0)
    var result = Int.MaxValue

    var currentHeads = new mutable.TreeSet[ArrayData]()

    // add min element of each array to the currentHeads
    for (i <- sortedArrays.indices) {
      currentHeads += ArrayData(sortedArrays(i)(heads(i)), i)
    }

    while (true) {
      result =
        Math.min(result, currentHeads.last.value - currentHeads.firstKey.value)
      val idxNextMin = currentHeads.firstKey.idx
      // return if one of the elements has no remaining elements
      heads(idxNextMin) += 1
      if (heads(idxNextMin) >= sortedArrays(idxNextMin).length) {
        return result
      }
      currentHeads.remove(currentHeads.firstKey)
      currentHeads += ArrayData(sortedArrays(idxNextMin)(heads(idxNextMin)),
                                idxNextMin)

    }

  }

  case class ArrayData(value: Int, idx: Int) extends Ordered[ArrayData] {
    override def compare(that: ArrayData): Int = {
      var result = this.value compare that.value
      if (result == 0)
        this.idx compare that.idx
      else result
    }
  }
}
