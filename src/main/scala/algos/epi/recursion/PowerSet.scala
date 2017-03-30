package algos.epi.recursion

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/29/17.
  */
/**
  * Page 294
  */
object PowerSet {

  def generatePowerSet(inputSet: ArrayBuffer[Int]): Seq[Seq[Int]] = {
    val powerSet = ArrayBuffer[ArrayBuffer[Int]]()
    directedPowerSet(inputSet, 0, new ArrayBuffer[Int](), powerSet)
    powerSet
  }

  def directedPowerSet(inputSet: ArrayBuffer[Int],
                       toBeSelected: Int,
                       selectedSoFar: ArrayBuffer[Int],
                       powerSet: ArrayBuffer[ArrayBuffer[Int]]): Unit = {
    if (toBeSelected == inputSet.size)
      powerSet += selectedSoFar.clone()
    else {
      // generate all subsets that contain input(toBeSelected)
      selectedSoFar += inputSet(toBeSelected)
      directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet)
      // generate all subsets that does not contain input(toBeSelected)
      selectedSoFar.remove(selectedSoFar.size - 1)
      directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet)
    }
  }

  def main(args: Array[String]): Unit = {
    val input = ArrayBuffer(1, 2, 3)
    val result = generatePowerSet(input)
    println(result.mkString("\n"))
  }
}
