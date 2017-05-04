package algos.epi.dp

import scala.collection.mutable

/**
  * Created by geek4you on 4/5/17.
  */
/**
  * Page : 322
  * @see [[http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/]]
  * @see https://www.youtube.com/watch?v=8LusJS5-AGo
  *
  * If not 0/1 sort by value and use greedy. Sort by value/weight value and pick items as they fit. If last time doesn't fit take the ratio.
  * The non 0/1 knapsack is on Page 324 in invariants
  */
object Knapsack0or1Problem {

  def optimumSubjectToCapacity(items: Array[Item], capacity: Int): Int = {
    // cache[i][j] holds the optimum value when we choose from items[0..i] and have a capacity of j
    // fill with -1
    val cache = new mutable.HashMap[(Int, Int), Int]()

    optimumSubjectToItemAndCapacity(items, 0, capacity, cache)
  }

  def optimumSubjectToItemAndCapacity(
      items: Array[Item],
      offset: Int,
      availableCapacity: Int,
      cache: mutable.Map[(Int, Int), Int]): Int = {

    if (offset == items.length) // no items to choose
      return 0

    if (!cache.contains(offset, availableCapacity)) {
      val withoutCurrentItem =
        optimumSubjectToItemAndCapacity(items,
                                        offset + 1,
                                        availableCapacity,
                                        cache)
      val withCurrentItem =
        if (availableCapacity < items(offset).weight) 0
        else
          items(offset).value + optimumSubjectToItemAndCapacity(
            items,
            offset + 1,
            availableCapacity - items(offset).weight,
            cache)

      cache((offset, availableCapacity)) =
        Math.max(withCurrentItem, withoutCurrentItem)
    }

    cache((offset, availableCapacity))
  }
  case class Item(weight: Int, value: Int)

  def main(args: Array[String]): Unit = {
    val items = Array[Item](Item(5, 60), Item(3, 50), Item(4, 70), Item(2, 30))
    val capacity = 5
    println(optimumSubjectToCapacity(items, capacity))
  }
}
