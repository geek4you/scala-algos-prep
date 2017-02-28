package algos.geeks4geeks.trees

/**
  * Created by aashii on 2/25/17.
  */
/**
  *
  * @link : http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
  * Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the numbers which are formed
  * from root to leaf paths.
  * <p>
  * For example consider the following Binary Tree.
  * <p>
  *            6
  *         /      \
  *        3          5
  *      /   \          \
  *     2     5          4
  *   /   \
  *  7     4
  * There are 4 leaves, hence 4 root to leaf paths:
  * Path                    Number
  * 6->3->2                   632
  * 6->3->5->7               6357
  * 6->3->5->4               6354
  * 6->5>4                    654
  * Answer = 632 + 6357 + 6354 + 654 = 13997
  * <p>
  * The idea is to do a preorder traversal of the tree. In the preorder traversal, keep track of the value calculated till
  * the current node, let this value be val. For every node, we update the val as val*10 plus node’s data.
  */

// todo: Revisit
object SumAllNumbersThatAreFormedFromRootToLeafPaths {

  def treePathsSumUtil(node: Node[Int], value: Int): Int = {
    // base
    if (Option(node).isEmpty)
      0
    else {
      // update val
      val newVal = 10 * value + node.data

      // if current node is leaf, return the current value of val
      if (Option(node.left).isEmpty && Option(node.right).isEmpty)
        value
      else {
        // recur sum of values for left and right subtree
        treePathsSumUtil(node.left, newVal) + treePathsSumUtil(node.right,
                                                               newVal)
      }
    }
  }

  def treePathsSum(node: Node[Int]): Int = {
    treePathsSumUtil(node, 0)
  }

  def main(args: Array[String]): Unit = {
    val root = Node(6)
    root.left = Node(3)
    root.right = Node(5)
    root.right.right = Node(7)
    root.left.left = Node(2)
    root.left.right = Node(5)
    root.right.right = Node(4)
    root.left.right.left = Node(7)
    root.left.right.right = Node(4)

    println(treePathsSum(root))
  }

}
