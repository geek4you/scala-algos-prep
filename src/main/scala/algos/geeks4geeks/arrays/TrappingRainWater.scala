package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/20/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/trapping-rain-water/]]
  */
object TrappingRainWater {

  def maxTrap(input: Array[Int]): Int = {
    // left[i] contains height of tallest bar to the
    // left of i'th bar including itself
    val left = new Array[Int](input.length)

    // Right [i] contains height of tallest bar to
    // the right of ith bar including itself
    val right = new Array[Int](input.length)

    // result
    var water = 0

    // Fill left array
    left(0) = input(0)
    for (i <- 1 until input.length) {
      left(i) = Math.max(left(i - 1), input(i))
    }

    // fill the right array
    right(right.length - 1) = input(input.length - 1)
    for (i <- right.length - 2 to 0 by -1) {
      right(i) = Math.max(right(i + 1), input(i))
    }

    // Calculate the accumulated water element by element
    // consider the amount of water on i'th bar, the
    // amount of water accumulated on this particular
    // bar will be equal to min(left[i], right[i]) - arr[i] .
    for (i <- input.indices) {
      water += Math.min(left(i), right(i)) - input(i)
    }

    water
  }

  def main(args: Array[String]): Unit = {
    val input = Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(maxTrap(input))
  }
}
