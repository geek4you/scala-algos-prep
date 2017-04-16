package algos.epi.ninja

import scala.collection.mutable

/**
  * Created by geek4you on 4/16/17.
  */
/**
  * Page 495
  */
object MeasureDefectiveJugs {

  def checkFeasible(jugs: Array[Jug], low: Int, high: Int): Boolean = {
    val cache = new mutable.HashSet[VolumeRange]()
    checkFeasibleHelper(jugs, low, high, cache)
  }

  def checkFeasibleHelper(jugs: Array[Jug],
                          low: Int,
                          high: Int,
                          cache: mutable.HashSet[VolumeRange]): Boolean = {
    if (low > high || cache.contains((VolumeRange(low, high))) || (low < 0 && high < 0))
      return false

    // checks volume for each jug to see if possible
    jugs.foreach(jug => {
      if ((low <= jug.low && jug.high >= high) // base case: jug is contained in [low,high]
          || checkFeasibleHelper(jugs, low - jug.low, high - jug.high, cache))
        return true
    })

    cache += VolumeRange(low, high) // marks this impossible
    false
  }

  case class Jug(low: Int, high: Int)
  case class VolumeRange(low: Int, high: Int)

  def main(args: Array[String]): Unit = {
    val jugs = Array(Jug(230, 240), Jug(290, 310), Jug(500, 515))
    println(checkFeasible(jugs, 2100, 2300))
  }
}
