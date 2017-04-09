package algos.epi.greedy

import scala.collection.mutable

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Let there be n ropes of lengths stored in an array len[0..n-1]
1) Create a min heap and insert all lengths into the min heap.
2) Do following while number of elements in min heap is not one.
……a) Extract the minimum and second minimum from min heap
……b) Add the above two extracted values and insert the added value to the min-heap.
3) Return the value of only left item in min heap.
  @see http://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
  */
object ConnectRopes {

  def minCostToConnectRopes(ropes: Array[Int]): Int = {
    if (ropes.length == 0)
      0
    else {
      var cost = 0
      val minHeap = new mutable.PriorityQueue[Int]()(MinOrder)
      // add all the rope lengths into the min heap
      ropes.foreach(rope => minHeap += rope)

      while (minHeap.size != 1) {
        val head1 = minHeap.dequeue()
        val head2 = minHeap.dequeue()
        cost += head1 + head2
        minHeap += head1 + head2
      }
      cost
    }
  }

  def main(args: Array[String]): Unit = {
    val ropes = Array(4, 3, 2, 6)
    println(minCostToConnectRopes(ropes))
  }

  object MinOrder extends Ordering[Int] {
    def compare(x: Int, y: Int) = y compare x
  }
}
