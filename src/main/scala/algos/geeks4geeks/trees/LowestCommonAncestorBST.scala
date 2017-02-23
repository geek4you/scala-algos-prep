package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/21/17.
  */
/**
  * Given values of two nodes in a Binary Search Tree, write a c program to find the Lowest Common Ancestor (LCA).
  * You may assume that both the values exist in the tree.
  *
  * We can recursively traverse the BST from root. The main idea of the solution is, while traversing from top to bottom,
  * the first node n we encounter with value between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or n2, is LCA
  * of n1 and n2 (assuming that n1 < n2). So just recursively traverse the BST in, if node’s value is greater than both
  * n1 and n2 then our LCA lies in left side of the node, if it’s is smaller than both n1 and n2, then LCA lies on right
  * side. Otherwise root is LCA (assuming that both n1 and n2 are present in BST)
  *
  * T(n) = O(h) h is height of the tree
  * Space = O(h) because of recursion
  */
object LowestCommonAncestorBST extends App {
  def lcaRecursive(node: Node[Int], n1: Int, n2: Int): Int = {

    if (Option(node).isEmpty)
      throw new RuntimeException("no lca found !!")

    // if both x and y are smaller than root
    if (n1 < node.data && n2 < node.data)
      lcaRecursive(node.left, n1, n2)
    // both greater than x and y
    else if (n1 > node.data && n2 > node.data)
      lcaRecursive(node.right, n1, n2)
    else
      node.data

  }

  /**
    * Avoids stack space.
    * So space complexity is O(1)
    */
  def lcaIterative(node: Node[Int], n1: Int, n2: Int): Int = {
    var current = node
    var done = false
    while (Option(current).isDefined && !done) {
      if (n1 < current.data && n2 < current.data)
        current = current.left
      else if (n1 > current.data && n2 > current.data)
        current = current.right
      else
        done = true
    }
    current.data
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(20)
    root.left = Node(8)
    root.right = Node(22)
    root.left.left = Node(4)
    root.left.right = Node(12)
    root.left.right.left = Node(10)
    root.left.right.right = Node(14)
    println(lcaRecursive(root, 10, 14))
    println(lcaIterative(root, 10, 14))
  }

}
