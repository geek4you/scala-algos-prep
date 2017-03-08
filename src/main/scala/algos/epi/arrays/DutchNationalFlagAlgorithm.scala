package algos.epi.arrays

import java.util
import java.util.Collections

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
                                 arr: util.ArrayList[Color]): Unit = {
    val pivot = arr.get(pivotIndex)

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
      if (arr.get(equal).id < pivot.id) {
        Collections.swap(arr, smaller, equal)
        smaller += 1
        equal += 1
      } else if (arr.get(equal) == pivot) {
        equal += 1
      } else {
        // arr.get(equal) > pivot
        Collections.swap(arr, equal, larger)
        larger -= 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = new util.ArrayList[Color]()
    arr.add(Red)
    arr.add(White)
    arr.add(White)
    arr.add(Red)
    arr.add(White)
    arr.add(Blue)
    arr.add(White)
    arr.add(Blue)
    arr.add(Red)
    arr.add(Red)
    arr.add(White)
    dutchNationalFlagPartition(1, arr)
    arr.forEach(x => println(x))
  }
}
