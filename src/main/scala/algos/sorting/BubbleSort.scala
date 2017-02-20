package algos.sorting

/**
  * Created by geek4you on 2/15/17.
  */
/**
  * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
  *
  * http://quiz.geeksforgeeks.org/bubble-sort/
  *
  * With Optimization Bubble Sort:
  * Time: Best O(n), Avg O(n2) , worst O(n2)
  * Space: O(1)
  *
  */
object BubbleSort extends App {

  def sort(arr: Array[Int]): Unit = {
    var swapped = true
    for (i <- arr.indices if swapped) {
      swapped = false
      for (j <- 1 until arr.length - i) {
        if (arr(j - 1) > arr(j)) {
          swap(arr, j, j - 1)
          swapped = true
        }
      }
      println(s"Iteration ${i + 1} : ${arr.mkString(" ")}")
    }
  }

  def swap[T: Numeric](arr: Array[T], indx1: Int, indx2: Int): Unit = {
    val tmp = arr(indx1)
    arr(indx1) = arr(indx2)
    arr(indx2) = tmp
  }

  override def main(args: Array[String]): Unit = {
    val arry = Array[Int](20, 16, 3, 5, 1, 12, 2, 1)
    sort(arry)
    print(arry.mkString(" "))
  }

}
