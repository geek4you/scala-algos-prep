package algos.sorting

/**
  * Created by geek4you on 2/15/17.
  */
/**
  * This is an in-place comparison-based sorting algorithm. Here, a sub-list is maintained which is always sorted.
  * For example, the lower part of an array is maintained to be sorted. An element which is to be 'insert'ed in this
  * sorted sub-list, has to find its appropriate place and then it has to be inserted there. Hence the name, insertion
  * sort.
  *
  * The array is searched sequentially and unsorted items are moved and inserted into the sorted
  * sub-list (in the same array).
  * This algorithm is not suitable for large data sets as its average and worst case complexity are of Ο(n2),
  * where n is the number of items.
  *
  * Time : O(n2)
  * Space: O(1) Inplace
  *
  * Insertion Sort
  * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
  * Algorithm
  // Sort an arr[] of size n
  insertionSort(arr, n)
  Loop from i = 1 to n-1.
  ……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
  */
object InsertionSort extends App {

  def sort(arr: Array[Int]): Unit = {
    iSort(arr)
  }

  def iSort(arr: Array[Int]): Unit = {
    for (i <- 1 until arr.length) {
      for (j <- 0 until i) {
        if (arr(j) > arr(i)) {
          insert(arr, j, i)
        }
      }
    }
  }

  def insert(arr: Array[Int], newPos: Int, oldPos: Int): Unit = {
    if (newPos < oldPos) {
      val tmp = arr(oldPos)
      for (i <- oldPos until newPos by -1) {
        arr(i) = arr(i - 1)
      }
      arr(newPos) = tmp
    }
  }

  /**
    * Scala way
    */
  def insertionSort[A](la: List[A])(implicit ord: Ordering[A]): List[A] = {
    def insert(la: List[A], a: A) = {
      val (h, t) = la.span(ord.lt(_, a))
      h ::: (a :: t)
    }

    la.foldLeft(List[A]()) { (acc, a) =>
      insert(acc, a)
    }
  }

  override def main(args: Array[String]): Unit = {
    val arr = Array[Int](12, 11, 13, 5, 6)
    iSort(arr)
    println(arr.mkString(" "))
  }

}
