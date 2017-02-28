package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/27/17.
  */
/**
  * http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
  *
  * We can find the maximum sum using single traversal of binary tree. The idea is to maintain two values in recursive calls
  * 1) Maximum root to leaf path sum for the subtree rooted under current node.
  * 2) The maximum path sum between leaves (desired output).
  *
  * For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X.
  * We add the two values with X.data, and compare the sum with maximum path sum found so far.
  *
  * We can find the maximum sum using single traversal of binary tree. The idea is to maintain two values in recursive calls
1) Maximum root to leaf path sum for the subtree rooted under current node.
2) The maximum path sum between leaves (desired output).

For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X. We add the two values with X->data, and compare the sum with maximum path sum found so far.

T(n) = O(n)
  */

// todo: revisit fix bug
object MaxPathSumBetweenTwoLeafNodesInBinaryTree extends App {

  def maxPathSumBtw2Leafs(node: Node[Int]): Int = {
    // Base case. when there is no node, sum is 0
    if (Option(node).isEmpty)
      return 0

    // when its a leaf node, sum is itself
    if (Option(node.left).isEmpty && Option(node.right).isEmpty)
      return node.data

    val ls = maxPathSumBtw2Leafs(node.left)
    val rs = maxPathSumBtw2Leafs(node.right)

    // If both left and right children exist
    if(Option(node.left).isDefined && Option(node.right).isDefined){
      MaxSoFar.maxSumSoFar = Math.max(MaxSoFar.maxSumSoFar, ls + rs + node.data)
      return node.data + Math.max(ls, rs)
    }

    // If any of the two children is empty, return
    // root sum for root being on one side
    if(Option(node.left).isDefined)
      return node.data + ls
    else
      return node.data + rs


  }

  override def main(args: Array[String]): Unit = {
    val root = Node(-15)
    root.left = Node(5)
    root.right = Node(6)
    root.left.left = Node(-8)
    root.left.right = Node(1)
    root.left.left.left = Node(2)
    root.left.left.right = Node(6)
    root.right.left = Node(3)
    root.right.right = Node(9)
    root.right.right.right = Node(0)
    root.right.right.right.left = Node(4)
    root.right.right.right.right = Node(-1)
    root.right.right.right.right.left = Node(10)
    println(maxPathSumBtw2Leafs(root))
  }

}

object MaxSoFar{
  var maxSumSoFar: Int = Integer.MIN_VALUE
}
