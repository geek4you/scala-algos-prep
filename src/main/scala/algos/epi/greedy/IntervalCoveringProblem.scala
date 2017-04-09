package algos.epi.greedy

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geeks4you on 4/7/17.
  */
/**
  * Page 341
  */
object IntervalCoveringProblem {

  def findMinimumVisits(intervals: Array[Interval]): Seq[Int] = {
    if (intervals.isEmpty)
      return Array[Int]()
    val intervalsSortedByEndTime = intervals.sortBy(interval => interval.end)
    var lastVisitTime = intervalsSortedByEndTime(0).end
    val result = new ArrayBuffer[Int]()
    result += lastVisitTime
    for (i <- 1 until intervals.length) {
      if (!(lastVisitTime >= intervals(i).start && lastVisitTime <= intervals(
            i).end)) {
        lastVisitTime = intervals(i).end
        result += lastVisitTime
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val intervals =
      Array(Interval(0, 3), Interval(2, 6), Interval(3, 4), Interval(6, 9))
    findMinimumVisits(intervals)
    println(findMinimumVisits(intervals).mkString(" "))
  }

  case class Interval(start: Int, end: Int)
}
