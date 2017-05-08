package algos.epi.binarysearchtree

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 5/7/17.
  */
/**
  * Page 260
  */
object IsBST {

  def isBST(root: Node[Int]): Boolean = {
    isBSTHelper(root, Int.MinValue, Int.MaxValue)
  }

  def isBSTHelper(root: Node[Int], lower: Int, upper: Int): Boolean = {
    if (Option(root).isEmpty)
      true
    else {
      if (!Range(lower, upper).contains(root.data)) {
        isBSTHelper(root.left, lower, root.data) && isBSTHelper(root.right,
                                                                root.data,
                                                                upper)
      } else
        false
    }
  }

  def isBinaryTreeBST(root: Node[Int]): Boolean = {
    val bfsQueue = new ListBuffer[QueueEntry]()
    bfsQueue += QueueEntry(root, Int.MinValue, Int.MaxValue)

    var headEntry: QueueEntry = null
    while (bfsQueue.nonEmpty) {
      headEntry = bfsQueue.remove(0)
      if (headEntry.lowerBound > headEntry.node.data || headEntry.upperBound < headEntry.node.data)
        return false

      bfsQueue += QueueEntry(headEntry.node.left,
                             headEntry.lowerBound,
                             headEntry.node.data)
      bfsQueue += QueueEntry(headEntry.node.right,
                             headEntry.node.data,
                             headEntry.upperBound)
    }
    true
  }

  case class QueueEntry(node: Node[Int],
                        var lowerBound: Int,
                        var upperBound: Int)
}
