package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/4/17.
  */
/**
  * Page: 68
  */
object CheckIfYouCanReachTheEndOfArrayFromStart {

  def check(arr: util.ArrayList[Int]): Boolean = {
    var farthestSoFar = 0
    var i = 0
    var lastIndex = arr.size() - 1

    // farthestSoFar represents the max pos you can go in the arr from ith index at the end of ith iteration.
    while (i <= farthestSoFar && farthestSoFar < lastIndex) {
      farthestSoFar = Math.max(farthestSoFar, i + arr.get(i))
      i += 1
    }

    farthestSoFar >= lastIndex
  }

  def main(args: Array[String]): Unit = {
    val arr = new util.ArrayList[Int]()
    arr.add(3)
    arr.add(3)
    arr.add(1)
    arr.add(0)
    arr.add(2)
    arr.add(0)
    arr.add(1)
    println(check(arr))
  }
}
