package algos.epi.ninja

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 492
  */
object DrawSkyline {

  def drawSkyLines(buildings: Array[Building]): Array[Building] = {
    var minLeft = Int.MaxValue
    var maxRight = Int.MinValue
    buildings.foreach(b => {
      minLeft = Math.min(b.left, minLeft)
      maxRight = Math.max(b.right, maxRight)
    })

    val heights = Array.fill(maxRight - minLeft + 1)(0)
    buildings.foreach(building => {
      for (i <- building.left to building.right) {
        heights(i - minLeft) = Math.max(heights(i - minLeft), building.height)
      }
    })

    val result = new ArrayBuffer[Building]()
    var left = 0
    for (i <- 1 until heights.length) {
      if (heights(i) != heights(i - 1)) {
        result += Building(left + minLeft, i - 1 + minLeft, heights(i - 1))
        left = i
      }
    }

    result += Building(left + minLeft, maxRight, heights(heights.size - 1))
    result.toArray
  }

  def main(args: Array[String]): Unit = {
    val input = Array(Building(1, 3, 4),
                      Building(3, 4, 4),
                      Building(2, 6, 2),
                      Building(8, 11, 4),
                      Building(7, 9, 3),
                      Building(10, 11, 12))
    println(drawSkyLines(input).mkString(" "))
  }

  case class Building(left: Int, right: Int, height: Int)

}
