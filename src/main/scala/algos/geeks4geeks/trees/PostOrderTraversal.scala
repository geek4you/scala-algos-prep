package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/19/17.
  */

/**
 * Depth first traversal
 */
object PostOrderTraversal extends App {

  /**
    * Recursive PostOrder
    */
  def postOrderRecursive[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      postOrderRecursive(node.left)
      postOrderRecursive(node.right)
      println(node.data)
    }
  }

  /**
    * Post Oder using two Stacks - Iterative
    *  1. Push root to first stack.
    *  2. Loop while first stack is not empty
    *  2.1 Pop a node from first stack and push it to second stack
    *  2.2 Push left and right children of the popped node to first stack
    *  3. Print contents of second stack
    */
  def postOrder2Stacks[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val stack1 = new util.ArrayDeque[Node[A]]()
      val stack2 = new util.ArrayDeque[Node[A]]()
      stack1.push(node)
      while (!stack1.isEmpty) {
        val current = stack1.pop()
        stack2.push(current)
        if (Option(current.left).isDefined)
          stack1.push(current.left)
        if (Option(current.right).isDefined)
          stack1.push(current.right)
      }
      stack2.forEach(node => println(node.data))
    }
  }

  /**
    * Post Oder using single Stack - Iterative
    * 1.1 Create an empty stack
      2.1 Do following while root is not NULL
        a) Push root's right child and then root to stack.
        b) Set root as root's left child.
      2.2 Pop an item from stack and set it as root.
        a) If the popped item has a right child and the right child
          is at top of stack, then remove the right child from stack,
          push the root back and set root as root's right child.
        b) Else print root's data and set root as NULL.
      2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
    */
  def postOrder1Stack[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val stack = new util.ArrayDeque[Node[A]]()
      var current = node
      // Move to leftmost node
      do {
        while (Option(current).isDefined) {
          // Push current's right child and then root to stack.
          if (Option(current.right).isDefined)
            stack.push(current.right)
          stack.push(current)
          // Set current as current's left child
          current = current.left
        }
        // Pop an item from stack and set it as current
        current = stack.pop()
        // If the popped item has a right child and the right child is not
        // processed yet, then make sure right child is processed before root
        if (Option(current).isDefined && current.right == stack.peek()) {
          stack.pop() // remove right child from stack
          stack.push(current) // push root back to stack
          current = current.right // change root so that the right
          // child is processed next
        } else {
          // Else print root's data and set root as NULL
          println(current.data)
          current = null
        }
      } while (!stack.isEmpty)
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
    postOrderRecursive(root)
    println("Iterative 2 stacks")
    postOrder2Stacks(root)
    println("Iterative 1 stacks")
    postOrder1Stack(root)
  }
}
