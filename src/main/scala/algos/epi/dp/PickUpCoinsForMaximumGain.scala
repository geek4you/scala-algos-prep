package algos.epi.dp

/**
  * Created by geek4you on 4/6/17.
  */
object PickUpCoinsForMaximumGain {

  def pickUpCoins(coins: Array[Int]): Int = {
    computeMaximumRevenueForRange(coins,
                                  0,
                                  coins.length - 1,
                                  Array.ofDim[Int](coins.length, coins.length))
  }

  def computeMaximumRevenueForRange(
      coins: Array[Int],
      a: Int,
      b: Int,
      maxRevenueForRange: Array[Array[Int]]): Int = {
    if (a > b)
      // no coins left
      return 0

    if (maxRevenueForRange(a)(b) == 0) {
      val maxRevenueA = coins(a) + Math.min(
        computeMaximumRevenueForRange(coins, a + 2, b, maxRevenueForRange),
        computeMaximumRevenueForRange(coins, a + 1, b - 1, maxRevenueForRange))

      val maxRevenueB = coins(b) + Math.min(
        computeMaximumRevenueForRange(coins, a, b - 2, maxRevenueForRange),
        computeMaximumRevenueForRange(coins, a + 1, b - 1, maxRevenueForRange))

      maxRevenueForRange(a)(b) = Math.max(maxRevenueA, maxRevenueB)
    }

    maxRevenueForRange(a)(b)
  }

  def main(args: Array[String]): Unit = {
    val coins = Array(5,25,10,1)
    println(pickUpCoins(coins))
  }
}
