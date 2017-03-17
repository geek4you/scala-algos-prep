package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/8/17.
  */
object SegregateEvenOdd {

  def segregate(arr: Array[Int]): Unit = {
    var (left, right) = (0, arr.length - 1)

    while (left < right) {
      while (arr(left) % 2 == 0 && left < right) {
        left += 1
      }

      while (arr(right) % 2 != 0 && left < right) {
        right += 1
      }

      if (left < right) {
        swap(arr, left, right)
        left += 1
        right -= 1
      }

    }
  }

  def swap(arr: Array[Int], index1: Int, index2: Int): Unit = {
    val tmp = arr(index1)
    arr(index1) = arr(index2)
    arr(index1) = tmp
  }
}
