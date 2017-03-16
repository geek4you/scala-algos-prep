package algos.epi.searching

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Page: 194
  */
object SearchAnEntryEqualToItsIndex {

  def search(input: Array[Int]): Int = {
    var (low, high) = (0, input.length - 1)

    while (low <= high) {
      val mid = (low + high) / 2

      if (input(mid) == mid)
        return mid
      else if (input(mid) > mid) {
        high = mid - 1
      } else
        low = mid + 1
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val input = Array(-2, 0, 2, 3, 6, 7, 9)
    println(search(input))
  }
}
