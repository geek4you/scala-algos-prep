package algos.epi.ninja

import java.util

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 469
  */
object KthLargestElementLargeNSmallK {

  def findKthLargestUnknownLength(sequence: Iterator[Int], k: Int): Int = {
    val candidates = new util.ArrayList[Int](2 * k - 1)
    while (sequence.hasNext) {
      candidates.add(sequence.next())
      if (candidates.size() == 2 * k - 1) {
        // Reorders the elements about median with the largest elements appearing before the median
        // code ->  KthLargestElement.kthLargest(candidates,k)
        // Resize tp keep just the K largest elements seen so far
        candidates.subList(k, candidates.size()).clear()
      }
    }
    // Finds the kth largest elements in the candidates
    // code ->  KthLargestElement.kthLargest(candidates,k)
    candidates.get(k - 1)
  }
}
