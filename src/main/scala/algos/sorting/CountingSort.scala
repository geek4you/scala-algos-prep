package algos.sorting

import java.util

/**
  * Created by geek4you on 2/17/17.
  */
/**
  * http://www.geeksforgeeks.org/counting-sort/
  */
object CountingSort extends App{

  def sort(arr: Array[Char]): Unit = {
    val len = arr.length

    // The output character array that will have sorted arr
    val output = new Array[Char](len)

    // Create a count array to store count of individual
    // characters and initialize count array as 0
    val counts = new Array[Int](256)
    util.Arrays.fill(counts, 0)

    // store count of each character
    for (i <- arr.indices) {
      counts(arr(i)) += 1
      println(counts(arr(i)))
      println(counts.mkString(" "))
    }

    // Change count[i] so that count[i] now contains actual
    // position of this character in output array
      for (i <- 1 until arr.length) {
      counts(i) += counts(i - 1)
    }

    // Build the output character array
    for (i <- output.indices) {
      output(counts(arr(i)) - 1) = arr(i)
      counts(arr(i)) -= 1
    }

    Array.copy(output, 0, arr, 0, output.length)
  }

  override def main(args: Array[String]): Unit = {
    val arr = Array('g', 'e', 'e', 'k', 's', 'f', 'o',
      'r', 'g', 'e', 'e', 'k', 's')
    sort(arr)
    println(arr.mkString(" "))
  }



}
