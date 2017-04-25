package algos.crackingcodinginterview.recursionDP

import scala.collection.mutable

/**
  * Created by geek4you on 4/24/17.
  */
object NumberOfWaysClimbStairs {

  def numberOfWays(n: Int): Int = {
    val cache = mutable.Map[Int, Int]()
    directedNumberOfWays(n, cache)
  }

  def directedNumberOfWays(n: Int, cache: mutable.Map[Int, Int]): Int = {
    if (n < 0) 0
    else if (n == 0) 1
    else {
      if (!cache.contains(n)) {
        cache += (n -> (directedNumberOfWays(n - 1, cache) + directedNumberOfWays(
          n - 2, cache) + directedNumberOfWays(n - 3, cache)))
      }
      cache(n)
    }
  }

  def main(args: Array[String]): Unit = {
    println(numberOfWays(3))
  }
}
