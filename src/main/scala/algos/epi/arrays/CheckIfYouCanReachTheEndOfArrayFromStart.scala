package algos.epi.arrays

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/4/17.
  */
/**
  * Page: 68
  */
object CheckIfYouCanReachTheEndOfArrayFromStart {

  def check(arr: ArrayBuffer[Int]): Boolean = {
    var farthestSoFar = 0
    var i = 0
    var lastIndex = arr.length - 1

    // farthestSoFar represents the max pos you can go in the arr from ith index at the end of ith iteration.
    while (i < arr.length && i <= farthestSoFar && farthestSoFar < lastIndex) {
      farthestSoFar = Math.max(farthestSoFar, i + arr(i))
      i += 1
    }

    farthestSoFar >= lastIndex
  }

  def main(args: Array[String]): Unit = {
    val arr = new ArrayBuffer[Int]()
    arr ++= Array(3,1,0,2,0,1)
    println(check(arr))
  }
}
