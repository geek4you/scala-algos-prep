package algos.epi.heaps

import java.util
import java.util.Collections

/**
  * Created by geek4you on 3/13/17.
  */
object SortIncreasingDecreasingArray {

  def sort(input: java.util.List[Int]): java.util.List[Int] = {

    // decomposes the set into the set of sorted arrays
    val sortedSubArrays = new util.ArrayList[util.List[Int]]()

    var subArrayType = SubArrayType.Increasing
    var startIdx = 0

    for (i <- 1 to input.size()) {
      if (i == input.size() // array is ended. adds last subarray
          || (input.get(i - 1) < input.get(i) && subArrayType == SubArrayType.Decreasing)
          || (input.get(i - 1) >= input.get(i) && subArrayType == SubArrayType.Increasing)) {
        val subList = input.subList(startIdx, i)
        if (subArrayType == SubArrayType.Decreasing) {
          Collections.reverse(subList)
        }
        sortedSubArrays.add(subList)
        startIdx = i
        if (subArrayType == SubArrayType.Increasing)
          subArrayType = SubArrayType.Decreasing
        else
          subArrayType = SubArrayType.Increasing
      }
    }
    //todo: fix this line
    // MergeKLists.merge(sortedSubArrays)
    null
  }
}

object SubArrayType extends Enumeration {
  val Increasing, Decreasing = Value
}
