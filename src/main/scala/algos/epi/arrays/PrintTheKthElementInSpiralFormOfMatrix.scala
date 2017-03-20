package algos.epi.arrays

/**
  * Created by geek4you on 3/5/17.
  */
/**
  * Page 90
  *
  *  consider the following for m x n matrix:
  *  1) k <= m  -> elem in top row
  *  2) k <= m + n - 1 -> elem in right most column
  *  3) k <= m + n - 1 + m - 1 -> elem in bottom row
  *  4) k <= m + n - 1 + m - 1 + n -2 -> elem in left column
  *  5) somewhere in the middle matrix
  *
  *  [[http://www.geeksforgeeks.org/print-kth-element-spiral-form-matrix/]]
  */
object PrintTheKthElementInSpiralFormOfMatrix {}
