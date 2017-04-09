package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
/*
Given 3 sorted arrays. Find(x,y,z), (where x is from 1st array, y is from 2nd array, and z is from 3rd array), such that
Max(x,y,z) - Min(x,y,z) is minimum.

  Time: O(n) since the arrays are already sorted.
  Time: O(nlogn) since the arrays are not sorted.
 */

object MAxMinDifferenceMinIn3Arrays {

  def minGap(input1: Array[Int],
             input2: Array[Int],
             input3: Array[Int]): MinGapElements = {
    var (i1, i2, i3) = (0, 0, 0)
    var (x, y, z) = (0, 0, 0)
    var diff = Int.MaxValue
    var (max, min) = (0, 0)
    while (i1 < input1.length && i2 < input2.length && i3 < input3.length) {
      max = Math.max(input1(i1), Math.max(input2(i2), input3(i3)))
      min = Math.min(input1(i1), Math.min(input2(i2), input3(i3)))

      if (diff > max - min) {
        diff = max - min
        x = i1
        y = i2
        z = i3
      }
      if (min == input1(i1))
        i1 += 1
      if (min == input2(i2))
        i2 += 1
      if (min == input3(i3))
        i3 += 1
    }
    MinGapElements(x, y, z, diff)
  }

  def main(args: Array[String]): Unit = {
    val input1 = Array(5, 7, 9, 11, 12, 20)
    val input2 = Array(4, 5, 11, 14, 16, 20)
    val input3 = Array(1, 3, 4, 8, 10, 20)
    println(minGap(input1,input2,input3))
  }

  case class MinGapElements(x: Int, y: Int, z: Int, diff: Int)
}
