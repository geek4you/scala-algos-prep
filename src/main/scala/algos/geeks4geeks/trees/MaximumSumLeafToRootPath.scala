package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  *  [[http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/]]
  * 1) First find the leaf node that is on the maximum sum path. In the following code getTargetLeaf()
  * does this by assigning the result to *target_leaf_ref.
  * 2) Once we have the target leaf node, we can print the maximum sum path by traversing the tree.
  * In the following code, printPath() does this.
  */
// todo: REVISIT
object MaximumSumLeafToRootPath extends App {

  var leafWithMaxSumPath: Node[Int] = _
  var maxSum: Int = Integer.MIN_VALUE

  /**
    * find leaf with max sum path
    */
  def findLeafWithMaxSum(node: Node[Int], sum: Int): Unit = {
    if (Option(node).isDefined) {

      findLeafWithMaxSum(node.left, sum + node.data)

      // if leaf
      if (Option(node.left).isEmpty && Option(node.right).isEmpty) {
        if (sum + node.data > maxSum) {
          maxSum = sum + node.data
          leafWithMaxSumPath = node
        }
      }

      findLeafWithMaxSum(node.right, sum + node.data)
    }
  }

  def printPath(node: Node[Int]): Boolean = {
    if (Option(node).isDefined) {

      if (node == leafWithMaxSumPath || printPath(node.left) || printPath(
            node.right)) {
        println(node.data)
        true
      } else
        false
    } else
      false
  }

  def printMaxSumPath(node: Node[Int]): Unit = {
    findLeafWithMaxSum(node, 0)
    printPath(node)

  }

  override def main(args: Array[String]): Unit = {
    val root = new Node(10)
    root.left = new Node(-2)
    root.right = new Node(7)
    root.left.left = new Node(8)
    root.left.right = new Node(-4)

    printMaxSumPath(root)
  }
}
