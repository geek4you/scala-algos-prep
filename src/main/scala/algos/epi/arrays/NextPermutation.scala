package algos.epi.arrays

/**
  * Created by geek4you on 3/6/17.
  */
/**
  * 1) find the position where the increasing sub sequence is broken from end.
  * 2) swap this element with the smallest element which is greater than this element on the right.
  * 3) reverse the second part of the array.
  */
object NextPermutation extends App{

  def nextPermutation(arr: Array[Int]): Array[Int] = {
    var k = arr.length - 2
    while (k >= 0 && arr(k) >= arr(k + 1)) {
      k -= 1
    }
    if (k != -1)
      return arr // arr is the last permutation.

    // swap the smallest entry after index k that is greater than arr[k]
    // we exploit the fact that arr[k+1 : arr.length-1] is decreasing so if we search in reverse order, the first entry
    // that is greater than arr[k] is the smallest entry
    var i = arr.length - 1
    var done = false
    while (i > k && done) {
      if (arr(i) > arr(k)) {
        swap(arr, i, k)
        done = true
      }
    }

    reverse(arr, k + 1, arr.length - 1)
    arr
  }

  def swap(arr: Array[Int], index1: Int, index2: Int): Unit = {
    val tmp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = tmp
  }

  def reverse(arr: Array[Int], index1: Int, index2: Int): Unit = {
    var i = index1
    var j = index2
    while (i < j) {
      swap(arr, i, j)
      i += 1
      j -= 1
    }
  }

  override def main(args: Array[String]): Unit = {
    val p = Array[Int](1, 0, 3, 2)
    println(nextPermutation(p).mkString(" "))
  }
}
