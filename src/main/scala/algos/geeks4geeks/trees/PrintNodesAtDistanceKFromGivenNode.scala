package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/27/17.
  */
/**
  * Print all nodes at distance k from a given node
Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target node. No parent pointers are available.

 There are two types of nodes to be considered.
1) Nodes in the subtree rooted with target node. For example if the target node is 8 and k is 2, then such nodes are 10 and 14.
2) Other nodes, may be an ancestor of target, or a node in some other subtree. For target node 8 and k is 2, the node 22 comes in this category.

Finding the first type of nodes is easy to implement. Just traverse subtrees rooted with the target node and decrement k in recursive call. When the k becomes 0, print the node currently being traversed (See this for more details). Here we call the function as printkdistanceNodeDown().

How to find nodes of second type? For the output nodes not lying in the subtree with the target node as the root, we must go through all ancestors. For every ancestor, we find its distance from target node, let the distance be d, now we go to other subtree (if target was found in left subtree, then we go to right subtree and vice versa) of the ancestor and find all nodes at k-d distance from the ancestor.

 [[http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/]]
  */

// todo: REVISIT and CODE
object PrintNodesAtDistanceKFromGivenNode extends App {

  /**
    * Prints the nodes at a distance k from the target node in the tree rooted at the target node.
    */
  def printNodesDown[A](node: Node[A], k: Int): Unit = {
    if (Option(node).isDefined && k > 0) {
      if (k == 0) {
        println(node.data)
      } else {
        printNodesDown(node.left, k - 1)
        printNodesDown(node.right, k - 1)
      }
    }
  }

  /**
    * Prints all nodes at distance k from a given target node.
    * The k distant nodes may be upward or downward.
    * This function returns distance of node from target node,
    * it returns -1 if target node is not present in tree rooted with root.
    */
  def printNodesAtDistK[A](node: Node[A], target: Node[A], k: Int): Int = {

    // Base Case 1: If tree is empty, return -1
    if (Option(node).isDefined) {
      // If target is same as root.  Use the downward function
      // to print all nodes at distance k in subtree rooted with
      // target or root
      if (node.data == target.data) {
        printNodesDown(node, k)
        return 0
      }

      // Recur for left subtree
      val distL = printNodesAtDistK(node.left, target, k)

      // Check if target node was found in left subtree
      if (distL != -1) {

        // If node is at distance k from target, print node
        // Note that distL is Distance of node's left child from
        // target
        if (distL + 1 == k) {
          print(node.data)
        } else
          // Else go to right subtree and print all k-distL-2 distant nodes
          // Note that the right child is 2 edges away from left child
          printNodesDown(node.right, k - distL - 2)

        // Add 1 to the distance and return value for parent calls
        return distL + 1
      }

      // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
      // Note that we reach here only when node was not found in left
      // subtree
      val distR = printNodesAtDistK(node.right, target, k)

      if (distR != -1) {
        if (distR + 1 == k) {
          println(node.data)
        } else
          // Else go to left subtree and print all k-distR-2 distant nodes
          // Note that the right child is 2 edges away from left child
          printNodesDown(node.left, k - distR - 2)

        // Add 1 to the distance and return value for parent calls
        return distR + 1
      }

      // If target was neither present in left nor in right subtree returnVal is -1
      return -1
    } else -1
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(20)
    root.left = Node(8)
    root.right = Node(22)
    root.left.left = Node(4)
    root.left.right = Node(12)
    root.left.right.left = Node(10)
    root.left.right.right = Node(14)
    val target = root.left.right
    printNodesAtDistK(root, target, 2)
  }
}
