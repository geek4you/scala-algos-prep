package algos.epi.arrays

import scala.collection.mutable.ArrayBuffer

/**
  * Page 96
  * Created by geek4you on 3/4/17.
  */
sealed trait Color { def id: Int }
case object Red extends Color {
  override def id: Int = 0
}
case object White extends Color {
  override def id: Int = 1
}
case object Blue extends Color {
  override def id: Int = 2
}

/**
  * Remember Pivot index should always be the middle elem else when you have elements like
  * (<pivot) (==pivot) (>pivot)
  * the borders may contain elements which are not ordered. !!
  */
object DutchNationalFlagAlgorithm {

  def dutchNationalFlagPartition(pivotIndex: Int,
                                 arr: ArrayBuffer[Color]): Unit = {
    val pivot = arr(pivotIndex)

    /**
      * Keep the following invariants during partitioning:
      * bottom group: arr.subList(0,smaller)
      * middle group: arr.subList(smaller, equal)
      * unclassified group: arr.subList(equal, larger)
      * top group: arr.subList(larger, arr.size)
      */
    var (smaller, equal, larger) = (0, 0, arr.size - 1)

    // keep iterating as long as there is an unclassified elem
    while (equal <= larger) {
      // arr(equal) is the incoming unclassified element
      if (arr(equal).id < pivot.id) {
        swap(arr, smaller, equal)
        smaller += 1
        equal += 1
      } else if (arr(equal) == pivot) {
        equal += 1
      } else {
        // arr.get(equal) > pivot
        swap(arr, equal, larger)
        larger -= 1
      }
    }

  }

  def swap(arr: ArrayBuffer[Color], idx1: Int, idx2: Int): Unit = {
    val tmp = arr(idx1)
    arr(idx1) = arr(idx2)
    arr(idx2) = tmp
  }
  def main(args: Array[String]): Unit = {
    val arr = new ArrayBuffer[Color]()
    arr ++=
      Array(Blue,
            Red,
            White,
            White,
            Red,
            White,
            Blue,
            White,
            Blue,
            Red,
            Red,
            White)
    dutchNationalFlagPartition(2, arr)
    println(arr.mkString(", "))
  }
}
