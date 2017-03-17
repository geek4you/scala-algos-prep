package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/8/17.
  */
/**
  * [[http://www.geeksforgeeks.org/equilibrium-index-of-an-array/]]
  */
object EquibriumIndex {

  def equibriumIndex(arr: Array[Int]): Unit = {
    // get the total sum of the array
    var sum = arr.foldLeft(0)(_ + _)

    var leftSum = 0

    for (i <- arr.indices) {
      // get the right sum
      sum -= leftSum
      if (leftSum == sum) {
        return i
      }
      leftSum = leftSum + arr(i)
    }
    return -1
  }
}
