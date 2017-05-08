package algos.epi.binarysearchtree

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 5/7/17.
  */
object RangeLookupProblem {

  case class Interval(start: Int, end: Int)
  def rangeLookUp(root: Node[Int], interval: Interval): Seq[Int] = {
    val result = ArrayBuffer[Int]()
    rangeLookUpHelper(root, interval, result)
    result
  }

  def rangeLookUpHelper(root: Node[Int],
                        interval: Interval,
                        result: ArrayBuffer[Int]): Unit = {

    if (Option(root).isDefined) {
      if (Range(interval.start, interval.end).contains(root.data)) {
        // root.data lies in the interval
        rangeLookUpHelper(root.left, interval, result)
        result += root.data
        rangeLookUpHelper(root.right, interval, result)
      } else if (root.data < interval.start) {
        rangeLookUpHelper(root.right, interval, result)
      } else {
        rangeLookUpHelper(root.left, interval, result)
      }
    }
  }
}
