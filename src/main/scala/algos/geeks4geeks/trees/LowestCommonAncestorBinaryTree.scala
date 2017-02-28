package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/21/17.
  */
/**
  * Following is simple O(n) algorithm to find LCA of n1 and n2.
  * 1) Find path from root to n1 and store it in a vector or array.
  * 2) Find path from root to n2 and store it in another vector or array
  * 3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.
  *
  * To check if the values exist in the tree, use boolean variables. Remember object items are static in scala
  *
  */

//todo: REVISIT
object LowestCommonAncestorBinaryTree extends App {
  var n1IsPresent = false
  var n2IsPresent = false

  def lca(node: Node[Int], n1: Int, n2: Int): Unit = {
    if (Option(node).isDefined) {
      val path1 = new util.ArrayDeque[Int]()
      val path2 = new util.ArrayDeque[Int]()
      if (storePathInList(node, n1, path1) && storePathInList(node, n2, path2)) {
        println(path1)
        println(path2)
        var i = 0
        var done = false
        var lcaCandidate = path1.peek()
        val size1 = path1.size()
        val size2 = path2.size()
        while (i < size1 && i < size2 && !done) {
          val p1 = path1.poll()
          val p2 = path2.poll()
          if (p1 == p2) {
            lcaCandidate = p1
            i += 1
          } else {
            done = true
            println(lcaCandidate)
          }
        }
      } else {
        new RuntimeException(s"One of $n1 / $n2 is not present in the tree !!")
      }
    }
  }

  // Finds the path from root node to given root of the tree, Stores the
  // path in a vector path[], returns true if path exists otherwise false
  def storePathInList(node: Node[Int],
                      key: Int,
                      path: util.ArrayDeque[Int]): Boolean = {
    if (Option(node).isEmpty) {
      false
    } else {
      // Store this node in path vector. The node will be removed if
      // not in path from root to k
      path.add(node.data)

      // See if the key is same as node's key
      if (node.data == key) {
        return true
      }

      // Check if k is found in left or right sub-tree
      if (storePathInList(node.left, key, path) ||
          storePathInList(node.right, key, path)) {
        return true
      }

      // If not present in subtree rooted with root, remove root from
      // path[] and return false
      path.pollLast()
      false
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    lca(root, 6, 7)
  }

}
