package algos.epi.arrays

/**
  * Created by geek4you on 3/4/17.
  */
/**
  * Page 67
  */
object MultiplyTwoArbitraryPrecisionNumbers {

  def multiply(num1: Array[Int], num2: Array[Int]): Array[Int] = {

    // total digits in the product of n digits X m digits = n + m digits
    val sign =
      if ((num1(0) ^ num2(0)) < 0)
        -1
      else
        1

    num1(0) = Math.abs(num1(0))
    num2(0) = Math.abs(num2(0))

    val result = Array.fill(num1.size + num2.size)(0)

    for (i <- num1.length - 1 to 0 by -1) {
      for (j <- num2.length - 1 to 0 by -1) {
        result(i + j + 1) = result(i + j + 1) + num1(i) * num2(j)
        result(i + j) = result(i + j) + result(i + j + 1) / 10
        result(i + j + 1) = result(i + j + 1) % 10
      }
    }

    // Remove leading zeros
    var firstNotZero = 0
    while (firstNotZero < result.length && result(firstNotZero) == 0) {
      firstNotZero += 1
    }

    val resultWithoutPrecedingZeros = result.filter(x => x != 0)

    if (sign == -1 && resultWithoutPrecedingZeros.nonEmpty)
      resultWithoutPrecedingZeros(0) = resultWithoutPrecedingZeros(0) * -1

    if (resultWithoutPrecedingZeros.isEmpty)
      Array(0)
    else resultWithoutPrecedingZeros

  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(7, 9)
    val arr2 = Array(7, 8, 9)
    println(multiply(arr1,arr2).mkString(""))
    val result = multiply(Array(-1, 2), Array(0))
    println(result.mkString(""))
  }

}
