package algos.epi.dp

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
    // v[i][j] holds the optimum value when we choose from items[0..i] and have a capacity of j
    // fill with -1
    val v = Array.tabulate(items.length, capacity + 1)((i, j) => -1)

    optimumSubjectToItemAndCapacity(items, items.length - 1, capacity, v)
  }

  def optimumSubjectToItemAndCapacity(items: Array[Item],
                                      k: Int,
                                      availableCapacity: Int,
                                      v: Array[Array[Int]]): Int = {

    if (k < 0) // no items to choose
      0

    if (v(k)(availableCapacity) == -1) {
      val withoutCurrentItem =
        optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity, v)
      val withCurrentItem =
        if (availableCapacity < items(k).weight) 0
        else
          items(k).weight + optimumSubjectToItemAndCapacity(
            items,
            k - 1,
            availableCapacity - items(k).weight,
            v)

      v(k)(availableCapacity) = Math.max(withCurrentItem, withoutCurrentItem)
    }

    v(k)(availableCapacity)
  }
  case class Item(weight: Int, value: Int)
}
