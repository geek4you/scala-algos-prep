package algos.programmingpearls

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * The solution goes as follows:

Let prefix[i] be the cumulative sum up to i, like in the example above. Then, we need to compute the best subarray ending at ii. This means we need to find an index j<ij<i such that the sum is as close as possible to tt. This means that this value needs to be as close as possible to prefix[i] - t, since  prefix[i] - prefix[j] is the sum of the subsequence between [j,i]. So, for every prefix, we must find another earlier prefix that’s as close in value to prefix[i] - t. We can use a Java TreeSet for this which supports O(log(n))O(log⁡(n)) insertion, lower bound, and upper bound operations.
 [[https://rafal.io/posts/subsequence-closest-to-t.html]]
 This algorithm is Question 10 Column 8 in Programming Pearls by Jon Bentley
  */
object SubArrayWithSumClosestToNumberT extends App {

  def closestToT(arr: Array[Double], t: Double): Double = {
    var prefix = 0
    val set = new java.util.TreeSet[Double]()
    set.add(0)
    var leastDiff = Double.MaxValue

    for (i <- arr.indices) {
      prefix += i; // the cumulative sum up to i
      val rest = prefix - t; // how far away we are from t
      if (set.first <= rest) {
        var theSum = prefix - set.floor(rest)
        leastDiff = Math.min(leastDiff, Math.abs(theSum - t))
      }
      if (set.last() >= rest) {
        var theSum = prefix - set.ceiling(rest)
        leastDiff = Math.min(leastDiff, Math.abs(theSum - t))
      }
      set.add(prefix)
    }
    leastDiff
  }

  override def main(args: Array[String]): Unit = {}
}
