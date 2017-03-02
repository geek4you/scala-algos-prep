package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/1/17.
  */

// todo: REVISIT
object MaximumDifferenceBetweenNodeAndItsAncestorInBinaryTree extends App {

  def maxDiffBtwNodeAndAncestors(node: Node[Int]): Int = {
    maxDiffBtwNodeAndAncestorsUtil(node, MaxDiff(0))
  }

  /**
    * returns the min node value from the sub-trees
    */
  def maxDiffBtwNodeAndAncestorsUtil(node: Node[Int], maxDiff: MaxDiff): Int = {

    if (Option(node).isDefined) {
      // leaf node return its value
      if (Option(node.left).isEmpty && Option(node.right).isEmpty) {
        node.data
      } else {
        // get min node from left sub tree
        val leftMin = maxDiffBtwNodeAndAncestorsUtil(node.left, maxDiff)
        val rightMin = maxDiffBtwNodeAndAncestorsUtil(node.right, maxDiff)

        val diff = node.data - Math.min(leftMin, rightMin)
        maxDiff.maxDiff = Math.max(maxDiff.maxDiff, diff)
        Math.min(node.data, Math.min(leftMin, rightMin))
      }
    } else
      Integer.MAX_VALUE
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(8)
    root.left = Node(3)
    root.left.left = Node(1)
    root.left.right = Node(6)
    root.left.right.left = Node(4)
    root.left.right.right = Node(7)
    root.right = Node(10)
    root.right.right = Node(14)
    root.right.right.left = Node(13)

    println(maxDiffBtwNodeAndAncestors(root))
  }

}

case class MaxDiff(var maxDiff: Int)
