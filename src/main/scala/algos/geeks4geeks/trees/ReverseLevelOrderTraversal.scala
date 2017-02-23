package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/20/17.
  */
/**
  * [[http://www.geeksforgeeks.org/reverse-level-order-traversal/]]
  */
object ReverseLevelOrderTraversal extends App {

  /**
    * The idea is to use a stack to get the reverse level order. If we do normal level order traversal and
    * instead of printing a node, push the node to a stack and then print contents of stack
    */
  def reverseLvlOrder[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val queue = new util.ArrayDeque[Node[A]]()
      val stack = new util.ArrayDeque[Node[A]]()

      queue.add(node)

      while (!queue.isEmpty) {
        val current = queue.poll()
        stack.push(current)
        if (Option(current.right).isDefined)
          queue.add(current.right)
        if (Option(current.left).isDefined)
          queue.add(current.left)

      }

      stack.forEach(x => println(x.data))
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

    reverseLvlOrder(root)
  }
}
