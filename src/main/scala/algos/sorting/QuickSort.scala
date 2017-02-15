package algos.sorting

/**
  * Created by geek4you on 2/15/17.
  */
/**
  * watch : https://www.youtube.com/watch?v=vK_q-C-kXhs
  * Divide and conquer
  * Divide: Partition the array into two sub-arrays around the pivot x.
  * elements in the lower sub-arry <= x < elements in the upper sub-arry
  * Conquer: Recursively sort the sub arrays
  * Combine: Trivial
  *
  * Key: Linear time partitioning. O(n)
  *
  * 1) choose any element as pivot
  * 2) partition the array into two partitions except the pivot.
  * 3) all elements less than pivot into first.
  * 4) all the elements greater than pivot into second.
  * 5) recursively sort the left and right partitions
  * 6) join the first partitions : pivot : second partition
  *
  * Time : O
  * Space : O(1) Inplace
  */
object QuickSort extends App {
  def sort(arry: Array[Int]): Unit = {
    randamizedQuickSort(arry, 0, arry.length - 1)
  }

  private def randamizedQuickSort(arry: Array[Int],
                                  left: Int,
                                  right: Int): Unit = {
    if (left < right) {
      val pivot = partition(arry, left, right)
      if (left < pivot - 1)
        randamizedQuickSort(arry, left, pivot - 1)
      if (right > pivot)
        randamizedQuickSort(arry, pivot, right)
    }
  }

  def partition(arry: Array[Int], left: Int, right: Int): Int = {
    val pivot = (right + left) / 2
    var i = left
    var j = right
    while (i < j) {
      while (arry(i) < arry(pivot)) {
        i += 1
      }
      while (arry(j) > arry(pivot)) {
        j -= 1
      }
      if (i <= j) {
        swap(arry, i, j)
        i += 1
        j -= 1
      }
    }
    i
  }

  private def swap[T](arr: Array[T], idx1: Int, idx2: Int): Array[T] = {
    val tmp = arr(idx1)
    arr(idx1) = arr(idx2)
    arr(idx2) = tmp
    arr
  }

  override def main(args: Array[String]): Unit = {
    val arry = Array[Int](20, 16, 3, 5, 1, 12, 2, 1)
    sort(arry)
    print(arry.mkString(" "))
  }

}
