package algos.epi.arrays

/**
  * Created by geek4you on 3/18/17.
  */
object MaxSumArrayInMatrix {

  def kadaneSum(arr: Array[Int]): KadaneResult = {
    var maxSumSoFar = 0
    var maxSumEndingHere = 0
    var currentStart = 0
    var maxStart = 0
    var maxEnd = 0
    for (i <- arr.indices) {
      if (maxSumEndingHere + arr(i) < 0) {
        currentStart = i + 1
      }
      maxSumEndingHere = Math.max(maxSumEndingHere + arr(i), 0)
      if (maxSumSoFar < maxSumEndingHere) {
        maxStart = currentStart
        maxEnd = i
      }
      maxSumSoFar = Math.max(maxSumEndingHere, maxSumSoFar)
    }
    KadaneResult(maxSumSoFar, maxStart, maxStart)
  }

  /**
    * This algorithm only works if there is at least one positive element in the 2D Array
    */
  def maxIn2DArray(arr: Array[Array[Int]]): Result = {
    val result = Result(Integer.MIN_VALUE, 0, 0, 0, 0)
    val temp = new Array[Int](arr.length) // length of the array is same as number of rows
    for (left <- arr(0).indices) {
      // reset the temp arr
      for (i <- temp.indices) { temp(i) = 0 }

      // move right from left till end
      for (right <- left until arr(0).length) {
        // add the column number right to the temp array
        for (i <- arr.indices) {
          temp(i) += arr(i)(right)
        }
        // get the max indexes
        val tempResult = kadaneSum(temp)
        if (tempResult.maxSum > result.maxSum) {
          result.maxSum = tempResult.maxSum
          result.leftBound = left
          result.rightBound = right
          result.upBound = tempResult.start
          result.lowBound = tempResult.end
        }
      }
    }
    println(result)
    result
  }

  def main(args: Array[String]): Unit = {
    val input = Array(Array(2, 1, -3, -4, 5),
                      Array(0, 6, 3, 4, 1),
                      Array(2, -2, -1, 4, -5),
                      Array(-3, 3, 1, 0, 3))
    maxIn2DArray(input)

  }
}

case class Result(var maxSum: Int,
                  var leftBound: Int,
                  var rightBound: Int,
                  var upBound: Int,
                  var lowBound: Int)

case class KadaneResult(maxSum: Int, start: Int, end: Int)
