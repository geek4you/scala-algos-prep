package algos.arrays

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * This is extension to this.
  * [[algos.programmingpearls.MaxSumContiguousSubArray]]
  */
object ContiguousSubArrayWithMaxSum extends App {

  def maxSumContiguousArray(arr: Array[Int]): (Int, Int) = {
    var maxSoFar = 0
    var maxSumEndingHere = 0
    var finalStart = 0 // final start index to return
    var finalEnd = 0 // final end index to return
    var tmpStart = 0
    for (i <- arr.indices) {
      maxSumEndingHere += arr(i)
      if (maxSumEndingHere < 0) {
        tmpStart = i + 1
        maxSumEndingHere = 0
      }
      if (maxSoFar < maxSumEndingHere) {
        finalStart = tmpStart
        finalEnd = i
        maxSoFar = maxSumEndingHere
      }
    }

    (finalStart, finalEnd)
  }

  override def main(args: Array[String]): Unit = {
    val arr = Array[Int](-2, -3, 4, -1, -2, 1, 5, -3)
    val (start, end) = maxSumContiguousArray(arr)

    for (i <- start to end) {
      print(arr(i) +" ")
    }
  }
}
