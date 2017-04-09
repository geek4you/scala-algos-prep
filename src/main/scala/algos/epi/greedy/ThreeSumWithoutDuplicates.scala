package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Page 345
  */
object ThreeSumWithoutDuplicates {

  def threeSum(input: Array[Int], sum: Int): Boolean = {

    // sort the array
    val sortedArray = input.sorted

    // fix the first elem and find the other two
    for (i <- 0 to input.length - 2) {
      var l = i + 1 // first elem in the remaining elements
      var r: Int = input.length - 1 // last elem in the remaining elements
      while (l < r) {
        if (input(i) + input(l) + input(r) == sum) {
          println(s"found at indices $i, $l, $r")
          return true
        } else if (input(i) + input(l) + input(r) < sum) {
          l += 1
        } else
          r -= 1
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val input = Array(11, 2, 5, 7, 3)
    println(threeSum(input, 15))
  }
}
