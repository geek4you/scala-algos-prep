package algos.sorting

/**
  * Created by geek4you on 2/14/17.
  */
object MergeSort extends App {

  def sort(arry: Array[Int]): Unit = {
    mergeSort(arry, 0, arry.length - 1)
  }

  private def mergeSort(arry: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      val mid = (high + low) / 2
      mergeSort(arry, low, mid)
      mergeSort(arry, mid + 1, high)
      merge(arry, low, mid, high)
    }
  }

  // Function to merge the two haves arr[l..m] and arr[m+1..h] of array arr[]
  private def merge(arry: Array[Int], low: Int, mid: Int, high: Int): Unit = {
    val tmpArry1 = new Array[Int](mid - low + 1)
    val tmpArry2 = new Array[Int](high - mid)

    Array.copy(arry, low, tmpArry1, 0, mid - low + 1)
    Array.copy(arry, mid + 1, tmpArry2, 0, high - mid)

    var i = 0
    var j = 0
    var k = low
    while (i < tmpArry1.length && j < tmpArry2.length) {
      tmpArry1(i) < tmpArry2(j) match {
        case true =>
          arry(k) = tmpArry1(i)
          k += 1
          i += 1
        case false =>
          arry(k) = tmpArry2(j)
          k += 1
          j += 1
      }
    }

    while (i < tmpArry1.length) {
      arry(k) = tmpArry1(i)
      i += 1
      k += 1
    }

    while (j < tmpArry2.length) {
      arry(k) = tmpArry2(j)
      j += 1
      k += 1
    }
  }

  override def main(args: Array[String]): Unit = {
    val arry = Array[Int](20, 16, 3, 5, 1, 12, 2, 1)
    sort(arry)
    print(arry.mkString(" "))
  }
}
