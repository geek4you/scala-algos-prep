package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
  * Print nodes at k distance from root
  * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
  * <p>
  * For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
  *         1
  *       /   \
  *     2      3
  *   /  \    /
  * 4     5  8
  */
object PrintNodesAtDistanceKFromRoot {
  def printNodes[A](node: Node[A], k: Int): Unit = {
    if (Option(node).isDefined && k>0) {
      if (k == 0)
        println(node.data)
      else {
        printNodes(node.left, k - 1)
        printNodes(node.right, k - 1)
      }
    }
  }
}
