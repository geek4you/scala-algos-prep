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
 */
object InsertionSort {

  def insertionSort[A](la: List[A])(implicit ord: Ordering[A]): List[A] = {
    def insert(la: List[A], a: A) = {
      val (h, t) = la.span(ord.lt(_, a))
      h ::: (a :: t)
    }

    la.foldLeft(List[A]()) {(acc, a) => insert(acc, a)}
  }

}
