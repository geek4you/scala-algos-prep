package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/5/17.
  */
/**
  * Page : 70
  */
object MaxProfitBuyAndSellStockOnce {

  def maxProfit(prices: util.ArrayList[Double]): Double = {
    var minSeenSoFar = prices.get(0)
    var maxProfit: Double = 0
    for (i <- 1 until prices.size()) {
      maxProfit = Math.max(maxProfit, prices.get(i) - minSeenSoFar)
      minSeenSoFar = Math.min(minSeenSoFar, prices.get(i))
    }
    maxProfit
  }

  def main(args: Array[String]): Unit = {
    val prices = new util.ArrayList[Double]()
    prices.add(310)
    prices.add(315)
    prices.add(275)
    prices.add(295)
    prices.add(260)
    prices.add(270)
    prices.add(290)
    prices.add(230)
    prices.add(255)
    prices.add(250)

    print(maxProfit(prices))
  }
}
