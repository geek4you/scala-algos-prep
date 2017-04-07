package algos.epi.dp

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/6/17.
  */
/**
  * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
  * with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same
  * color.
  * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0]
  * is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
  * Find the minimum cost to paint all houses.
  * Note:
  * All costs are positive integers.
  * Follow up:
  * Could you solve it in O(nk) runtime?
  */
object PaintHouses {

  /**
    * The idea is similar to the problem Paint House I, for each house and each color, the minimum cost of painting the
    * house with that color should be the minimum cost of painting previous houses, and make sure the previous house
    * doesn't paint with the same color.
    * <p>
    * We can use min1 and min2 to track the indices of the 1st and 2nd smallest cost till previous house, if the current
    * color's index is same as min1, then we have to go with min2, otherwise we can safely go with min1.
    * <p>
    * The code below modifies the value of costs[][] so we don't need extra space.
    *
    * @param costs costs grid
    * @return
    */
  def minCosts(costs: ArrayBuffer[ArrayBuffer[Int]]): Int = {
    if (costs.isEmpty)
      return 0

    // min1 is the index of the 1st-smallest cost till previous house
    // min2 is the index of the 2nd-smallest cost till previous house
    var (min1, min2) = (-1, -1)

    for (i <- costs.indices) {
      var (lastMin1, lastMin2) = (min1, min2)
      min1 = -1
      min2 = -1
      for (j <- costs(i).indices) {
        if (j != lastMin1) {
          // current color j is different to last min1
          costs(i)(j) += (if (lastMin1 < 0) 0 else costs(i - 1)(lastMin1))
        } else {
          costs(i)(j) += (if (lastMin2 < 0) 0 else costs(i - 1)(lastMin2))
        }

        // find the indices of 1st and 2nd smallest cost of painting current house i
        if (min1 < 0 || costs(i)(j) < costs(i)(min1)) {
          min2 = min1
          min1 = j
        } else if (min2 < 0 || costs(i)(j) < costs(i)(min2)) {
          min2 = j
        }
      }
    }

    costs(costs.length - 1)(min1)
  }

  def main(args: Array[String]): Unit = {
    val costs = ArrayBuffer[ArrayBuffer[Int]]()
    val firstHouseCosts = ArrayBuffer[Int]()
    firstHouseCosts ++= Array(2, 3, 2, 4)
    val secondHouseCosts = ArrayBuffer[Int]()
    secondHouseCosts ++= Array(2, 1, 4, 1)
    val thirdHouseCosts = ArrayBuffer[Int]()
    thirdHouseCosts ++= Array(3, 2, 2, 1)
    costs += firstHouseCosts
    costs += secondHouseCosts
    costs += thirdHouseCosts
    println(minCosts(costs))

  }
}
