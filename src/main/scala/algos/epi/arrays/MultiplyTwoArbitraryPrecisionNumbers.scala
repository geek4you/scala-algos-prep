package algos.epi.arrays

import java.util

/**
  * Created by geek4you on 3/4/17.
  */
/**
  * Page 67
  */
object MultiplyTwoArbitraryPrecisionNumbers {

  def multiply(num1: util.List[Int], num2: util.List[Int]): util.List[Int] = {

    // total digits in the product of n digits X m digits = n + m digits
    val sign =
      if ((num1.get(0) ^ num2.get(0)) < 0)
        -1
      else
        1

    val result = new util.ArrayList[Int](
      util.Collections.nCopies(num1.size() + num2.size(), 0))

    for (i <- num1.size() - 1 to 0 by 1) {
      for (j <- num2.size() - 1 to 0 by 1) {
        result.set(i + j + 1,
                   result.get(i + j + 1) + num1.get(i) * num2.get(j))
        result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10)
        result.set(i + j + 1, result.get(i + j + 1) % 10)
      }
    }

    // Remove leading zeros
    var firstNotZero = 0
    while (firstNotZero < result.size() && result.get(firstNotZero) == 0) {
      firstNotZero += 1
    }

    val r = result.subList(firstNotZero, result.size())
    if (r.isEmpty) {
      util.Arrays.asList(0)
    } else {
      r.set(0, r.get(0) * sign)
      r
    }
  }

  def main(args: Array[String]): Unit = {
    val arr1 = util.Arrays.asList(1, 9, 3, 7, 0, 7, 7, 2, 1)
    val arr2 = util.Arrays.asList(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7)
    val result = multiply(arr1, arr2)
    result.forEach(x => println(x))
  }
}
