package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/19/17.
  */
/**
  * Depth first traversal
  */
object InOrderTraversal extends App {

  /**
    * Recursive Impl
    */
  def inorderRecursive[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      inorderRecursive(node.left)
      println(node.data)
      inorderRecursive(node.right)
    }
  }

  def inorder[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val stack = new util.ArrayDeque[Node[A]]()
      var current = node
      var done: Boolean = false

      while (!done) {
        // Reach the left most node of the current node
        Option(current) match {
          case Some(currentNode) =>
            // place pointer to a tree node on the stack before traversing the node's left subtree
            stack.push(currentNode)
            current = currentNode.left
          case None =>
            stack.isEmpty match {
              case false =>
                // backtrack from the empty subtree and visit the tNode
                // at the top of the stack; however, if the stack is empty,
                // you are done
                current = stack.pop()
                println(current.data)
                //we have visited the node and its left subtree.
                // Now, it's right subtree's turn
                current = current.right
              case true =>
                done = true
            }
        }
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(10)
    root.left = Node(8)
    root.right = Node(2)
    root.left.left = Node(3)
    root.left.right = Node(5)
    root.right.left = Node(2)

    println("Recursive")
    inorderRecursive(root)
    println("Iterative")
    inorder(root)
  }
}
