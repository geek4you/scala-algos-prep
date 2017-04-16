package algos.epi.ninja

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 467
  */
object SearchSortedArrayUnknownLength {

  def binarySearchUnknownLength(input: Array[Int], target: Int): Int = {
    // Find a range k exists if it is present
    var p = 0
    var break = false
    while (!break) {
      try {
        val idx = (1 << p) - 1 // 2^p -1
        if (input(idx) == target) {
          return idx
        } else if (input(idx) > target) {
          break = true
        }
      } catch {
        case e: IndexOutOfBoundsException => break = true
      }
      p += 1
    }

    // binary search between indices 2^(p-1) and 2^p-2, inclusive
    p -= 1
    var left = Math.max(0, 1 << (p - 1))
    var right = (1 << p) - 2
    while (left <= right) {
      val mid = left + (right - left) / 2
      try {
        if (input(mid) == target) {
          return mid
        } else if (input(mid) > target) {
          right = mid - 1
        } else {
          input(mid) < target
          left = mid + 1
        }
      } catch {
        case e: Exception => right = mid - 1 // search the left if out of bound
      }
    }
    -1 // nothing matched
  }

  def main(args: Array[String]): Unit = {
    val input = Array(1, 4, 5, 7, 8, 9, 12, 16, 18, 19)
    println(binarySearchUnknownLength(input, 18))
  }
}
