package algos.epi.binarytrees

import scala.collection.mutable

/**
  * Created by geek4you on 5/6/17.
  */
/**
  * Page 166
  */
object TreeFromInorderAndPreorder {

  def buildTree(inOrder: Array[Int], preOrder: Array[Int]): Node[Int] = {
    val nodeToInorderIdx = scala.collection.mutable.Map[Int, Int]()
    for (i <- inOrder.indices) {
      nodeToInorderIdx += inOrder(i) -> i
    }
    buildTreeHelper(preOrder,
                    0,
                    preOrder.length,
                    0,
                    inOrder.length,
                    nodeToInorderIdx)
  }

  /**
    * Builds a subtree with
    * preorder.sublist(preOrderStart, preOrderEnd)
    * inoder.sublist(inOrderStart, inOrderEnd)
    */
  def buildTreeHelper(preOrder: Array[Int],
                      preOrderStart: Int,
                      preOrderEnd: Int,
                      inOrderStart: Int,
                      inOrderEnd: Int,
                      nodeToInorderIdx: mutable.Map[Int, Int]): Node[Int] = {

    if (preOrderEnd <= preOrderStart || inOrderEnd <= inOrderStart)
      null
    else {
      val rootInorderIdx = nodeToInorderIdx(preOrder(preOrderStart))
      val leftSubTreeSize = rootInorderIdx - inOrderStart
      Node(
        preOrder(preOrderStart),
        buildTreeHelper(preOrder,
                        preOrderStart + 1,
                        preOrderStart + 1 + leftSubTreeSize,
                        inOrderStart,
                        rootInorderIdx,
                        nodeToInorderIdx),
        buildTreeHelper(preOrder,
                        preOrderStart + leftSubTreeSize + 1,
                        preOrderEnd,
                        rootInorderIdx + 1,
                        inOrderEnd,
                        nodeToInorderIdx)
      )
    }

  }

}
