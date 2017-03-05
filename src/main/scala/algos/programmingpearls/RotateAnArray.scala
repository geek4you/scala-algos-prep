package algos.programmingpearls

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * Page 11
  *
  * 1) copy first part i elems into a new array. move remaining elems in the array by i spaces.
  * Insert copied array at the last. Too much space
  * 2) move each elem one by one using a tmp. Too much time
  * 3) reverse first part. reverse second part. reverse both together.
  */
object RotateAnArray extends App {

  def rotateArrayByIPositions(arr: Array[Int], i: Int): Unit = {
    if (i <= arr.length - 1) {
      reverse(arr, 0, i - 1)
      reverse(arr, i, arr.length - 1)
      reverse(arr, 0, arr.length - 1)
    }
  }

  def reverse(arr: Array[Int], start: Int, end: Int): Unit = {
    var localStart = start
    var localEnd = end
    while (localStart < localEnd) {
      val tmp = arr(localStart)
      arr(localStart) = arr(localEnd)
      arr(localEnd) = tmp
      localStart += 1
      localEnd -= 1
    }
  }

  override def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7)
    println(arr.mkString(","))
    rotateArrayByIPositions(arr, 6)
    println(arr.mkString(","))
  }
}
