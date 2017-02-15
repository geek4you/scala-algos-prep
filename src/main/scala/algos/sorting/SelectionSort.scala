package algos.sorting

/**
  * Created by geek4you on 2/15/17.
  */
/**
  * Selection sort is a simple sorting algorithm. This sorting algorithm is an in-place comparison-based algorithm
  * in which the list is divided into two parts, the sorted part at the left end and the unsorted part at the right end.
  * Initially, the sorted part is empty and the unsorted part is the entire list.
  *
  * The smallest element is selected from the unsorted array and swapped with the leftmost element, and that element
  * becomes a part of the sorted array. This process continues moving unsorted array boundary by one element to the right.
  *
  * This algorithm is not suitable for large data sets as its average and worst case complexities are of Ο(n2),
  * where n is the number of items.
  *
  * Time = O(n2)
  * Space = O(1) Inplace sorting
  */
object SelectionSort extends App {

  def sort(arry: Array[Int]): Unit = {
    selectionSort(arry)
  }

  private def selectionSort(arry: Array[Int]): Unit = {
    for (index <- 0 to arry.length - 2) {
      val smallIndex = getSmallestElemIndex(arry, index + 1, arry.length - 1)
      if (arry(smallIndex) < arry(index)) {
        swap(arry, index, smallIndex)
      }
    }
  }

  private def getSmallestElemIndex(arry: Array[Int],
                                   start: Int,
                                   end: Int): Int = {
    if (start > end) {
      throw new RuntimeException("start index is greater than the end index")
    }
    var small = arry(start)
    var index = start
    for (i <- start + 1 to end) {
      if (small > arry(i)) {
        small = arry(i)
        index = i
      }
    }
    index
  }

  def swap[T](arr: Array[T], idx1: Int, idx2: Int): Unit = {
    val x = arr(idx1)
    arr(idx1) = arr(idx2)
    arr(idx2) = x
  }

  override def main(args: Array[String]): Unit = {
    val arry = Array[Int](20, 16, 3, 5, 1, 12, 2, 1)
    sort(arry)
    print(arry.mkString(" "))
  }

}
