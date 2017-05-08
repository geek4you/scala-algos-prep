package algos.epi.binarysearchtree

/**
  * Created by geek4you on 5/7/17.
  */
/**
  * Page 266
  */
object BSTFromPreOrder {

  var rootIdx = 0
  def buildBSTFromPreOrder(preOrder: Array[Int]): Node[Int] = {
    rootIdx = 0
    buildBSTFromPreOrderOnValueRange(preOrder, Int.MinValue, Int.MaxValue)
  }

  // Builds a BST on the subtree rooted at rootIdx from preOrder sequence on keys in (lowerBound, upperBound)
  def buildBSTFromPreOrderOnValueRange(preOrder: Array[Int],
                                       lowerBound: Int,
                                       upperBound: Int): Node[Int] = {

    if (rootIdx == preOrder.length)
      null
    else {
      val root = preOrder(rootIdx)
      if (!Range(lowerBound, upperBound).contains(root))
        null
      else {
        rootIdx += 1

        // note that buildBSTFromPreOrderOnValueRange updates the rootIdx. SO the order of the following two calls is critical.
        val leftSubTree =
          buildBSTFromPreOrderOnValueRange(preOrder, lowerBound, root)
        val rightSubTree =
          buildBSTFromPreOrderOnValueRange(preOrder, root, upperBound)

        Node(root, leftSubTree, rightSubTree)
      }
    }
  }
}
