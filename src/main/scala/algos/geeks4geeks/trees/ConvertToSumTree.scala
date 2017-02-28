package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  * Convert a given tree to its Sum Tree
  * Given a Binary Tree where each node has positive and negative values.
  * Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree.
  * The values of leaf nodes are changed to 0.
  *
  * For example, the following tree
  *            10
  *         /      \
  *       -2        6
  *     /   \      /  \
  *    8     -4    7    5
  *
  *    should be changed to
  *
  *      20(4-2+12+6)
  *        /      \
  *    4(8-4)      12(7+5)
  *    /   \      /  \
  *  0      0    0    0
  */
// todo: REVIST
object ConvertToSumTree extends App {

  def convertToSumTree(node: Node[Int]): Int = {
    if (Option(node).isEmpty)
      0
    else {

      // Store the old value
      val nodeOldVal = node.data

      // Recursively call for left and right subtrees and store the sum as
      // new value of this node
      node.data = convertToSumTree(node.left) + convertToSumTree(node.right)

      // Return the sum of values of nodes in left and right subtrees and
      // old_value of this node
      nodeOldVal + node.data
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(10)
    root.left = Node(-2)
    root.right = Node(6)
    root.left.left = Node(8)
    root.left.right = Node(-4)
    root.right.left = Node(7)
    root.right.right = Node(5)
    convertToSumTree(root)
    PreOrderTraversal.preOrder(root)
  }
}
