package algos.epi.recursion

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * Created by geek4you on 3/28/17.
  */
/**
  * Page 288
  * [[https://www.youtube.com/watch?v=q6RicK1FCUs]]
  */
object TowersOfHanoi {

  val numPegs = 3
  def computeTowerHanoi(numRings: Int): Unit = {
    val pegs = new ArrayBuffer[ListBuffer[Int]]()
    for (i <- 0 until numPegs) {
      pegs += new ListBuffer[Int]()
    }
    // initialize pegs
    for (i <- numRings to 1 by -1) {
      pegs(0).prepend(i)
    }
    computeTowerHanoiSteps(numRings, pegs, 0, 1, 2)
  }

  def computeTowerHanoiSteps(numRingsToMove: Int,
                             pegs: ArrayBuffer[ListBuffer[Int]],
                             fromPeg: Int,
                             toPeg: Int,
                             usePeg: Int): Unit = {
    if (numRingsToMove > 0) {
      computeTowerHanoiSteps(numRingsToMove - 1, pegs, fromPeg, usePeg, toPeg)
      pegs(toPeg).prepend(pegs(fromPeg).head)
      pegs(fromPeg) -= pegs(fromPeg).head
      println(s"Move from peg $fromPeg to $toPeg")
      computeTowerHanoiSteps(numRingsToMove - 1, pegs, usePeg, toPeg, fromPeg)
    }
  }

  def main(args: Array[String]): Unit = {
    computeTowerHanoi(6)
  }
}
