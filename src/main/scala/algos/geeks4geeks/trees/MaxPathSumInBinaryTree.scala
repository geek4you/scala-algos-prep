package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/28/17.
  */
/**
  * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
  *
  * For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child

The idea is to keep trace of four paths and pick up the max one in the end. An important thing to note is, root of every subtree need to return maximum path sum such that at most one child of root is involved. This is needed for parent function call. In below code, this sum is stored in ‘max_single’ and returned by the recursive function.
  * [[http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/]]
  */
// todo: REVISIT IMP
object MaxPathSumInBinaryTree extends App {

  def maxPathSum(node: Node[Int]): Int = {
    val max = MaxSeenSoFar(Integer.MIN_VALUE)
    maxPathSumUtil(node, max)
    max.max
  }

  /**
    *
    * @return max sum with either (node.data + left child involved) or (node.data + right child involved) or node itself
    */
  def maxPathSumUtil(node: Node[Int], maxSofar: MaxSeenSoFar): Int = {
    // base case
    if (Option(node).isEmpty) {
      0

    } else // if lead node
    if (Option(node.left).isEmpty && Option(node.right).isEmpty) {
      node.data
    } else {
      val maxSumThroughLeftChild = maxPathSumUtil(node.left, maxSofar)
      val maxSumThroughRightChild = maxPathSumUtil(node.right, maxSofar)

      /**
        * consider max of 4 options
        * 1) node.data itself
        * 2) node.data + left child involved
        * 3) node.data + right child involved
        * 4) node.data + left child involved + right child involved
        */
      maxSofar.max = max(
        node.data,
        maxSumThroughLeftChild,
        maxSumThroughRightChild,
        maxSumThroughLeftChild + maxSumThroughRightChild + node.data)

      /**
        * return max of 3 options
        * 1) node.data itself
        * 2) node.data + left child involved
        * 3) node.data + right child involved
        * parent node can use this info to calculate the max sum
        */
      Math.max(
        Math.max(maxSumThroughLeftChild, maxSumThroughRightChild) + node.data,
        node.data)
    }
  }

  def max(a: Int, b: Int, c: Int, d: Int): Int = {
    Math.max(a, Math.max(b, Math.max(c, d)))
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(10)
    root.left = Node(2)
    root.right = Node(10)
    root.left.left = Node(20)
    root.left.right = Node(1)
    root.right.right = Node(-25)
    root.right.right.left = Node(3)
    root.right.right.right = Node(4)
    println(maxPathSum(root))
  }

}

case class MaxSeenSoFar(var max: Int)
