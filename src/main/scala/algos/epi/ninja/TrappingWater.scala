package algos.epi.ninja

/**
  * Created by geek4you on 4/16/17.
  */
/**
  * Page 508
  * @see https://www.youtube.com/watch?v=KV-Eq3wYjxI
  */
object TrappingWater {

  def maxWaterTrapped(input: Array[Int]): Int = {

    // get max on left
    val maxOnLeft = new Array[Int](input.length)
    maxOnLeft(0) = input(0)
    for (i <- 1 until input.length) {
      maxOnLeft(i) = Math.max(maxOnLeft(i - 1), input(i))
    }

    // get max on right
    val maxOnRight = new Array[Int](input.length)
    maxOnRight(maxOnRight.length - 1) = input(input.length - 1)
    for (i <- maxOnRight.length - 2 to 0 by -1) {
      maxOnRight(i) = Math.max(maxOnRight(i + 1), input(i))
    }

    // get water on top of each building and add to result
    var result = 0
    for (i <- input.indices) {
      val waterOnThisBuilding = Math.min(maxOnLeft(i), maxOnRight(i)) - input(
        i)
      result += waterOnThisBuilding
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val input = Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(maxWaterTrapped(input))
  }

}
