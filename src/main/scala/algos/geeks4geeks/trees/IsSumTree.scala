package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  * Check if a given Binary Tree is SumTree
  * Write a function that returns true if the given Binary Tree is SumTree else false.
  * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its
  * left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be
  * considered as 0. A leaf node is also considered as SumTree.
  *
  * Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
  */
object IsSumTree extends App {

  /**
    * Method1; T(n) : O(n2)
    * Get the sum of nodes in left subtree and right subtree. Check if the sum calculated is equal to root’s data.
    * Also, recursively check if the left and right subtrees are SumTrees.
    *
    * Method 2 ( Tricky )
    * The Method 1 uses sum() to get the sum of nodes in left and right subtrees.
    * The method 2 uses following rules to get the sum directly.
    * 1) If the node is a leaf node then sum of subtree rooted with this node is equal to value of this node.
    * 2) If the node is not a leaf node then sum of subtree rooted with this node is twice the value of this
    * node (Assuming that the tree rooted with this node is SumTree).
    *
    */
  // todo: REVISIT
  def isSumTree(node: Node[Int]): Boolean = {
    var ls = 0 // for sum of nodes in left subtree
    var rs = 0 // for sum of nodes in right subtree

    // If node is NULL or it's a leaf node then return true
    if (Option(node).isEmpty || isLeaf(node))
      true
    else if (isSumTree(node.left) && isSumTree(node.right)) {
      // Get the sum of nodes in left subtree
      if (Option(node.left).isEmpty)
        ls = 0
      else if (isLeaf(node.left))
        ls = node.left.data
      else
        ls = 2 * node.left.data

      // Get the sum of nodes in right subtree
      if (Option(node.right).isEmpty)
        rs = 0
      else if (isLeaf(node.right))
        rs = node.right.data
      else
        rs = 2 * node.right.data

      //If root's data is equal to sum of nodes in left and right subtrees then return true else return false
      if (node.data == (ls + rs))
        true
      else
        false
    } else
      false
  }

  def isLeaf[A](node: Node[A]): Boolean = {
    if (Option(node).isEmpty)
      false
    else if (Option(node.left).isEmpty && Option(node.right).isEmpty)
      true
    else
      false
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(26)
    root.left = Node(10)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(6)
    root.right.right = Node(3)

    println(isSumTree(root))
  }
}
