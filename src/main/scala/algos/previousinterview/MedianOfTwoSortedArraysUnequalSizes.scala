package algos.previousinterview

/**
  * Created by geek4you on 2/15/17.
  */
/**
  * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
  */
object MedianOfTwoSortedArraysUnequalSizes extends App{

  def medianOf2Numbers(num1: Int, num2: Int): Int = {
    (num1 + num2) / 2
  }

  def medianOf3Numbers(num1: Int, num2: Int, num3: Int): Int = {
    num1 + num2 + num3 - Math.max(num1, Math.max(num2, num3)) - Math.min(
      num1,
      Math.min(num2, num3))
  }

  def medianOf4Numbers(num1: Int, num2: Int, num3: Int, num4: Int): Int = {
    (num1 + num2 + num3 + num4 - Math.max(
      num1,
      Math.max(num2, Math.max(num3, num4))) - Math.min(
      num1,
      Math.min(num2, Math.min(num3, num4))))/2
  }

  override def main(args: Array[String]): Unit = {
  }

}
