package algos.geeks4geeks.trees

import scala.collection.mutable

/**
  * Created by geek4you on 3/2/17.
  */
/**
  *Find largest subtree having identical left and right subtrees
Given a binary tree, find the largest subtree having identical left and right subtree. Expected complexity is O(n).

For example,

Input:
            50
         /      \
        10       60
       /  \     /   \
      5   20   70    70
               / \   / \
             65  80 65  80
Output:
 Largest subtree is rooted at node 60

 [[http://www.geeksforgeeks.org/find-largest-subtree-having-identical-left-and-right-subtrees/]]
  */
// todo: REVISIT IMP
object FindLargestSubTreeHavingIdenticalLeftAndRightSubTrees extends App {

  // Sets maxNumNodes to size of largest subtree with
  // identical left and right.  maxSize is set with
  // size of the maximum sized subtree. It returns
  // size of subtree rooted with current node. This
  // size is used to keep track of maximum size.
  def findLargestSubTreeUtil(node: Node[Int],
                             nodeHolder: NodeHolder,
                             maxNumNodes: MaxNumNodes,
                             str: mutable.StringBuilder): Int = {
    //base case
    if (Option(node).isEmpty)
      return 0

    // string to store structure of left and
    // right subtrees
    val leftStr = new mutable.StringBuilder()
    val rightStr = new mutable.StringBuilder()

    val leftSize =
      findLargestSubTreeUtil(node.left, nodeHolder, maxNumNodes, leftStr)
    val rightSize =
      findLargestSubTreeUtil(node.right, nodeHolder, maxNumNodes, rightStr)

    // total size of the tree rooted at this node
    val size = leftSize + 1 + rightSize

    // if left and right subtrees are similar
    // update maximum subtree if needed (Note that
    // left subtree may have a bigger value than
    // right and vice versa)
    if (leftSize == rightSize) {
      if (leftSize.compare(rightSize) == 0 && maxNumNodes.max < size) {
        maxNumNodes.max = size
        nodeHolder.node = node
      }
    }

    // append left subtree data
    str.append("|").append(leftSize).append("|")
    // append current node
    str.append("|").append(node.data).append("|")
    // append right subtree data
    str.append("|").append(rightSize).append("|")
    size
  }

  def findLargestSubTree(node: Node[Int]): Unit = {
    val nodeHolder = NodeHolder(null)
    val maxNumNodes = MaxNumNodes(0)
    findLargestSubTreeUtil(node,
                           nodeHolder,
                           maxNumNodes,
                           new mutable.StringBuilder(""))

    println(
      s"Max subtree is rooted at ${nodeHolder.node.data} and is of size ${maxNumNodes.max}")
  }

  override def main(args: Array[String]): Unit = {
    /* Let us construct the following Tree
                50
              /     \
             10      60
            / \     /  \
            5 20   70   70
                   / \  / \
                  65 80 65 80   */

    val root = Node(50)
    root.left = Node(10)
    root.right = Node(60)
    root.left.left = Node(5)
    root.left.right = Node(20)
    root.right.left = Node(70)
    root.right.left.left = Node(65)
    root.right.left.right = Node(80)
    root.right.right = Node(70)
    root.right.right.left = Node(65)
    root.right.right.right = Node(80)

    findLargestSubTree(node = root)
  }
}

case class MaxNumNodes(var max: Int)
case class NodeHolder(var node: Node[Int])
