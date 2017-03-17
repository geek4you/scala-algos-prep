package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/8/17.
  */
object MaxDifferenceBetweenTwoElementThatLargerElementAppearsAfterSmallerNumber extends App{

  def maxDiff(arr: Array[Int]): Int = {
    var minSoFar = arr(0)
    var maxDiff = Int.MinValue

    for (i <- 1 until arr.length) {
      minSoFar = Math.min(minSoFar, arr(i))

      maxDiff = Math.max(maxDiff, arr(i) - minSoFar)
    }

    maxDiff
  }

  override def main(args: Array[String]) {
    val arr = Array(1, 2, 6, 80, 100)
    println(maxDiff(arr))
  }
}
