package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/23/17.
  */
/**
  * Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution)
Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. See following examples.

The following trees are examples of Complete Binary Trees
    1
  /   \
 2     3

       1
    /    \
   2       3
  /
 4

       1
    /    \
   2      3
  /  \    /
 4    5  6
The following trees are examples of Non-Complete Binary Trees
    1
      \
       3

       1
    /    \
   2       3
    \     /  \
     4   5    6

       1
    /    \
   2      3
         /  \
        4    5
Source: Write an algorithm to check if a tree is complete binary tree or not

The method 2 of level order traversal post can be easily modified to check whether a tree is Complete or not. To understand the approach, let us first define a term ‘Full Node’. A node is ‘Full Node’ if both left and right children are not empty (or not NULL).
The approach is to do a level order traversal starting from root. In the traversal, once a node is found which is NOT a Full Node, all the following nodes must be leaf nodes.
Also, one more thing needs to be checked to handle the below case: If a node has empty left child, then the right child must be empty.

    1
  /   \
 2     3
  \
   4
  */
// todo: REVISIT
object BinaryTreeCompleteCheck extends App {

  /**
    * iterative solution
    */
  def checkIfCompleteTree[A](node: Node[A]): Boolean = {
    if (Option(node).isDefined) {
      val queue = new util.LinkedList[Node[A]]()
      queue.add(node)
      var nonFullNodeFound = false
      while (!queue.isEmpty) {
        val current = queue.poll()
        if (nonFullNodeFound) {
          // non full node found
          // only leaf nodes should be found
          if (!isLeaf(current))
            return false
        } else {
          if (!isFullNode(current)) {
            nonFullNodeFound = true
            if (Option(current.right).isDefined)
              return false
          }
        }

        if(Option(current.left).isDefined)
          queue.add(current.left)
        if(Option(current.right).isDefined)
          queue.add(current.right)

      }
      true
    } else {
      true
    }
  }

  /**
    * node is full if it has both left and right child
    */
  def isFullNode[A](node: Node[A]): Boolean = {
    if (Option(node).isDefined) {
      if (Option(node.left).isDefined && Option(node.right).isDefined)
        true
      else
        false
    } else
      false
  }

  def isLeaf[A](node: Node[A]): Boolean = {
    if (Option(node).isEmpty)
      false
    if (Option(node.left).isEmpty && Option(node.right).isEmpty)
      true
    else
      false
  }

  override def main(args: Array[String]): Unit = {
    /* Let us construct the following Binary Tree which
    is not a complete Binary Tree
          1
        /   \
       2     3
      / \     \
     4   5     6
     */

    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)

    println(checkIfCompleteTree(root))
  }
}
