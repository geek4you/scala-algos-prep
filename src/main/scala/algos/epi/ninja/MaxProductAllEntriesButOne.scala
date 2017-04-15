package algos.epi.ninja

/**
  * Created by geek4you on 4/14/17.
  */
/**
  * Page 445
  */
object MaxProductAllEntriesButOne {

  def maxProduct(input: Array[Int]): Int = {

    val suffixProducts = new Array[Int](input.length)
    var product = 1
    for (i <- suffixProducts.length - 1 to 0 by -1) {
      suffixProducts(i) = product
      product *= input(i)
    }

    var prefixProduct = 1
    var maxProd = Int.MinValue
    for (i <- input.indices) {
      maxProd = Math.max(maxProd, prefixProduct * suffixProducts(i))
      prefixProduct *= input(i)
    }
    maxProd
  }

  def spaceOptimizedMaxProduct(input: Array[Int]): Int = {
    var leastNonNegativeIdx = -1
    var numberOfNegatives = 0
    var greatestNegativeIdx = -1 // negative number which is biggest i.e with
    // Math.abs(input(greatestNegativeIdx)) smallest among negative numbers
    var leastNegativeIdx = -1 // negative number which is smallest i.e with
    // Math.abs(input(leastNegativeIdx)) largest among negative numbers

    // identify the above values

    for (i <- input.indices) {
      if (input(i) < 0) {
        numberOfNegatives += 1

        if (leastNegativeIdx == -1 || input(leastNegativeIdx) > input(i)) {
          leastNegativeIdx = i
        }

        if (greatestNegativeIdx == -1 || input(greatestNegativeIdx) < input(i)) {
          greatestNegativeIdx = i
        }
      } else if (input(i) >= 0) {
        if (leastNonNegativeIdx == -1 || input(leastNonNegativeIdx) > input(i))
          leastNonNegativeIdx = i
      }
    }

    val idxToSkip = if (numberOfNegatives % 2 != 0) {
      leastNegativeIdx
    } else {
      if (leastNonNegativeIdx != -1) {
        leastNonNegativeIdx
      } else {
        greatestNegativeIdx
      }
    }

    var product = 1
    input.indices.filter(_ != idxToSkip).foreach(product *= input(_))
    product
  }

  def main(args: Array[String]): Unit = {
    val input = Array(3, 2, 5, 4)
    println(maxProduct(input))
    val input1 = Array(3, 2, -1, 4, -1, 6)
    println(maxProduct(input1))
    println(spaceOptimizedMaxProduct(input))
    println(spaceOptimizedMaxProduct(input1))
  }
}
