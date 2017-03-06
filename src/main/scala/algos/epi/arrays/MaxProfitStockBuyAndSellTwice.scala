package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/5/17.
  * Page 71
  * [[http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/]]
  *
  * Funda: max profit = max profit in (0 to i)  + max profit in (i to arr.length-1)
  * (0 to i) is first sell
  * (i to arr.length -1) is second sell
  */

// fixme: bug
object MaxProfitStockBuyAndSellTwice {
  // Returns maximum profit with two transactions on a given
  // list of stock prices, price[0..n-1]
  def maxProfit(price: util.ArrayList[Int]): Int = {
    // profits array
    val profits =
      new util.ArrayList[Int](util.Collections.nCopies(price.size(), 0))

    // forward
    var minPriceSoFar = Int.MaxValue
    var maxTotalProfit = 0

    // populates the profits[i] with max profit that can be made from 0 to i
    for (i <- 0 until price.size()) {
      minPriceSoFar = Math.min(minPriceSoFar, price.get(i))

      maxTotalProfit = Math.max(maxTotalProfit, price.get(i) - minPriceSoFar)
      profits.set(i, maxTotalProfit)
    }

    // backward
    var maxSoFar = Int.MinValue
    // cal the max profit from price.len to i and adds it to profits(i)
    for (i <- price.size() - 1 until 0) {
      maxSoFar = Math.max(maxSoFar, price.get(i))
      maxTotalProfit =
        Math.max(maxTotalProfit, maxSoFar - price.get(i) + profits.get(i - 1))
    }

    maxTotalProfit
  }

  def main(args: Array[String]): Unit = {
    val price = new util.ArrayList[Int]()
    price.add(2)
    price.add(30)
    price.add(15)
    price.add(10)
    price.add(8)
    price.add(25)
    price.add(80)
    print(maxProfit(price))
  }
}
