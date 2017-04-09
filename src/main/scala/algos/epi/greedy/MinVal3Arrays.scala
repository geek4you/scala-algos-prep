package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Google Interview Questions: Given three arrays, A, B, and C, what is the best algorithm to find the minimum value of
  * |a−b|+|b−c|+|c−a|, where  a∈A,b∈B,c∈C?
  * Assuming that the arrays are not sorted, here is an nlogn algorithm.
  * Sort the arrays A, B and C. Let there sizes be n,m and p.
  * let i,j,k =0 points to the start indices of the 3 arrays.
  * ans = INT_MAX;
  * while(i < n && j<m && k<p)
  * ans = min(ans, abs(A[i] - B[j]) + abs(B[j] - C[k]) + abs(C[k]-A[i]))
  * increment the index of minumum of A[i], B[j], C[k]
  * return ans
  */
object MinVal3Arrays {

  def minVal(input1: Array[Int],
             input2: Array[Int],
             input3: Array[Int]): MinGapElements = {
    val sortedInput1 = input1.sorted
    val sortedInput2 = input2.sorted
    val sortedInput3 = input3.sorted
    var (i1, i2, i3) = (0, 0, 0)
    var sum = Int.MaxValue
    var min = 0
    while (i1 < sortedInput1.length && i2 < sortedInput2.length && i3 < sortedInput3.length) {
      val localSum = Math.abs(sortedInput1(i1) - sortedInput2(i2)) + Math.abs(
        sortedInput2(i2) - sortedInput2(i3)) + Math.abs(
        sortedInput3(i3) - sortedInput1(i1))
      if (localSum < sum) {
        sum = localSum
      }

      min = Math.min(sortedInput1(i1),
                     Math.min(sortedInput2(i2), sortedInput3(i3)))
      if (min == sortedInput1(i1))
        i1 += 1
      if (min == sortedInput2(i2))
        i2 += 1
      if (min == sortedInput3(i3))
        i3 += 1

    }

    MinGapElements(i1, i2, i3, sum)
  }

  def main(args: Array[String]): Unit = {
    val input1 = Array(5, 7, 9, 11, 12, 20)
    val input2 = Array(4, 5, 11, 14, 16, 20)
    val input3 = Array(1, 3, 4, 8, 10, 20)
    println(minVal(input1, input2, input3))
  }

  case class MinGapElements(x: Int, y: Int, z: Int, sum: Int)
}
