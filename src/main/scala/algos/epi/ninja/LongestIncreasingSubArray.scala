package algos.epi.ninja

/**
  * Created by geek4you on 4/14/17.
  */
/**
  * Page 448
  */
object LongestIncreasingSubArray {

  def findLongestIncreasingSubArray(input: Array[Int]): SubArray = {
    var ans = SubArray(0, 0)
    var maxLength = 1

    var i = 0
    while (i < input.length - maxLength) {
      // Backward check and skip if input(i-1) >= input(i)
      var isSkippable = false
      var j = i + maxLength
      while (j > i && !isSkippable) {
        if (input(j - 1) >= input(j)) {
          isSkippable = true
          i = j
        } else {
          j -= 1
        }
      }

      // forward check if it is not skippable
      if (!isSkippable) {
        i += maxLength
        while (i < input.length && input(i - 1) < input(i)) {
          i += 1
          maxLength += 1
        }
        ans = SubArray(i - maxLength, i - 1)
      }
    }
    ans
  }

  case class SubArray(start: Int, end: Int)

  def main(args: Array[String]): Unit = {
    val input = Array(2, 11, 3, 5, 13, 7, 19, 17, 23)
    println(findLongestIncreasingSubArray(input))
  }
}
