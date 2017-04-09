package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Page 351
  */
object MaxTrappedRainWater {

  def getMaxTrappedWater(heights: Array[Int]): Int = {
    var (i, j) = (0, heights.length - 1)
    var maxWater = 0

    while (i < j) {
      val width = j - i
      maxWater = Math.max(width * Math.min(heights(i), heights(j)), maxWater)
      if (heights(i) < heights(j)) {
        i += 1
      } else if (heights(i) > heights(j)) {
        j -= 1
      } else {
        i += 1
        j -= 1
      }
    }
    maxWater
  }

  def main(args: Array[String]): Unit = {
    val heights = Array(1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1)
    println(getMaxTrappedWater(heights))
  }

}
