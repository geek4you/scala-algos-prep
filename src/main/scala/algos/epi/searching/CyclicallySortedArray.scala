package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Page 195
  */
object CyclicallySortedArray {

  def searchSmallestElement(input: Array[Int]): Int = {
    var (left, right) = (0, input.length - 1)
    while (left < right) {
      val mid = left + (right - left) / 2

      if (input(mid) > input(right)) {
        left = mid + 1
      } else if (input(mid) < input(right)) {
        right = mid
      }
    }
    // loop breaks when left == right
    left
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(378, 478, 550, 631, 700, 800, 807, 103, 203, 220, 234, 279, 368)
    println(searchSmallestElement(arr))
  }

}
