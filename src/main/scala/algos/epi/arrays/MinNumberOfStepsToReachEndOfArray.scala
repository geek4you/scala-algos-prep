package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/4/17.
  */
/**
  * Page 68
  *
  * DP solution is provided here.
  *
  * Also we can solve using Graph Theory
  * Graph Theory : This problem may also be modeled as a graph theoretic problem. Let the positions (array indices) in the input array be vertices. We add an edge between 2 vertices i and j if A[ j ] is reachable from A[ i ]. For example, if A[ 0 ] = 3, then the vertex 0 will have edges connecting it to vertices 1, 2 and 3. Once, the graph is constructed, the problem reduces to finding the length of the shortest path from the source (first vertex) to the destination (last vertex).
  */
object MinNumberOfStepsToReachEndOfArray {
  def minSteps(arr: util.ArrayList[Int]): Int = {
    // We maintain an array dp[ ] where dp[ i ] stores the minimum number of steps required to
    // reach index i from the start.
    // The recurrence relation would look like this: DP[ i ] = min{ DP[ j ] + 1 }
    // where j ranges from 0 to (i-1) and satisfies the condition that A[ j ] >= (i - j).
    //The condition ensures the validity of our jumps from j to i and we are taking the most optimum (minimum) among the choices available to us for reaching index i from index j.

    val dp = new Array[Int](arr.size)
    dp(0) = 0
    for (i <- 1 until arr.size()) {
      dp(i) = Int.MaxValue
      for (j <- 1 to i) {
        if (arr.get(i - j) >= j) {
          dp(i) = Math.min(dp(i), dp(i - j) + 1)
        }
      }
    }
    dp(dp.length - 1)
  }

  // linear solution
  /**
    *  @see [[https://www.youtube.com/watch?v=vBdo7wtwlXs]]
    */
  def minLinearSol(arr: util.ArrayList[Int]): Int = {
    if (arr.size() <= 1) {
      0
    } else {
      var ladder: Int = arr.get(0) // keep track of largest ladder that you have.
      var stairs: Int = arr.get(0) // keep track of stairs in the current ladder.
      var jumps = 1
      for (level <- 1 until arr.size()) {
        if (level == arr.size() - 1)
          return jumps
        if (arr.get(level) + level > ladder) { // check if the bigger ladder is at this index
          ladder = arr.get(level) + level
        }
        stairs -= 1 // use up the stairs.
        if (stairs == 0) {
          jumps += 1 // no stairs left. now jump.
          stairs = ladder - level // new set of stairs.
        }
      }
      jumps
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = new util.ArrayList[Int]()
    arr.add(3)
    arr.add(3)
    arr.add(1)
    arr.add(0)
    arr.add(2)
    arr.add(0)
    arr.add(1)
    println(minLinearSol(arr))
  }
}
