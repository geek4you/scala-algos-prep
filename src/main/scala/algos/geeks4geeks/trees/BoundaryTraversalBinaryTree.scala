package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/20/17.
  */
/**
  * [[http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/]]
  * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
  */
/**
  * We break the problem in 3 parts:
  * 1. Print the left boundary in top-down manner.
  * 2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
  * …..2.1 Print all leaf nodes of left sub-tree from left to right.
  * …..2.2 Print all leaf nodes of right subtree from left to right.
  * 3. Print the right boundary in bottom-up manner.
  */
object BoundaryTraversalBinaryTree extends App {

  /**
    * Left boundary except leaf
    */
  def printLeftBoundaryTopDownExceptLeaf[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      var current = node
      while (Option(current).isDefined) {
        if (Option(current.left).isDefined) {
          println(current.data)
          current = current.left
        } else if (Option(current.right).isDefined) {
          println(current.data)
          current = current.right
        } else {
          current = null
        }
      }
    }
  }

  /**
    * Print leaves left to right
    */
  def printLeavesLeftToRight[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      if (Option(node.left).isEmpty && Option(node.right).isEmpty) {
        println(node.data)
      } else {
        printLeavesLeftToRight(node.left)
        printLeavesLeftToRight(node.right)
      }
    }
  }

  /**
    * Do not print root and leaf as they are already printed
    */
  def printRightBoundaryBottomUpExceptLeafAndRoot[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val stack = new util.ArrayDeque[Node[A]]()
      var current = node
      while (Option(current).isDefined) {
        if (Option(current.right).isDefined) {
          if (current != node)
            stack.push(current)
          current = current.right
        } else if (Option(current.left).isDefined) {
          if (current != node)
            stack.push(current)
          current = current.left
        } else {
          current = null
        }
      }
      stack.forEach(x => println(x.data))
    }
  }

  def printBoundary[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      printLeftBoundaryTopDownExceptLeaf(node)
      printLeavesLeftToRight(node)
      printRightBoundaryBottomUpExceptLeafAndRoot(node)
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(20)
    root.left = Node(8)
    root.left.left = Node(4)
    root.left.right = Node(12)
    root.left.right.left = Node(10)
    root.left.right.right = Node(14)
    root.right = Node(22)
    root.right.right = Node(25)

    printBoundary(root)
  }
}
