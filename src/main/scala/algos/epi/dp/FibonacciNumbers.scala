package algos.epi.dp

import scala.collection.mutable

/**
  * Created by geek4you on 4/3/17.
  */
object FibonacciNumbers {

  private val cache = mutable.Map[Int, Int]()
  def fibonacci(n: Int): Int = {
    if (n <= 1)
      n
    else {
      if (!cache.contains(n)) {
        cache += (n -> (fibonacci(n - 2) + fibonacci(n - 1)))
      }
      cache(n)
    }
  }

  def fibonacciIterative(n: Int): Int = {
    if (n <= 1)
      n
    else {
      var fMinus2 = 0
      var fMinus1 = 1
      for (i <- 2 to n) {
        val tmp = fMinus1 + fMinus2
        fMinus2 = fMinus1
        fMinus1 = tmp
      }
      fMinus1
    }
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(7))
    println(fibonacciIterative(7))
  }
}
