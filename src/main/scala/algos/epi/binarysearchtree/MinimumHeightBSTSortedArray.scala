package algos.epi.binarysearchtree

/**
  * Created by geek4you on 5/7/17.
  */
object MinimumHeightBSTSortedArray {

  def buildTree(sortedArray: Array[Int]): Node[Int] = {
    buildTreeHelper(sortedArray, 0, sortedArray.length - 1)
  }

  def buildTreeHelper(sortedArray: Array[Int],
                      start: Int,
                      end: Int): Node[Int] = {
    if (start > end)
      null
    else if (start == end)
      Node(sortedArray(start))
    else {
      val mid = start + (end - start) / 2
      val leftTree = buildTreeHelper(sortedArray, start, mid - 1)
      val rightTree = buildTreeHelper(sortedArray, mid + 1, end)
      Node(sortedArray(mid), leftTree, rightTree)
    }
  }

}
