package algos.epi.ninja

/**
  * Created by geek4you on 4/14/17.
  */
/**
  * Page 444
  * @see https://www.youtube.com/watch?v=oDhu5uGq_ic
  */
object BuyAndSellStockKTimes {

  /**
    * This is slow method but easier to understand.
    * Time complexity is O(k * number of days ^ 2)
    * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
    */
  def maxProfit(prices: Array[Int], k: Int): Double = {
    if (k == 0 || prices.isEmpty)
      0d
    else {
      // cache(i,j) represents the max profit you can get with i transactions in j days
      val cache = Array.ofDim[Int](k + 1, prices.length)
      for (i <- 1 until cache.length) {
        for (j <- 1 until cache(i).length) {
          var maxVal = 0
          for (m <- 0 until j) {
            maxVal = Math.max(prices(j) - prices(m) + cache(i - 1)(m), maxVal)
          }
          cache(i)(j) = Math.max(cache(i)(j - 1), maxVal)
        }
      }
      cache(k)(prices.length - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    var prices = Array(2, 5, 7, 1, 4, 3, 1, 3)
    println(maxProfit(prices, 3))
  }

}
