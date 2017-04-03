package algos.epi.arrays

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/5/17.
  * Page 71
  * [[http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/]]
  *
  * Funda: max profit = max profit in (0 to i)  + max profit in (i to arr.length-1)
  * (0 to i) is first sell
  * (i to arr.length -1) is second sell
  */
object MaxProfitStockBuyAndSellTwice {
  // Returns maximum profit with two transactions on a given
  // list of stock prices, price[0..n-1]
  def maxProfit(price: ArrayBuffer[Int]): Int = {
    // profits array
    val profits =
      new ArrayBuffer[Int]()

    // forward
    var minPriceSoFar = Int.MaxValue
    var maxTotalProfit = 0

    // populates the profits[i] with max profit that can be made from 0 to i
    for (i <- price.indices) {
      minPriceSoFar = Math.min(minPriceSoFar, price(i))

      maxTotalProfit = Math.max(maxTotalProfit, price(i) - minPriceSoFar)
      profits += maxTotalProfit
    }

    // backward
    var maxSoFar = Int.MinValue
    // cal the max profit from price.len to i and adds it to profits(i)
    for (i <- price.length - 1 until 0 by -1) {
      maxSoFar = Math.max(maxSoFar, price(i))
      maxTotalProfit =
        Math.max(maxTotalProfit, maxSoFar - price(i) + profits(i - 1))
    }

    maxTotalProfit
  }

  def main(args: Array[String]): Unit = {
    val price = new ArrayBuffer[Int]()
    price ++= Array(2, 30, 15, 10, 8, 25, 80)
    print(maxProfit(price))
  }
}
