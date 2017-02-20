package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/19/17.
  */

/**
 * Depth first traversal
 */
object PreOrderTraversal extends App {

  /**
    * Recursive Preorder
    */
  def preOrderRecursive[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      println(node.data)
      preOrderRecursive(node.left)
      preOrderRecursive(node.right)
    }
  }

  /**
   * Iterative Preorder
   */
  def preOrder[A](node: Node[A]): Unit = {
    if(Option(node).isDefined){
      val stack = new util.ArrayDeque[Node[A]]()
      stack.push(node)
      while(!stack.isEmpty){
        val current = stack.pop()
        println(current.data)
        if(Option(current.right).isDefined)
          stack.push(current.right)
        if(Option(current.left).isDefined)
          stack.push(current.left)
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
    preOrderRecursive(root)
    println("Iterative")
    preOrder(root)
  }
}
