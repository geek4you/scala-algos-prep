package algos.epi.greedy

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Page 353
  */
object LargestRectangleUnderASkyline {

  def calculateLargestRectangle(heights: Array[Int]): Int = {
    val pillarIndices = new ListBuffer[Int]()
    var maxRectArea = 0

    for (i <- 0 to heights.length) {
      if (pillarIndices.nonEmpty && i < heights.size && heights(i) == heights(
            pillarIndices.head)) {
        // replace earlier building with same height by current building. This ensures the later
        // buildings have the correct left endpoint
        pillarIndices -= pillarIndices.head
        pillarIndices.prepend(i)
      }

      // By iterating to the heights.size() instead of heights.size()-1, we can uniformly
      // handle the computation for rectangle area here.
      while (pillarIndices.nonEmpty && isNewPillarOrReachEnd(
               heights,
               i,
               pillarIndices.head)) {
        val height = heights(pillarIndices.head)
        pillarIndices -= pillarIndices.head
        val width =
          if (pillarIndices.isEmpty) i else i - pillarIndices.head - 1
        maxRectArea = Math.max(maxRectArea, height * width)
      }
      pillarIndices.prepend(i)
    }

    maxRectArea
  }

  def main(args: Array[String]): Unit = {
    val hist = Array(6, 2, 5, 4, 5, 1, 6)
    println(calculateLargestRectangle(hist))
  }

  def isNewPillarOrReachEnd(heights: Array[Int],
                            currIdx: Int,
                            lastPillarIdx: Int): Boolean = {
    if (currIdx < heights.length)
      heights(currIdx) < heights(lastPillarIdx)
    else true
  }
}
