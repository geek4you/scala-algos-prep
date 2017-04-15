package algos.epi.ninja

/**
  * Created by geek4you on 4/14/17.
  */
object FirstMissingPositiveInteger {

  def findFirstMissingPositive(input: Array[Int]): Int = {
    // record which values are present by writing input(i) to index input(i)-1 if input(i) is between
    // 1 to input.length, inclusive. We save the value at index input(i)-1 by swapping it with entry at i.
    //if input(i) is negative or greater than n, we just advance i.
    var i = 0
    while (i < input.length) {
      if (input(i) > 0 && input(i) <= input.length && input(input(i) - 1) != input(
            i)) {
        swap(input, i, input(i) - 1)
      } else {
        i += 1
      }
    }

    // second pass through input to search for the first index i such that input(i) != i + 1,
    // indicating that i+1 is absent. If all numbers between 1 and input.size() are present, the smallest
    // missing positive is input.size() + 1
    for (i <- input.indices) {
      if (input(i) != i + 1) {
        return i + 1
      }
    }
    input.length + 1
  }

  def swap(arr: Array[Int], idx1: Int, idx2: Int): Unit = {
    val tmp = arr(idx1)
    arr(idx1) = arr(idx2)
    arr(idx2) = tmp
  }

  def main(args: Array[String]): Unit = {
    val input = Array(3, 5, 4, -1, 5, 1, -1)
    println(findFirstMissingPositive(input))
  }

}
