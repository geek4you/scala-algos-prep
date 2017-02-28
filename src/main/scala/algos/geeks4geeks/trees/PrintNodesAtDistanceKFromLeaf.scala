package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/25/17.
  */
/**
  * Print all nodes that are at distance k from a leaf node
  * Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node.
  *
  * Here k distance from a leaf means k levels higher than a leaf node. For example if k is more than height of Binary Tree, then nothing should be printed. Expected time complexity is O(n) where n is the number nodes in the given Binary Tree.
  *
  * We strongly recommend to minimize the browser and try this yourself first.
  *
  * The idea is to traverse the tree. Keep storing all ancestors till we hit a leaf node. When we reach a leaf node, we print the ancestor at distance k. We also need to keep track of nodes that are already printed as output. For that we use a boolean array visited[].

C++Java

  */
// todo: REVISIT
object PrintNodesAtDistanceKFromLeaf {

  def printNodesAtDistKFromLeaf[A](node: Node[A],
                                   ancestors: Array[A],
                                   visited: Array[A],
                                   k: Int): Unit = {
  }
}
