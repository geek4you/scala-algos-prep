package algos.geeks4geeks.trees

import scala.collection.mutable

/**
  * Created by geek4you on 2/27/17.
  */
/**
  * Print Nodes in Top View of Binary Tree
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
We strongly recommend to minimize your browser and try this yourself first.

The idea is to do something similar to vertical Order Traversal. Like vertical Order Traversal, we need to nodes of same horizontal distance together. We do a level order traversal so that the topmost node at a horizontal node is visited before any other node of same horizontal distance below it. Hashing is used to check if a node at given horizontal distance is seen or not.
  */
object TopViewBinaryTree extends App {

  def topViewOfABinaryTree[A](node: Node[A]): Unit = {

    if (Option(node).isDefined) {
      // store the vertical levels and print the first elem in the vertical list
      val hashSet = new mutable.HashSet[Int]()
      // queue stores node and vertical lvl of the node
      val queue = new mutable.Queue[(Node[A], Int)]()
      queue += ((node, 0))
      while (queue.nonEmpty) {
        val current = queue.dequeue()
        if (!hashSet.contains(current._2)) {
          hashSet.add(current._2)
          println(current._1.data)
        }
        if (Option(current._1.left).isDefined)
          queue += ((current._1.left, current._2 - 1))
        if (Option(current._1.right).isDefined)
          queue += ((current._1.right, current._2 + 1))
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.left.right.right = Node(5)
    root.left.right.right.right = Node(6)
    topViewOfABinaryTree(root)
  }
}
