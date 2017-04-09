package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Page 344
  */
object ThreeSumProblem {

  def hasTwoSum(input: Array[Int], t: Int): Boolean = {
    var (i, j) = (0, input.length - 1)

    while (i < j) {
      if (input(i) + input(j) == t)
        return true

      if ((input(i) + input(j)) > t)
        i += 1
      else
        j -= 1
    }
    false
  }

  def threeSum(input: Array[Int], t: Int): Boolean = {
    val sortedInput = input.sorted
    for (i <- sortedInput.indices) {
      if (hasTwoSum(sortedInput, t - sortedInput(i)))
        return true
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val input = Array(11, 2, 5, 7, 3)
    println(threeSum(input, 15))
  }
}
