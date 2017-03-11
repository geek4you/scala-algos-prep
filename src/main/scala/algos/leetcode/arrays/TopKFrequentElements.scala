package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/10/17.
  */
/**
  * Using Bucket sort T(n) = O(n)
  *
  * Given a non-empty array of integers, return the k most frequent elements.
  * For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Hide Company Tags
  */
object TopKFrequentElements extends App {

  def topKFrequent(input: Array[Int], k: Int): util.List[Int] = {
    // create buckets
    val bucket = new Array[util.List[Int]](input.length + 1)

    // get the frequency of the elements
    val frequencyMap = new util.HashMap[Int, Int]()
    input.foreach(elem => {
      frequencyMap.put(elem, frequencyMap.getOrDefault(elem, 0) + 1)
    })

    frequencyMap
      .keySet()
      .forEach(key => {
        val frequency = frequencyMap.get(key)
        if (Option(bucket(frequency)).isEmpty) {
          bucket(frequency) = new util.ArrayList[Int]()
        }
        bucket(frequency).add(key)
      })

    val result = new util.ArrayList[Int]

    var pos = bucket.length - 1
    while (pos >= 0 && result.size() < k) {

      if (Option(bucket(pos)).isDefined) {
        result.addAll(bucket(pos))
      }
      pos -= 1
    }

    result
  }

  override def main(args: Array[String]): Unit = {
    val input = Array(1,1,1,2,2,3)
    val result = topKFrequent(input, 2)
    println(result.toString)
  }
}
